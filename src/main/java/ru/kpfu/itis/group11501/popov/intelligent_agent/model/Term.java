package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.*;

@RdfType("course:Term")
@DefaultIri("course:term#{id}")
public class Term {

    @Iri("rdfs:label")
    private String id;

    @Iri("course:term")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
