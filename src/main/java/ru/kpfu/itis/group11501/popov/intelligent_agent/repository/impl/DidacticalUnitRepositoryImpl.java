package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnitGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DidacticUnitRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
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

    @Override
    public List<DidacticUnit> findByGroup(String groupId) {
        String queryString =
                "SELECT ?id ?name WHERE {\n" +
                        "  ?subject course:groupedTo ?group .\n" +
                        "  ?group rdfs:label ?groupid .\n" +
                        "  ?subject rdfs:label ?id .\n" +
                        "  ?subject course:name ?name\n" +
                        "  FILTER (?groupid = \"" + groupId + "\")" +
                        "}";
        return generalRepository.selectSparql(queryString, DidacticUnit.class);
    }

    @Override
    public List<DidacticUnit> findByTopic(String topicId) {
        // TODO: Implement the method
        return null;
    }
}
