package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnitGroup;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DidacticUnitGroupRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
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

    @Override
    public List<DidacticUnitGroup> findNext(String id) {
        String queryString =
                "SELECT ?id WHERE {\n" +
                        "  ?sub owllist:hasNext+ ?obj .\n" +
                        "  ?sub owllist:hasContents ?element .\n" +
                        "  ?element rdfs:label ?element_id .\n" +
                        "  ?obj owllist:hasContents/rdfs:label ?id\n" +
                        "  FILTER (?element_id = \"" + id + "\")\n" +
                        "}";
        return generalRepository.selectSparql(queryString, DidacticUnitGroup.class);
    }
}
