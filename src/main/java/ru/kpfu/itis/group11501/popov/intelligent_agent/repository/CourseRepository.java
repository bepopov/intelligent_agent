package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();

    void add(Course course);
}
