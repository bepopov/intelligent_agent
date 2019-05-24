package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;

import java.util.List;

public interface TermRepository {

    void addAll(List<Term> terms);

    List<Term> findAll();

}
