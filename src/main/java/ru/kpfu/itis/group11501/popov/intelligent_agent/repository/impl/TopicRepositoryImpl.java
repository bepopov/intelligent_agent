package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.util.JpaUtils;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TopicRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TopicRepositoryImpl implements TopicRepository {

    private EntityManager entityManager;

    public TopicRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
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


}
