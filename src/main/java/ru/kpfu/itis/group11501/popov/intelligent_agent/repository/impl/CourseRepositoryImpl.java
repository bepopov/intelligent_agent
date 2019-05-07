package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.util.JpaUtils;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Course;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private EntityManager entityManager;

    public CourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = JpaUtils.getResultList(entityManager, Course.class, (cb, cq) -> {
            Root<Course> r = cq.from(Course.class);
            cq.select(r)
                .where(cb.equal(r.get("name"), "Mathematics"));
        });
        return courses;
    }

    @Override
    public void add(Course course) {
        entityManager.merge(course);
    }

}
