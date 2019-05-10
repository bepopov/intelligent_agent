package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

public class TermCount {

    private String term;

    private String docId;

    private Integer termCount;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public Integer getTermCount() {
        return termCount;
    }

    public void setTermCount(Integer termCount) {
        this.termCount = termCount;
    }
}
