package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

public class Document<T> {

    private T entity;
    private int wordCount;

    public Document(T entity, int wordCount) {
        this.entity = entity;
        this.wordCount = wordCount;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}
