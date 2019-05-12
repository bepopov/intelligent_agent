package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Document;

import java.util.List;

public interface SearchService {

    <T> List<Document> search(String text, Class<T> entity);

}
