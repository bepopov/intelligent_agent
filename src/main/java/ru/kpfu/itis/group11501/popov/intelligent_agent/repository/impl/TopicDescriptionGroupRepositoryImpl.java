package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescriptionGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TopicDescriptionGroupRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TopicDescriptionGroupRepositoryImpl implements TopicDescriptionGroupRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;

    public TopicDescriptionGroupRepositoryImpl(EntityManager entityManager, GeneralRepository generalRepository) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
    }

    @Override
    public void add(TopicDescriptionGroup didacticUnitGroup) {
        entityManager.merge(didacticUnitGroup);
    }

    @Override
    public List<TopicDescriptionGroup> findNext(String id) {
        String queryString =
                "SELECT ?id WHERE {\n" +
                        "  ?sub owllist:hasNext+ ?obj .\n" +
                        "  ?sub owllist:hasContents ?element .\n" +
                        "  ?element rdfs:label ?element_id .\n" +
                        "  ?obj owllist:hasContents/rdfs:label ?id\n" +
                        "  FILTER (?element_id = \"" + id + "\")\n" +
                        "}";
        return generalRepository.selectSparql(queryString, TopicDescriptionGroup.class);
    }
}
