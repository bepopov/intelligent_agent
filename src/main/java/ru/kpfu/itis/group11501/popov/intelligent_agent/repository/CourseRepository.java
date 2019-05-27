package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Course;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.OWLList;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();

    void add(Course course);

    List<Course> findAll(String searchText);

    void addDidacticUnits(Course course, OWLList didacticUnits);

    void addTopics(Course course, OWLList topics);

}
