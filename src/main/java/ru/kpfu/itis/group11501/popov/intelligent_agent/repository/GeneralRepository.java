package ru.kpfu.itis.group11501.popov.intelligent_agent.repository;

import org.apache.jena.atlas.json.JsonArray;

public interface GeneralRepository {

    <T, E> void addTriple(Class<T> subject, String predicate, Class<E> object);

    String selectArq(String queryString);

    JsonArray selectSparql(String queryString);

}
