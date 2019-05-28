package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.EducationPlan;

import java.util.List;

public interface EducationPlanRepository {

    void add(EducationPlan educationPlan);

    List<EducationPlan> findAll();
}
