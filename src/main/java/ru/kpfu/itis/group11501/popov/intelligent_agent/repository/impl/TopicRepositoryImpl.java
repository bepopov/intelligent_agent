package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.util.JpaUtils;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TopicRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TopicRepositoryImpl implements TopicRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;

    public TopicRepositoryImpl(EntityManager entityManager, GeneralRepository generalRepository) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
    }

    @Override
    public void add(Topic topic) {
        entityManager.merge(topic);
    }

    @Override
    public List<Topic> findAll() {
        return JpaUtils.getResultList(entityManager, Topic.class, (cb, cq) -> {
            Root<Topic> r = cq.from(Topic.class);
            cq.select(r);
        });
    }

    @Override
    public void remove(Topic topic) {
        entityManager.remove(topic);
    }

    @Override
    public List<Topic> findNextTopics(String id) {
        String queryString =
                "SELECT ?id ?name WHERE {\n" +
                        "  ?sub owllist:hasNext+ ?obj .\n" +
                        "  ?sub owllist:hasContents ?element .\n" +
                        "  ?element rdfs:label ?element_id .\n" +
                        "  ?obj owllist:hasContents/course:name ?name .\n" +
                        "  ?obj owllist:hasContents/rdfs:label ?id\n" +
                        "  FILTER (?element_id = \"" + id + "\")\n" +
                        "}";
        return generalRepository.selectSparql(queryString, Topic.class);
    }


}
