package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Document;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TermCount;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DocumentRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.SearchService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TermService;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.log;

@Service
public class BM25FSearchService implements SearchService {

    private DocumentRepository documentRepository;
    private TermService termService;
    private static final double K1 = 1.2;
    private static final double B = 0.75;
    private static final int MAX_RESULT_COUNT = 10;

    public BM25FSearchService(DocumentRepository documentRepository, TermService termService) {
        this.documentRepository = documentRepository;
        this.termService = termService;
    }

    @Override
    public <T> List<Document> search(String text, Class<T> entity) {
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
         */
        List<String> requestWords = termService.extractTerms(text);
        List<Document> documents = documentRepository.findDocuments(entity, requestWords);
        if (documents.size() != 0) {

            List<TermCount> termCounts = documentRepository.findTermCounts(entity, requestWords);
            Double averageLength = documentRepository.averageDocLength(entity);
            Integer countDocuments = documentRepository.countDocuments(entity);

            Map<String, Map<String, TermCount>> documentMap = getDocumentMap(termCounts);
            List<Double> requestWordVector = calculateIdfForRequest(requestWords, termCounts, countDocuments);

            for (Document document : documents) {
                double score = 0;
                for (String requestWord : requestWords) {
                    int index = requestWords.indexOf(requestWord);
                    double termFreq;
                    TermCount termCount = documentMap.get(document.getId()).get(requestWord);
                    if (termCount == null) {
                        termFreq = 0;
                    }
                    else {
                        termFreq = (double) termCount.getTermCount() / document.getWordCount();
                    }
                    score += requestWordVector.get(index)
                            * (termFreq * (K1 + 1))
                            / (termFreq + K1 * (1 - B + B * document.getWordCount() / averageLength));
                }
                document.setScore(score);
            }
            return documents.stream()
                    .sorted(Comparator.comparing(Document::getScore).reversed())
                    .limit(MAX_RESULT_COUNT)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private Map<String, Map<String, TermCount>> getDocumentMap(List<TermCount> termCounts) {
        Map<String, Map<String, TermCount>> documentMap = new HashMap<>();
        for (TermCount termCount : termCounts) {
            Map<String, TermCount> termCountMap = documentMap.get(termCount.getDocId());
            if (termCountMap == null) {
                termCountMap = new HashMap<>();
                termCountMap.put(termCount.getTerm(), termCount);
                documentMap.put(termCount.getDocId(), termCountMap);
            }
            else {
                termCountMap.put(termCount.getTerm(), termCount);
            }
        }
        return documentMap;
    }

    private List<Double> calculateIdfForRequest(List<String> requestWords,
                                                List<TermCount> termCounts,
                                                Integer countDocuments) {
        Map<String, Integer> termInAllArticles = new HashMap<>();
        List<Double> idfVector = new ArrayList<>();
        for (TermCount termCount : termCounts) {
            String term = termCount.getTerm();
            termInAllArticles.merge(term, 1, Integer::sum);
        }
        for (String requestWord : requestWords) {
            double idf = log((countDocuments - termInAllArticles.get(requestWord) + 0.5)
                    / (termInAllArticles.get(requestWord) + 0.5));
            idf = Math.max(idf, 0);
            idfVector.add(idf);
        }
        return idfVector;
    }
}
