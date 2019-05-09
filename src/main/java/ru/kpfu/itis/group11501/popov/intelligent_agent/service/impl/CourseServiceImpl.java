package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Course;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.CourseRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void add(Course course) {
        courseRepository.add(course);
    }

    @Override
    public List<Course> getAll(String searchText) {
        if (searchText == null || searchText.isEmpty()) {
            return courseRepository.findAll();
        }
        else {
            return courseRepository.findAll(searchText);
        }
    }
}
