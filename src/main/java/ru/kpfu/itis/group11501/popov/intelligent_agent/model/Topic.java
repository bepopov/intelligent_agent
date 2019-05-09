package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.*;

import java.util.List;

@RdfType("course:Topic")
@DefaultIri("course:topic#{id}")
public class Topic {

    @Iri("rdfs:label")
    private String id;

    @Iri("course:name")
    private String name;
/*
    @Iri("course:contains")
    private List<Term> terms;

 */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    // Если задано два списка с обоих сторон, mapper циклится
/*
    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }


 */

}
