package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

import java.util.List;

public interface SearchService {

    <T> void search(List<String> searchingWords, List<String> list, Class<T> entity);

    List<String> getSearchingWords(String words);

}
