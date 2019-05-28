package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.*;

import java.util.List;

public interface CourseService {

    void add(Course course,
             EducationPlan educationPlan,
             List<Topic> topics,
             List<DidacticUnitGroup> didacticUnits);

    List<Course> getAll(String searchText);

}
