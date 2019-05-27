package ru.kpfu.itis.group11501.popov.intelligent_agent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import ru.stachek66.nlp.mystem.holding.Factory;
import ru.stachek66.nlp.mystem.holding.MyStem;
import scala.Option;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SearchServicesConfig {

    private static final String STOP_WORDS_PATH = "stopwords-ru.txt";

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler
                = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix(
                "ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
    }

    @Bean
    public MyStem myStemAnalyzer() {
        return new Factory("-igd --eng-gr --format json --weight")
                .newMyStem("3.0", Option.empty()).get();
    }

    @Bean
    public Set<String> stopWords() {
        Set<String> stopWords = new HashSet<>();
        try {
            File file =  new ClassPathResource(STOP_WORDS_PATH).getFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                stopWords.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopWords;
    }

    @Bean
    public TemplateParserContext templateParserContext() {
        return new TemplateParserContext();
    }

    @Bean
    public ExpressionParser expressionParser() {
        return new SpelExpressionParser();
    }

}
