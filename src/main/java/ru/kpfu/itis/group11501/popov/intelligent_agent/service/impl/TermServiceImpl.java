package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TermRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.LemmatisationService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TermService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.WordExtractionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TermServiceImpl implements TermService {

    private WordExtractionService extractionService;
    private LemmatisationService lemmatisationService;
    private TermRepository termRepository;

    public TermServiceImpl(WordExtractionService extractionService,
                           LemmatisationService lemmatisationService,
                           TermRepository termRepository) {
        this.extractionService = extractionService;
        this.lemmatisationService = lemmatisationService;
        this.termRepository = termRepository;
    }

    @Override
    public void extractAndSaveTerms(String text) {
        List<String> words = extractionService.getWordsFromText(text);
        List<Term> terms = words.stream()
                .map(word -> {
                    word = lemmatisationService.lemmatise(word);
                    Term term = new Term();
                    term.setText(word);
                    return term;
                })
                .collect(Collectors.toList());
        termRepository.addAll(terms);
    }
}
