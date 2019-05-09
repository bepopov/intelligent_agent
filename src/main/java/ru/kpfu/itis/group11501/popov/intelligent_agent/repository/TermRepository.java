package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import org.aksw.jena_sparql_api.mapper.impl.type.RdfTypeMap;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Topic;

import java.util.List;

public interface TermRepository {

    void add(Term term);

    void addAll(List<Term> terms);

    List<Term> findAll();

    void addContainsIn(Term term, Topic topic);
}
