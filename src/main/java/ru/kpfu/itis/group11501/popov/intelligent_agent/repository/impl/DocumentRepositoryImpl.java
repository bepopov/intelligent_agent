package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.annotation.RdfType;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.TermCount;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DocumentRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.PojoMappingService;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    private EntityManager entityManager;
    private GeneralRepository generalRepository;
    private PojoMappingService mappingService;

    public DocumentRepositoryImpl(EntityManager entityManager,
                                  GeneralRepository generalRepository,
                                  PojoMappingService mappingService) {
        this.entityManager = entityManager;
        this.generalRepository = generalRepository;
        this.mappingService = mappingService;
    }

    @Override
    public <T> List<TermCount> findTermCounts(Class<T> entity, List<String> requestWords) {
        RdfType type = entity.getAnnotation(RdfType.class);
        String query = "SELECT ?docid ?content ?wordcount ?term (count(?object) as ?termcount)\n" +
                "WHERE {\n" +
                "  {\n" +
                "    SELECT ?docid ?content (count(?word) as ?wordcount)\n" +
                "                WHERE {\n" +
                "                ?subject rdfs:label ?docid .\n" +
                "                ?subject course:contains ?word .\n" +
                "                ?subject course:name ?content .\n" +
                "                ?subject a " + type.value() + "\n" +
                "                }\n" +
                "    GROUP BY ?docid ?content\n" +
                "  }\n" +
                "  ?subject rdfs:label ?docid .\n" +
                "  ?subject course:contains ?object .\n" +
                "  ?object course:term ?term\n" +
                requestWordsFilter(requestWords) +
                "}\n" +
                "GROUP BY ?docid ?content ?wordcount ?term";
        return generalRepository.selectSparql(query, TermCount.class);
    }

    @Override
    public <T> void addContainsIn(Term term, T entity) {
        generalRepository.addTriple(term, "course:containsIn", entity);
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
