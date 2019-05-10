package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;

import java.util.List;

public interface TermService {

    <T> List<Term> extractAndSaveTerms(String text, T entity);

}
