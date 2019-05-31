package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aksw.jena_sparql_api.mapper.annotation.DefaultIri;
import org.aksw.jena_sparql_api.mapper.annotation.Iri;
import org.aksw.jena_sparql_api.mapper.annotation.RdfType;

import java.util.List;

@RdfType("course:Didactic_Unit_Group")
@DefaultIri("course:tdgroup#{id}")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopicDescriptionGroup {

    @Iri("rdfs:label")
    private String id;

    @Iri("course:groupOf")
    private List<TopicDescription> didacticUnits;

}
