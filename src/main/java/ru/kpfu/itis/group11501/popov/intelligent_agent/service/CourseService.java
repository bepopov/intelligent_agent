package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.*;

import java.util.List;

public interface CourseService {

    void add(Course course,
             String educationPlan,
             List<Topic> topics,
             List<TopicDescriptionGroup> didacticUnits);

    List<Course> getAll(String searchText);

}
