package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.util.JpaUtils;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Course;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.CourseRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.PojoMappingService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;
    private PojoMappingService pojoMappingService;

    public CourseRepositoryImpl(EntityManager entityManager, GeneralRepository generalRepository, PojoMappingService pojoMappingService) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
        this.pojoMappingService = pojoMappingService;
    }

    @Override
    public List<Course> findAll() {
        return JpaUtils.getResultList(entityManager, Course.class, (cb, cq) -> {
            Root<Course> r = cq.from(Course.class);
            cq.select(r);
        });
    }

    @Override
    public void add(Course course) {
        entityManager.merge(course);
    }

    @Override
    public List<Course> findAll(String searchText) {
        String select = "JSON { 'id' : ?subject, 'name' : ?name }\n" +
                "WHERE {\n" +
                "\t?subject courses:discipline_name ?name .\n" +
                "\tFILTER regex (?name \""+ searchText + "*\", \"i\") \n" +
                "}";
        String result = generalRepository.selectArq(searchText);
        Course [] courses = pojoMappingService.map(result, Course[].class);
        return Arrays.asList(courses);
    }

}
