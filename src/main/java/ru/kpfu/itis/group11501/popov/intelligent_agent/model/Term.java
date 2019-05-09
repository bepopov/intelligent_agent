package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import org.aksw.jena_sparql_api.mapper.annotation.*;

import java.util.List;

@RdfType("course:Term")
@DefaultIri("course:term#{text}")
public class Term {

    @Iri("course:term")
    private String text;
/*
    @MappedBy("contains")
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
*/
/*
    @MappedBy("contains")
    @Iri("course:containsIn")
    private List<Topic> topics;

*/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*
    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

     */
}
