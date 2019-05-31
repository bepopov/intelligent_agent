package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescription;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescriptionGroup;

import java.util.List;

public interface TopicDescriptionService {

    void add(List<TopicDescriptionGroup> didacticUnitGroups);

    void add(TopicDescriptionGroup didacticUnit);

    void add(TopicDescription didacticUnit);

    List<TopicDescriptionGroup> getNext(String id);

    List<TopicDescription> getByTopic(String topicId);

}
