package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.*;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.CourseRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.OWLListRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.CourseService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.DidacticUnitService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TopicService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private OWLListRepository owlListRepository;
    private TopicService topicService;
    private DidacticUnitService didacticUnitService;

    public CourseServiceImpl(CourseRepository courseRepository, OWLListRepository owlListRepository, TopicService topicService, DidacticUnitService didacticUnitService) {
        this.courseRepository = courseRepository;
        this.owlListRepository = owlListRepository;
        this.topicService = topicService;
        this.didacticUnitService = didacticUnitService;
    }

    @Override
    public void add(Course course,
                    String educationPlan,
                    List<Topic> topics,
                    List<DidacticUnitGroup> didacticUnitGroups) {
        courseRepository.add(course);
        topicService.add(topics);
        OWLList owlList = owlListRepository.add(topics);
        courseRepository.addTopics(course, owlList);
        didacticUnitService.add(didacticUnitGroups);
        owlList = owlListRepository.add(didacticUnitGroups);
        courseRepository.addDidacticUnits(course, owlList);
    }

    @Override
    public List<Course> getAll(String searchText) {
        if (searchText == null || searchText.isEmpty()) {
            return courseRepository.findAll();
        } else {
            return courseRepository.findAll(searchText);
        }
    }
}
