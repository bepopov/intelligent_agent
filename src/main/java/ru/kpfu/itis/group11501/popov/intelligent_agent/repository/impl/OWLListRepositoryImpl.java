package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.annotation.DefaultIri;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.EmptyList;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.OWLList;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.OWLListImpl;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.OWLListRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
public class OWLListRepositoryImpl implements OWLListRepository {

    private EntityManager entityManager;
    private TemplateParserContext parserContext;
    private ExpressionParser expressionParser;
    private GeneralRepository generalRepository;

    public OWLListRepositoryImpl(EntityManager entityManager, TemplateParserContext parserContext, ExpressionParser expressionParser, GeneralRepository generalRepository) {
        this.entityManager = entityManager;
        this.parserContext = parserContext;
        this.expressionParser = expressionParser;
        this.generalRepository = generalRepository;
    }

    /*
    Добавить тройки для OWLList: hasNext, hasContents
     */
    @Override
    public <T> OWLList<T> add(List<T> elements) {
        OWLList<T> topicOWLList = new EmptyList<>();
        entityManager.merge(topicOWLList);
        for (T element : elements) {
            OWLList<T> elem = new OWLListImpl<>();
            elem.setId(UUID.randomUUID().toString());
            entityManager.merge(elem);
            generalRepository.addTriple(elem, "owllist:hasNext", topicOWLList);
            generalRepository.addTriple(elem, "owllist:hasContents", element);
            topicOWLList = elem;
        }

/*
        T first = elements.get(0);
        if (first != null) {
            DefaultIri iri = first.getClass().getAnnotation(DefaultIri.class);
            String iriString = iri.value();
            for (T element : elements) {
                OWLList<T> elem = new OWLListImpl<>();
                elem.setElement(element);
                elem.setId(UUID.randomUUID().toString());
                elem.setTail(topicOWLList);
                Expression elemExpression = expressionParser.parseExpression(iriString, parserContext);
                String idElem = (String) elemExpression.getValue(element);
                elem.setElemIri(idElem);
                topicOWLList = elem;
                entityManager.merge(elem);
            }

 */
        return topicOWLList;
    }

    @Override
    public <T> void getOWLList() {

    }
}
