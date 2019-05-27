package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnitGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DidacticUnitGroupRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

import javax.persistence.EntityManager;

public class DidacticUnitGroupRepositoryImpl implements DidacticUnitGroupRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;

    public DidacticUnitGroupRepositoryImpl(EntityManager entityManager, GeneralRepository generalRepository) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
    }

    @Override
    public void add(DidacticUnitGroup didacticUnitGroup) {
        entityManager.merge(didacticUnitGroup);
    }
}
