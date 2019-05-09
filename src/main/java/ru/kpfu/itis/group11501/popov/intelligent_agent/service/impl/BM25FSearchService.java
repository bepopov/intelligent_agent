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
    public void search(List<String> searchingWords, List<String> list) {
        /*
        Определиться, как будет вестись поиск: по всем параметрам сразу или по-отдельности?
        Есть задача поиска похожего топика.
        1. Найти IDF для каждого слова
        а.) Посчитать количество документов, в которые входит слово
        б.) Посчитать общее количество документов
        2. Найти частоту слова в каждом документе
        3. Посчитать количество слов в каждом документе
        4. Посчитать среднее количество слов в каждом документе
        5. Вычислить по формуле

        TermBM25Counter<T extends Document<S>> содержит информацию о том:
        1. Map<Term, List<TermCount>>
        TermCount содержит информацию о том:
        1. количество вхождений Term
        2. Document<S>
        3. Term
        Document<S> содержит информацию о том:
        1. в какой сущности производится поиск (Topic, DidacticalUnit, e.g.)
        2. сколько слов в документе
         */
    }

    @Override
    public List<String> getSearchingWords(String text) {
        List<String> requestWords = extractionService.getWordsFromText(text);
        requestWords = requestWords.stream()
                .map(word -> lemmatisationService.lemmatise(word))
                .collect(Collectors.toList());
        return requestWords;
    }
}
