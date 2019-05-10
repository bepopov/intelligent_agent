package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import java.util.List;

public interface GeneralRepository {

    /*
    Создает связь между существующими объектами
    (у object и subject должны присутствовать все
    поля, участвующие в создании URI)
    */
    <T, E> void addTriple(T object, String predicate, E subject);

    String selectArq(String queryString);

    <T> List<T> selectSparql(String queryString, Class<T> entity);

}
