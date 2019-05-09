package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

public interface GeneralRepository {

    <T, E> void addTriple(Class<T> subject, String predicate, Class<E> object);

    String selectArq(String queryString);

}
