package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.DefaultIri;
import org.aksw.jena_sparql_api.mapper.annotation.RdfType;

@RdfType("owllist:OWLList")
@DefaultIri("listdata:list#{id}")
public class OWLListImpl<T> implements OWLList<T> {

    private String id;

    private T element;

    private OWLList<T> tail;

    private String elemIri;

    @Override
    public T getElement() {
        return element;
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public OWLList<T> getTail() {
        return tail;
    }

    @Override
    public void setTail(OWLList<T> tail) {
        this.tail = tail;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getElemIri() {
        return elemIri;
    }

    @Override
    public void setElemIri(String elemIri) {
        this.elemIri = elemIri;
    }
}
