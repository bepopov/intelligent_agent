package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TermCount;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DocumentRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TermRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.SearchService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TermService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BM25FSearchService implements SearchService {

    private DocumentRepository documentRepository;
    private TermService termService;

    public BM25FSearchService(DocumentRepository documentRepository, TermService termService) {
        this.documentRepository = documentRepository;
        this.termService = termService;
    }


    @Override
    public <T> void search(String text, Class<T> entity) {
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
        List<TermCount> termCounts = documentRepository.findTermCounts(entity, requestWords);
    }

}
