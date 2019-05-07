package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.LemmatisationService;
import scala.collection.JavaConversions;
import ru.stachek66.nlp.mystem.holding.MyStem;
import ru.stachek66.nlp.mystem.holding.MyStemApplicationException;
import ru.stachek66.nlp.mystem.holding.Request;
import ru.stachek66.nlp.mystem.model.Info;

@Service
public class MyStemLemmatisationService implements LemmatisationService {

    private final MyStem myStemAnalyzer;

    public MyStemLemmatisationService(MyStem myStemAnalyzer) {
        this.myStemAnalyzer = myStemAnalyzer;
    }

    @Override
    public String lemmatise(final String word) {
        try {
            final Iterable<Info> result =
                    JavaConversions.asJavaIterable(
                            myStemAnalyzer
                                    .analyze(Request.apply(word))
                                    .info()
                                    .toIterable());
            for (final Info info : result) {
                return info.lex().isEmpty() ? info.initial() : info.lex().get();
            }
        }
        catch (MyStemApplicationException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
