package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DidacticUnitRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

import javax.persistence.EntityManager;

public class DidacticalUnitRepositoryImpl implements DidacticUnitRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;

    public DidacticalUnitRepositoryImpl(EntityManager entityManager, GeneralRepository generalRepository) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
    }

    @Override
    public void add(DidacticUnit didacticUnit) {
        entityManager.merge(didacticUnit);
    }
}
