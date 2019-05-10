package ru.kpfu.itis.group11501.popov.intelligent_agent.repository.impl;

import org.aksw.jena_sparql_api.mapper.annotation.RdfType;
import org.apache.jena.atlas.json.JsonArray;
import org.apache.jena.atlas.json.JsonValue;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Document;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.DocumentRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.GeneralRepository;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.PojoMappingService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public <T> List<Document> findAllDocument(Class<T> entity) {
        RdfType type = entity.getAnnotation(RdfType.class);
        String query = "SELECT ?id ?text (count(?term) as ?wordcount)\n" +
                "WHERE {\n" +
                "\t?subject rdfs:label ?id .\n" +
                "\t?subject course:contains ?term .\n" +
                "\t?subject course:name ?text .\n" +
                "\t?subject a " + type.value() + "\n" +
                "}" +
                "GROUP BY ?id ?text";
        List<Document> documents = generalRepository.selectSparql(query, Document.class);
        return documents.stream().peek(doc -> doc.setEntity(entity)).collect(Collectors.toList());
    }

    @Override
    public <T> void addContainsIn(Term term, T entity) {
        generalRepository.addTriple(term, "course:containsIn", entity);
    }

}
