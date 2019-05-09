package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.util.JpaUtils;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Document;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DocumentRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.PojoMappingService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;
    private PojoMappingService mappingService;

    public DocumentRepositoryImpl(EntityManager entityManager,
                                  GeneralRepository generalRepository,
                                  PojoMappingService mappingService) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
        this.mappingService = mappingService;
    }

    @Override
    public <T> List<Document<T>> findAll(Class<T> entity) {
        List<T> individuals = JpaUtils.getResultList(entityManager, entity, (cb, cr) -> {
            Root<T> r = cr.from(entity);
            cr.select(r);
        });
        return individuals.stream()
                .map(individual -> new Document<>(individual, 0))
                .collect(Collectors.toList());
    }

    @Override
    public <T> Long countDocument(Class<T> entity) {
        String query = "JSON { 'subject' : ?subject, 'name' : ?name }\n" +
                "WHERE {\n" +
                "\t?subject courses:discipline_name ?name .\n" +
                //"\t?subject courses:discipline_name \"Mathematics\" \n" +
                "}";
        generalRepository.selectArq(query);

        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(entity)));
        return entityManager.createQuery(cq).getSingleResult();
        /*Long count = JpaUtils.getSingleResult(entityManager, Long.class, (cb, cr) ->
                cr.select(cb.count(cr.from(entity))));
        return count;
         */
    }

    @Override
    public <T> void addContainsIn(Term term, Class<T> entity) {

    }

}
