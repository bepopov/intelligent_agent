package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.core.SparqlService;
import org.aksw.jena_sparql_api.core.utils.UpdateRequestUtils;
import org.aksw.jena_sparql_api.mapper.annotation.DefaultIri;
import org.apache.jena.atlas.json.*;
import org.apache.jena.query.*;
import org.apache.jena.update.UpdateRequest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.config.PropertiesHolder;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;


import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GeneralRepositoryImpl implements GeneralRepository {

    private SparqlService sparqlService;
    private TemplateParserContext parserContext;
    private ExpressionParser expressionParser;

    public GeneralRepositoryImpl(SparqlService sparqlService, TemplateParserContext parserContext, ExpressionParser expressionParser) {
        this.sparqlService = sparqlService;
        this.parserContext = parserContext;
        this.expressionParser = expressionParser;
    }

    @Override
    public <T, E> void addTriple(T subject, String predicate, E object) {
        DefaultIri defaultIriSubject = subject.getClass().getAnnotation(DefaultIri.class);
        DefaultIri defaultIriObject = object.getClass().getAnnotation(DefaultIri.class);

        String iriExpSubject = defaultIriSubject.value();
        String iriExpObject = defaultIriObject.value();

        Expression expressionSubject = expressionParser.parseExpression(iriExpSubject, parserContext);
        String idSubject = (String) expressionSubject.getValue(subject);

        Expression expressionObject = expressionParser.parseExpression(iriExpObject, parserContext);
        String idObject = (String) expressionObject.getValue(object);

        String triple = String.format(
                "Insert Data { %s %s %s }",
                idSubject,
                predicate,
                idObject
        );
        triple = addPrefix(triple);
        UpdateRequest request = UpdateRequestUtils.parse(triple);
        sparqlService
                .getUpdateExecutionFactory()
                .createUpdateProcessor(request)
                .execute();
    }

    /*
    Запросы осуществляются с помощью синтаксиса ARQ (собственный Apache
    Jena). Внимание: агрегация в JSON-запросе не работает, используйте
    метод selectSparql.
     */
    @Override
    public String selectArq(String queryString) {
        queryString = addPrefix(queryString);
        Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
        return executeSelect(query);
    }

    /*
    Этот метод служит для отправления SELECT-запроса. Маппинг происходит
    по названию сеттеров, поэтому убедитесь, что в queryString лежат
    соответствующие названия полей.
    Если Document имеет поле text, то SELECT-запрос должен начинаться с:
    SELECT ?text ...
    TODO: Добавить маппинг для атрибутов составных типов
     */
    @Override
    public <T> List<T> selectSparql(String queryString, Class<T> entity) {
        JsonArray jsonArray = selectSparql(queryString);
        try {
            List<T> instances = new ArrayList<>();
            for (JsonValue jsonValue : jsonArray) {
                T instance = entity.newInstance();
                Method[] methods = entity.getMethods();
                for (Method method : methods) {
                    method.setAccessible(true);
                    if (isSetter(method)) {
                        String key = method.getName().substring(3).toLowerCase();
                        JsonValue valuePresent = jsonValue.getAsObject().get(key);
                        if (valuePresent == null) {
                            continue;
                        }
                        String value = valuePresent.getAsObject()
                                .get("value").getAsString().value();
                        boolean isInteger = Arrays
                                .stream(method.getParameterTypes())
                                .allMatch(p -> p.equals(Integer.class));
                        if (isInteger) {
                            method.invoke(instance, Integer.valueOf(value));
                        } else {
                            method.invoke(instance, value);
                        }
                    }
                }
                instances.add(instance);
            }
            return instances;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    private JsonArray selectSparql(String queryString) {
        queryString = addPrefix(queryString);
        Query query = QueryFactory.create(queryString, Syntax.syntaxSPARQL_11);
        QueryExecution queryExecution = sparqlService.getQueryExecutionFactory().createQueryExecution(query);
        ResultSet resultSet = queryExecution.execSelect();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ResultSetFormatter.outputAsJSON(outputStream, resultSet);
        String json = new String(outputStream.toByteArray());
        JsonValue object = JSON.parseAny(json);
        return object.getAsObject().get("results").getAsObject().get("bindings").getAsArray();
    }

    private String selectParam(String queryString) {
        JsonArray result = selectSparql(queryString);
        return result.get(0).getAsObject().get("param").getAsObject().get("value").getAsString().value();
    }

    @Override
    public Double selectDouble(String queryString) {
        String result = selectParam(queryString);
        return Double.valueOf(result);
    }

    @Override
    public Integer selectInteger(String queryString) {
        String result = selectParam(queryString);
        return Integer.valueOf(result);
    }

    private String addPrefix(String queryString) {
        return String.format("PREFIX %s: <%s>\n" +
                        "PREFIX %s: <%s>\n" + queryString,
                "course", PropertiesHolder.COURSES_ONTOLOGY,
                "rdfs", PropertiesHolder.RDFS);
    }

    private String executeSelect(Query query) {
        QueryExecution queryExecution = sparqlService.getQueryExecutionFactory().createQueryExecution(query);
        JsonArray array = queryExecution.execJson();
        return array.toString();
    }

    public boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }
}
