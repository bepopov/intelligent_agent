package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aksw.jena_sparql_api.mapper.annotation.*;

@RdfType("course:Term")
@DefaultIri("course:term#{id}")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Term {

    @Iri("rdfs:label")
    private String id;

    @Iri("course:term")
    private String text;

}
