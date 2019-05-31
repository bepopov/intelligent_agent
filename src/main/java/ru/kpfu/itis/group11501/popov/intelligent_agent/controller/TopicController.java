package ru.kpfu.itis.group11501.popov.intelligent_agent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.*;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.OWLListRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicDescriptionService;
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
    private TopicDescriptionService didacticUnitService;

    public TopicController(TopicService topicService, SearchService searchService, OWLListRepository owlListRepository, TopicDescriptionService didacticUnitService) {
        this.topicService = topicService;
        this.searchService = searchService;
        this.owlListRepository = owlListRepository;
        this.didacticUnitService = didacticUnitService;
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

    @RequestMapping("/add/du")
    @ResponseBody
    public String addDU() {
        TopicDescriptionGroup duGroup = new TopicDescriptionGroup();
        String [] strings = new String[] {
                "Мировоззрение как духовный способ освоения человеком наиболее общих взглядов на мир и место в нем",
                "Мифология, религия, научные основания и общие результаты познания, художественно-эстетические освоения природной и социальной среды.",
                "Особенности философии как теоретического мировоззрения.",
                "Принцип рефлексии и саморефлексии стержневая основа философии.",
                "Понятие \"картина мира\". ",
                "Религиозные, научные, философские картины мира."
        };
        List<TopicDescription> didacticUnits = new ArrayList<>();
        for (String string : strings) {
            TopicDescription du = new TopicDescription();
            du.setId(UUID.randomUUID().toString());
            du.setName(string);
            didacticUnits.add(du);
        }
        duGroup.setDidacticUnits(didacticUnits);
        didacticUnitService.add(duGroup);
        return "Completed!";
    }

    @RequestMapping("/du")
    @ResponseBody
    public List<Document> du() {
        String text = "Мировоззрение как духовная религия. Религиозный человек";
        List<Document> documents = searchService.searchGrouped(text, TopicDescription.class, TopicDescriptionGroup.class);
        return documents;
    }

}
