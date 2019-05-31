package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescriptionGroup;

import java.util.List;

public interface TopicDescriptionGroupRepository {

    void add(TopicDescriptionGroup didacticUnitGroup);

    List<TopicDescriptionGroup> findNext(String id);

}
