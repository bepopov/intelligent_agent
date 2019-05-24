package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.DefaultIri;
import org.aksw.jena_sparql_api.mapper.annotation.RdfType;

@RdfType("owllist:EmptyList")
@DefaultIri("listdata:emptylist")
public class EmptyList implements OWLList {

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

}
