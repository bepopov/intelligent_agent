package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aksw.jena_sparql_api.mapper.annotation.DefaultIri;
import org.aksw.jena_sparql_api.mapper.annotation.Iri;
import org.aksw.jena_sparql_api.mapper.annotation.RdfType;

@RdfType("course:Discipline")
@DefaultIri("course:course#{id}")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Iri("rdf:label")
    private String id;

    @Iri("course:name")
    private String name;

}
