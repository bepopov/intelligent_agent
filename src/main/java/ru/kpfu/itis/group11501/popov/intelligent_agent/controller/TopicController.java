package ru.kpfu.itis.group11501.popov.intelligent_agent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DocumentRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicService;

import java.util.List;
import java.util.UUID;

@Controller
public class TopicController {

    private TopicService topicService;
    private DocumentRepository documentRepository;

    public TopicController(TopicService topicService, DocumentRepository documentRepository) {
        this.topicService = topicService;
        this.documentRepository = documentRepository;
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
        Topic topic2 = new Topic();
        topic2.setName("Тема 1. Философия в ряду других форм духовного освоения мира человеком");
        currentUuid = UUID.randomUUID();
        topic2.setId(currentUuid.toString());
        topicService.add(topic2);
        Topic topic3 = new Topic();
        topic3.setName("Данная учебная дисциплина включена в раздел \" Б1.Б.1 Дисциплины (модули)\" основной образовательной программы 09.03.03 Прикладная информатика и относится к базовой (общепрофессиональной) части. Осваивается на 2 курсе, 4 семестр");
        currentUuid = UUID.randomUUID();
        topic3.setId(currentUuid.toString());
        topicService.add(topic3);
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
    public Long count() {
        return documentRepository.countDocument(Topic.class);
    }

}
