package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.DefaultIri;
import org.aksw.jena_sparql_api.mapper.annotation.Iri;
import org.aksw.jena_sparql_api.mapper.annotation.RdfType;

import java.util.List;

@RdfType("course:Didactic_Unit_Group")
@DefaultIri("course:dugroup#{id}")
public class DidacticUnitGroup {

    @Iri("rdfs:label")
    private String id;

    @Iri("course:groupOf")
    private List<DidacticUnit> didacticUnits;

    public List<DidacticUnit> getDidacticUnits() {
        return didacticUnits;
    }

    public void setDidacticUnits(List<DidacticUnit> didacticUnits) {
        this.didacticUnits = didacticUnits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
