package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.core.SparqlService;
import org.apache.jena.atlas.json.JsonArray;
import org.apache.jena.query.*;
import ru.kpfu.itis.group11501.popov.intelligent_agent.config.PropertiesHolder;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

public class GeneralRepositoryImpl implements GeneralRepository {

    private SparqlService sparqlService;

    public GeneralRepositoryImpl(SparqlService sparqlService) {
        this.sparqlService = sparqlService;
    }

    @Override
    public <T, E> void addTriple(Class<T> subject, String predicate, Class<E> object) {
        /*
        EntityOps subjectOps = entityOpsFactory.apply(subject);
        DefaultIri subjectIri = .findAnnotation(DefaultIri.class);
        String addContains = String.format(
                "Prefix course: %s " + "Insert Data { course:%s course:%s course:%s }",
                "<" + PropertiesHolder.COURSES_ONTOLOGY + ">",
                "term" + term.getText(),
                predicate,
                "topic" + topic.getId()
        );
        UpdateRequest request = UpdateRequestUtils.parse(addContains);
        sparqlService
                .getUpdateExecutionFactory()
                .createUpdateProcessor(request)
                .execute();

         */
    }

    @Override
    public String selectArq(String queryString) {
        queryString = addPrefix(queryString);
        Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
        return executeSelect(query);
    }

    private String addPrefix(String queryString) {
        return "PREFIX courses: <"
                + PropertiesHolder.COURSES_ONTOLOGY
                + "> " + queryString;
    }

    private String executeSelect(Query query) {
        QueryExecution queryExecution = sparqlService.getQueryExecutionFactory().createQueryExecution(query);
        JsonArray array = queryExecution.execJson();
        return array.toString();
    }
}
