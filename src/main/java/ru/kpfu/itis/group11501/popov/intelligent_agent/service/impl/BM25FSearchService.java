package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.LemmatisationService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.SearchService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.WordExtractionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BM25FSearchService implements SearchService {

    private WordExtractionService extractionService;
    private LemmatisationService lemmatisationService;

    public BM25FSearchService(WordExtractionService extractionService, LemmatisationService lemmatisationService) {
        this.extractionService = extractionService;
        this.lemmatisationService = lemmatisationService;
    }

    @Override
    public void search(String text) {
        List<String> requestWords = extractionService.getWordsFromText(text);
        requestWords = requestWords.stream()
                .map(word -> lemmatisationService.lemmatise(word))
                .collect(Collectors.toList());
    }
}
