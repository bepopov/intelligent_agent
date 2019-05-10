package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Document;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TermCount;

import java.util.List;

public interface DocumentRepository {

    <T> List<Document> findAllDocument(Class<T> entity);

    <T> void addContainsIn(Term term, T entity);

    <T> List<TermCount> findAllTermCount(Class<T> entity);

}
