package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.*;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.TopicsApiService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicDescriptionService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.SearchService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TopicsApiServiceImpl implements TopicsApiService {

    private TopicService topicService;
    private TopicDescriptionService didacticUnitService;
    private SearchService searchService;

    public TopicsApiServiceImpl(TopicService topicService, TopicDescriptionService didacticUnitService, SearchService searchService) {
        this.topicService = topicService;
        this.didacticUnitService = didacticUnitService;
        this.searchService = searchService;
    }

    @Override
    public TopicDescription createDidacticUnitForTopic(UUID topicUuid, TopicDescription didacticUnit) {
        return null;
    }

    @Override
    public Topic createTopic(Topic topic) {
        return null;
    }

    @Override
    public TopicDescriptionGroup getDidacticUnits(UUID topicUuid) {
        List<TopicDescription> didacticUnits = didacticUnitService.getByTopic(topicUuid.toString())
                .stream().map(du -> {
                    TopicDescription didacticUnit = new TopicDescription();
                    didacticUnit.setId(UUID.fromString(du.getId()));
                    didacticUnit.setName(du.getName());
                    return didacticUnit;
                }).collect(Collectors.toList());
        TopicDescriptionGroup group = new TopicDescriptionGroup();
        ResultListTopicDescription resultList = new ResultListTopicDescription();
        resultList.setItems(didacticUnits);
        group.setTopicDescriptions(resultList);
        return group;
    }

    @Override
    public ResultListTopic getNextTopics(UUID topicUuid) {
        List<Topic> topics = topicService.findNext(topicUuid.toString())
                .stream().map(t -> {
                    Topic topic = new Topic();
                    topic.setName(t.getName());
                    topic.setId(UUID.fromString(t.getId()));
                    return topic;
                }).collect(Collectors.toList());
        ResultListTopic resultList = new ResultListTopic();
        resultList.setItems(topics);
        return null;
    }

    @Override
    public ResultListTopic getTopics(String searchText) {
        List<Topic> topics = searchService
                .search(searchText, ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic.class)
                .stream().map(doc -> {
                    Topic topic = new Topic();
                    topic.setId(UUID.fromString(doc.getId()));
                    topic.setName(doc.getContent());
                    return topic;
                }).collect(Collectors.toList());
        ResultListTopic resultList = new ResultListTopic();
        resultList.setItems(topics);
        return resultList;
    }
}
