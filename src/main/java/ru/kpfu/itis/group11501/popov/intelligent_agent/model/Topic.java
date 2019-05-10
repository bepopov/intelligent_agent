package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.*;

@RdfType("course:Topic")
@DefaultIri("course:topic#{id}")
public class Topic {

    @Iri("rdfs:label")
    private String id;

    @Iri("course:name")
    private String name;

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

}
