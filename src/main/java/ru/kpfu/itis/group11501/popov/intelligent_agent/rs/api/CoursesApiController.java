package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.Course;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListCourse;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.CourseService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-07T14:49:56.665+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi.cCreator.base-path:}")
public class CoursesApiController implements CoursesApi {

    private final NativeWebRequest request;
    private CourseService courseService;

    @org.springframework.beans.factory.annotation.Autowired
    public CoursesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<ResultListCourse> getAllCourses(@Valid String searchText) {
        List<Course> courses = courseService
                .getAll(searchText)
                .stream()
                .map(c -> {
                            Course course = new Course();
                            course.setId(UUID.fromString(c.getId()));
                            course.setName(c.getName());
                            return course;
                }).collect(Collectors.toList());
        ResultListCourse listCourse = new ResultListCourse();
        listCourse.setItems(courses);
        return ResponseEntity.ok().body(listCourse);
    }
}
