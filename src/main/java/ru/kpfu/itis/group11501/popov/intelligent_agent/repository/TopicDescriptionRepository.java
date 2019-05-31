package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescription;

import java.util.List;

public interface TopicDescriptionRepository {

    void add(TopicDescription didacticUnit);

    List<TopicDescription> findByGroup(String groupId);

    List<TopicDescription> findByTopic(String topicId);
}
