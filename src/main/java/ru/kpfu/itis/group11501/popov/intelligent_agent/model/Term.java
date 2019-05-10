package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.*;

import java.util.List;

@RdfType("course:Term")
@DefaultIri("course:term#{text}")
public class Term {

    @Iri("course:term")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
