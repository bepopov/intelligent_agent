package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.EducationPlan;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.EducationPlanRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class EducationPlanRepositoryImpl implements EducationPlanRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;

    public EducationPlanRepositoryImpl(EntityManager entityManager, GeneralRepository generalRepository) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
    }

    @Override
    public void add(EducationPlan educationPlan) {
        educationPlan.setId(UUID.randomUUID().toString());
        entityManager.merge(educationPlan);
    }
}
