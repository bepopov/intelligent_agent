package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.EducationPlan;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.EducationPlanRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.EducationPlanService;

import java.util.List;

@Service
public class EducationPlanServiceImpl implements EducationPlanService {

    private EducationPlanRepository educationPlanRepository;

    public EducationPlanServiceImpl(EducationPlanRepository educationPlanRepository) {
        this.educationPlanRepository = educationPlanRepository;
    }

    @Override
    public void add(EducationPlan educationPlan) {
        educationPlanRepository.add(educationPlan);
    }

    @Override
    public List<EducationPlan> getAll() {
        return educationPlanRepository.findAll();
    }
}
