package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.CreateCourse;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.EducationPlan;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListEducationPlan;

import java.util.UUID;

public interface InstitutesApiService {

    void createCourse(UUID instituteUuid, UUID directionUuid, CreateCourse createCourse);

    void createEducationPlan(UUID instituteUuid, UUID directionUuid, EducationPlan educationPlan);

    ResultListEducationPlan getAllEducationPlans(UUID instituteUuid, UUID directionUuid);

}
