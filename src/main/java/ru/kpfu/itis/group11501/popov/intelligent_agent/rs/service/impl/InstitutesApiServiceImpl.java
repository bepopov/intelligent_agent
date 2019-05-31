package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.impl;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Course;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescription;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TopicDescriptionGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.CreateCourse;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.EducationPlan;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListEducationPlan;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.InstitutesApiService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.CourseService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.EducationPlanService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InstitutesApiServiceImpl implements InstitutesApiService {

    private TaskScheduler taskScheduler;
    private CourseService courseService;
    private EducationPlanService educationPlanService;

    public InstitutesApiServiceImpl(TaskScheduler taskScheduler, CourseService courseService, EducationPlanService educationPlanService) {
        this.taskScheduler = taskScheduler;
        this.courseService = courseService;
        this.educationPlanService = educationPlanService;
    }

    @Override
    public void createCourse(UUID instituteUuid, UUID directionUuid, CreateCourse createCourse) {
        Runnable task = () -> {
            Course course = new Course();
            course.setName(createCourse.getName());
            List<Topic> topics = createCourse.getTopics().getItems().stream()
                    .map(t -> {
                        Topic topic = new Topic();
                        topic.setName(t.getName());
                        return topic;
                    }).collect(Collectors.toList());
            List<TopicDescriptionGroup> didacticUnits = createCourse.getDidacticUnits().getItems().stream()
                    .map(du -> {
                        TopicDescriptionGroup group = new TopicDescriptionGroup();
                        List<TopicDescription> didacticUnitList = new ArrayList<>();
                        TopicDescription didacticUnit = new TopicDescription();
                        didacticUnit.setName(du.getName());
                        didacticUnitList.add(didacticUnit);
                        group.setDidacticUnits(didacticUnitList);
                        return group;
                    }).collect(Collectors.toList());
            courseService.add(course, createCourse.getEducationPlan().toString(), topics, didacticUnits);
        };
        taskScheduler.schedule(task, new Date());
    }

    @Override
    public void createEducationPlan(UUID instituteUuid, UUID directionUuid, EducationPlan educationPlan) {
        ru.kpfu.itis.group11501.popov.intelligent_agent.model.EducationPlan plan =
                new ru.kpfu.itis.group11501.popov.intelligent_agent.model.EducationPlan();
        plan.setName(educationPlan.getName());
        educationPlanService.add(plan);
    }

    @Override
    public ResultListEducationPlan getAllEducationPlans(UUID instituteUuid, UUID directionUuid) {
        List<ru.kpfu.itis.group11501.popov.intelligent_agent.model.EducationPlan> plans =
                educationPlanService.getAll();
        ResultListEducationPlan listEducationPlan = new ResultListEducationPlan();
        List<EducationPlan> educationPlans = plans.stream()
                .map(plan -> {
                    EducationPlan educationPlan = new EducationPlan();
                    educationPlan.setName(plan.getName());
                    return educationPlan;
                }).collect(Collectors.toList());
        listEducationPlan.setItems(educationPlans);
        return listEducationPlan;
    }
}
