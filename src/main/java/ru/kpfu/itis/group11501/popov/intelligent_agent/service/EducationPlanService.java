package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.EducationPlan;

import java.util.List;

public interface EducationPlanService {

    void add(EducationPlan educationPlan);

    List<EducationPlan> getAll();
}
