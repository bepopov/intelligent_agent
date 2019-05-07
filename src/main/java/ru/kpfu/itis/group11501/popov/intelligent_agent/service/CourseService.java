package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Course;

import java.util.List;

public interface CourseService {

    void add(Course course);

    List<Course> getAll();

}
