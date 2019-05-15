package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.OWLList;

import java.util.List;

public interface OWLListRepository {

    <T> OWLList<T> add(List<T> elements);

    <T> void getOWLList();

}
