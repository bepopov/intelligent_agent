package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.WordExtractionService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WordExtractionServiceImpl implements WordExtractionService {

    private final String SPLIT_PATTERN = "[\\p{Z}\\s.,;:!?'\"()/\\\\]+";
    private final String RUSSIAN_WORD_REGEX = "^[а-яА-Я\\-]+$";
    private final Set<String> STOP_WORDS;

    public WordExtractionServiceImpl(Set<String> stopWords) {
        STOP_WORDS = stopWords;
    }

    @Override
    public List<String> getWordsFromText(String text) {
        return Arrays.stream(text.split(SPLIT_PATTERN))
                .map(String::toLowerCase)
                .filter(word -> !word.equals("–"))
                .filter(this::isRussianWord)
                .filter(word -> !isStopWord(word))
                .collect(Collectors.toList());
    }

    private boolean isStopWord(final String word) {
        return STOP_WORDS.contains(word);
    }

    private boolean isRussianWord(final String word) {
        return word.matches(RUSSIAN_WORD_REGEX);
    }
}
