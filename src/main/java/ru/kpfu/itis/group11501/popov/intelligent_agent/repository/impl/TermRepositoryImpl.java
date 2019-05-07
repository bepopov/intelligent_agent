package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.util.JpaUtils;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TermRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TermRepositoryImpl implements TermRepository {

    private EntityManager entityManager;

    public TermRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Term term) {
        entityManager.merge(term);
    }

    @Override
    public void addAll(List<Term> terms) {
        terms.forEach(term -> entityManager.merge(term));
    }

    @Override
    public List<Term> findAll() {
        return JpaUtils.getResultList(entityManager, Term.class, (cb, cq) -> {
            Root<Term> r = cq.from(Term.class);
            cq.select(r);
        });
    }


}
