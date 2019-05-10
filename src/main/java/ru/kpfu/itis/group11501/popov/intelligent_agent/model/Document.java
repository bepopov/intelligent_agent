package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

public class Document {

    private Class entity;
    private String id;
    private String text;
    private int wordCount;

    public Document() {
    }

    public Document(Class entity, int wordCount, String text, String id) {
        this.entity = entity;
        this.wordCount = wordCount;
        this.text = text;
        this.id = id;
    }

    public Class getEntity() {
        return entity;
    }

    public void setEntity(Class entity) {
        this.entity = entity;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
