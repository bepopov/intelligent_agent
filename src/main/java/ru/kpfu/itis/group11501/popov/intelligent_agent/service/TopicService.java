package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;

import java.util.List;

public interface TopicService {

    void add(Topic topic);

    void add(List<Topic> topics);

    List<Topic> getAll();

    void delete(Topic topic);
}
