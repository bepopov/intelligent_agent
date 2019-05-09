package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.core.SparqlService;
import org.aksw.jena_sparql_api.core.utils.UpdateRequestUtils;
import org.aksw.jena_sparql_api.core.utils.UpdateUtils;
import org.aksw.jena_sparql_api.mapper.util.JpaUtils;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.modify.request.UpdateCreate;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.config.PropertiesHolder;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TermRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TermRepositoryImpl implements TermRepository {

    private EntityManager entityManager;
    private SparqlService sparqlService;

    public TermRepositoryImpl(EntityManager entityManager, SparqlService sparqlService) {
        this.entityManager = entityManager;
        this.sparqlService = sparqlService;
    }

    @Override
    public void add(Term term) {
        entityManager.merge(term);
    }

    @Override
    public void addAll(List<Term> terms) {
        terms.forEach(term -> entityManager.merge(term));
    }

    @Override
    public List<Term> findAll() {
        return JpaUtils.getResultList(entityManager, Term.class, (cb, cq) -> {
            Root<Term> r = cq.from(Term.class);
            cq.select(r);
        });
    }

    @Override
    public void addContainsIn(Term term, Topic topic) {
        String addContains = String.format(
                "Prefix course: %s " + "Insert Data { course:%s course:%s course:%s }",
                "<" + PropertiesHolder.COURSES_ONTOLOGY + ">",
                "term" + term.getText(),
                "containsIn",
                "topic" + topic.getId()
                );
        UpdateRequest request = UpdateRequestUtils.parse(addContains);
        sparqlService
                .getUpdateExecutionFactory()
                .createUpdateProcessor(request)
                .execute();
    }


}
