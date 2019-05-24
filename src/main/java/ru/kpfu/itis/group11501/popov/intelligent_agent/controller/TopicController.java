package ru.kpfu.itis.group11501.popov.intelligent_agent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.EmptyList;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.OWLList;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.OWLListImpl;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.OWLListRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.SearchService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TopicController {

    private TopicService topicService;
    private SearchService searchService;
    private OWLListRepository owlListRepository;

    public TopicController(TopicService topicService, SearchService searchService, OWLListRepository owlListRepository) {
        this.topicService = topicService;
        this.searchService = searchService;
        this.owlListRepository = owlListRepository;
    }

    @RequestMapping("/topics")
    @ResponseBody
    public List<Topic> getTopics() {
        return topicService.getAll();
    }
    private UUID currentUuid;

    @RequestMapping("/topics/add")
    @ResponseBody
    public String addTopic() {

        String [] strings = new String[] {
                "А", "Б", "В", "Г", "Д", "Е"
        };
        List<Topic> topics = new ArrayList<>();
        for (String string : strings) {
            Topic topic = new Topic();
            topic.setName(string);
            currentUuid = UUID.randomUUID();
            topic.setId(currentUuid.toString());
            topicService.add(topic);
            topics.add(topic);
        }
        owlListRepository.add(topics);
        return "Тема успешно добавлена";
    }


    @RequestMapping("/topics/delete")
    @ResponseBody
    public String deleteTopic() {
        Topic topic = new Topic();
        topic.setName("Новая тема по математике");
        topic.setId(currentUuid.toString());
        topicService.delete(topic);
        return "Тема успешно добавлена";
    }

    @RequestMapping("/topic/count")
    @ResponseBody
    public Integer count() {
        return 1;
    }

}
