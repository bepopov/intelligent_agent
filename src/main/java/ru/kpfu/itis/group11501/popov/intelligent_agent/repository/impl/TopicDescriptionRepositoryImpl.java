package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescription;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TopicDescriptionRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TopicDescriptionRepositoryImpl implements TopicDescriptionRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;

    public TopicDescriptionRepositoryImpl(EntityManager entityManager, GeneralRepository generalRepository) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
    }

    @Override
    public void add(TopicDescription didacticUnit) {
        entityManager.merge(didacticUnit);
    }

    @Override
    public List<TopicDescription> findByGroup(String groupId) {
        String queryString =
                "SELECT ?id ?name WHERE {\n" +
                        "  ?subject course:groupedTo ?group .\n" +
                        "  ?group rdfs:label ?groupid .\n" +
                        "  ?subject rdfs:label ?id .\n" +
                        "  ?subject course:name ?name\n" +
                        "  FILTER (?groupid = \"" + groupId + "\")" +
                        "}";
        return generalRepository.selectSparql(queryString, TopicDescription.class);
    }

    @Override
    public List<TopicDescription> findByTopic(String topicId) {
        // TODO: Implement the method
        return null;
    }
}
