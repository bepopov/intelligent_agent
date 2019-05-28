package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.CreateCourse;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.EducationPlan;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListCompetence;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListEducationPlan;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.InstitutesApiService;

import javax.validation.Valid;
import java.util.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T12:04:30.405+03:00[Europe/Moscow]")

@CrossOrigin("http://localhost:63342")
@Controller
@RequestMapping("${openapi.intelligentAgent.base-path:}")
public class InstitutesApiController implements InstitutesApi {

    private final NativeWebRequest request;
    private InstitutesApiService apiService;


    @org.springframework.beans.factory.annotation.Autowired
    public InstitutesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<CreateCourse> createCourse(UUID instituteUuid, UUID directionUuid, @Valid CreateCourse createCourse) {
        apiService.createCourse(instituteUuid, directionUuid, createCourse);
        return ResponseEntity.ok().body(createCourse);
    }

    @Override
    public ResponseEntity<EducationPlan> createEducationPlan(UUID instituteUuid, UUID directionUuid, @Valid EducationPlan educationPlan) {
        apiService.createEducationPlan(instituteUuid, directionUuid, educationPlan);
        return ResponseEntity.ok().body(educationPlan);
    }

    @Override
    public ResponseEntity<ResultListCompetence> getAllCompetences(UUID instituteUuid, UUID directionUuid, UUID degreeUuid) {
        return null;
    }

    @Override
    public ResponseEntity<ResultListEducationPlan> getAllEducationPlans(UUID instituteUuid, UUID directionUuid) {
        ResultListEducationPlan plans = apiService.getAllEducationPlans(instituteUuid, directionUuid);
        return ResponseEntity.ok().body(plans);
    }
}
