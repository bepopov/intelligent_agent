package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

public interface OWLList<T> {

    T getElement();

    void setElement(T element);

    OWLList<T> getTail();

    void setTail(OWLList<T> tail);

    String getId();

    void setId(String id);

    String getElemIri();

    void setElemIri(String elemIri);

}
