package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DocumentRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TermRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.LemmatisationService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.TermService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.WordExtractionService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TermServiceImpl implements TermService {

    private WordExtractionService extractionService;
    private LemmatisationService lemmatisationService;
    private TermRepository termRepository;
    private DocumentRepository documentRepository;

    public TermServiceImpl(WordExtractionService extractionService,
                           LemmatisationService lemmatisationService,
                           TermRepository termRepository, DocumentRepository documentRepository) {
        this.extractionService = extractionService;
        this.lemmatisationService = lemmatisationService;
        this.termRepository = termRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public <T> List<Term> extractAndSaveTerms(String text, T entity) {
        List<Term> terms = extractTerms(text).stream()
                .map(word -> {
                    Term term = new Term();
                    term.setText(word);
                    term.setId(UUID.randomUUID().toString());
                    return term;
                }).collect(Collectors.toList());
        termRepository.addAll(terms);
        terms.forEach(term -> documentRepository.addContainsIn(term, entity));
        return terms;
    }

    @Override
    public List<String> extractTerms(String text) {
        List<String> words = extractionService.getWordsFromText(text);
        return words.stream()
                .map(word -> {
                    word = lemmatisationService.lemmatise(word);
                    return word;
                })
                .collect(Collectors.toList());
    }
}
