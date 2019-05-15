package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.DefaultIri;
import org.aksw.jena_sparql_api.mapper.annotation.RdfType;

@RdfType("owllist:EmptyList")
@DefaultIri("listdata:emptylist")
public class EmptyList<T> implements OWLList<T> {

    @Override
    public T getElement() {
        return null;
    }

    @Override
    public void setElement(T element) {

    }

    @Override
    public OWLList<T> getTail() {
        return null;
    }

    @Override
    public void setTail(OWLList<T> tail) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public String getElemIri() {
        return null;
    }

    @Override
    public void setElemIri(String elemIri) {

    }
}
