package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

public interface SearchService {

    <T> void search(String text, Class<T> entity);

}
