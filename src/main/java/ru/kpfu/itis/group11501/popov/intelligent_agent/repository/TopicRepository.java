package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;

import java.util.List;

public interface TopicRepository {

    void add(Topic topic);

    List<Topic> findAll();

    void remove(Topic topic);
}
