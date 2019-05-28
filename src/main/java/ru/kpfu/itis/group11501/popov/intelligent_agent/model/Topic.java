package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aksw.jena_sparql_api.mapper.annotation.*;

@RdfType("course:Topic")
@DefaultIri("course:topic#{id}")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Iri("rdfs:label")
    private String id;

    @Iri("course:name")
    private String name;

}
