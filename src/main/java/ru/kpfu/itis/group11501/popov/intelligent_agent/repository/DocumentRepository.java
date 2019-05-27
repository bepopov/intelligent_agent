package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Document;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TermCount;

import java.util.List;

public interface DocumentRepository {

    <T> List<TermCount> findTermCounts(Class<T> entity, List<String> requestWords);

    <T> void addContainsIn(Term term, T entity);

    <T> Double averageDocLength(Class<T> entity);

    <T> Integer countDocuments(Class<T> entity);

    <T> List<Document> findDocuments(Class<T> entity, List<String> requestWords);

    <T, E> List<Document> findGroupedDocuments(Class<T> entity, Class<E> group, List<String> requestWords);

    <T, E> List<TermCount> findGroupedTermCounts(Class<T> entity, Class<E> group, List<String> requestWords);

}
