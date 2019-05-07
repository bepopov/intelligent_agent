package ru.kpfu.itis.group11501.popov.intelligent_agent.controller;

import org.apache.jena.ext.xerces.util.URI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicService;

import java.util.List;
import java.util.UUID;

@Controller
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
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
        Topic topic = new Topic();
        topic.setName("Новая тема по математике");
        currentUuid = UUID.randomUUID();
        topic.setId(currentUuid.toString());
        topicService.add(topic);
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

}
