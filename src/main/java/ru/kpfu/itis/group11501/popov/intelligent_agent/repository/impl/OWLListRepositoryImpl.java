package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.EmptyList;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.OWLList;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.OWLListImpl;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.OWLListRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Repository
public class OWLListRepositoryImpl implements OWLListRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;

    public OWLListRepositoryImpl(EntityManager entityManager, GeneralRepository generalRepository) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
    }

    /*
    Добавить тройки для OWLList: hasNext, hasContents
     */
    @Override
    public <T> OWLList add(List<T> elements) {
        elements = Lists.reverse(elements);
        OWLList topicOWLList = new EmptyList();
        entityManager.merge(topicOWLList);
        for (T element : elements) {
            OWLList elem = new OWLListImpl();
            elem.setId(UUID.randomUUID().toString());
            entityManager.merge(elem);
            generalRepository.addTriple(elem, "owllist:hasNext", topicOWLList);
            generalRepository.addTriple(elem, "owllist:hasContents", element);
            topicOWLList = elem;
        }
        return topicOWLList;
    }

}
