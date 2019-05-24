package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.annotation.RdfType;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Document;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TermCount;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DocumentRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;

import java.util.List;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    private GeneralRepository generalRepository;

    public DocumentRepositoryImpl(GeneralRepository generalRepository) {
        this.generalRepository = generalRepository;
    }

    @Override
    public <T> List<TermCount> findTermCounts(Class<T> entity, List<String> requestWords) {
        RdfType type = entity.getAnnotation(RdfType.class);
        String query =
                "SELECT ?docid ?term (count(?term) as ?termcount)\n" +
                        "WHERE {\n" +
                        "  ?subject rdfs:label ?docid .\n" +
                        "  ?subject a "+ type.value() + ".\n" +
                        "  ?subject course:contains ?object .\n" +
                        "  ?object course:term ?term \n" +
                        requestWordsFilter(requestWords) +
                        "}\n" +
                        "GROUP BY ?docid ?term";
        return generalRepository.selectSparql(query, TermCount.class);
    }

    @Override
    public <T> void addContainsIn(Term term, T entity) {
        generalRepository.addTriple(term, "course:containsIn", entity);
    }

    @Override
    public <T> Double averageDocLength(Class<T> entity) {
        RdfType type = entity.getAnnotation(RdfType.class);
        String query = "SELECT (AVG(?wordcount) AS ?param)\n" +
                "WHERE {\n" +
                "  {\n" +
                "    SELECT (count(?word) as ?wordcount)\n" +
                "                WHERE {\n" +
                "                ?doc course:contains ?word .\n" +
                "                ?doc a " + type.value() + "\n" +
                "                }\n" +
                "    GROUP BY ?doc\n" +
                "  }\n" +
                "}";
        return generalRepository.selectDouble(query);
    }

    @Override
    public <T> Integer countDocuments(Class<T> entity) {
        RdfType type = entity.getAnnotation(RdfType.class);
        String query = "SELECT (count(?doc) as ?param)\n" +
                "       WHERE {\n" +
                "                ?doc a " + type.value() + "\n" +
                "       }";
        return generalRepository.selectInteger(query);
    }

    @Override
    public <T> List<Document> findDocuments(Class<T> entity, List<String> requestWords) {
        RdfType type = entity.getAnnotation(RdfType.class);
        String query =
                "SELECT ?id ?wordcount ?content\n" +
                        "WHERE {\n" +
                        "  {\n" +
                        "    SELECT ?id (count(?word) as ?wordcount) ?content\n" +
                        "    WHERE {\n" +
                        "      ?subject rdfs:label ?id .\n" +
                        "      ?subject course:contains ?word .\n" +
                        "      ?subject a " + type.value() + " .\n" +
                        "      ?subject course:name ?content\n" +
                        "    }\n" +
                        "    GROUP BY ?id ?content\n" +
                        "  }\n" +
                        "  ?subject rdfs:label ?id .\n" +
                        "  ?subject course:contains ?object .\n" +
                        "  ?object course:term ?term \n" +
                        requestWordsFilter(requestWords) +
                        "}\n" +
                        "GROUP BY ?id ?wordcount ?content";
        return generalRepository.selectSparql(query, Document.class);
    }

    private String requestWordsFilter(List<String> requestWords) {
        StringBuilder queryFilter = new StringBuilder();
        if (requestWords == null || requestWords.size() == 0) {
            return "";
        }
        queryFilter.append("FILTER (");
        for (String requestWord : requestWords) {
            queryFilter.append("(?term = \"");
            queryFilter.append(requestWord);
            queryFilter.append("\") || \n");
        }
        queryFilter.delete(queryFilter.lastIndexOf("||"), queryFilter.length() - 1);
        queryFilter.append(")");
        return queryFilter.toString();
    }

}
