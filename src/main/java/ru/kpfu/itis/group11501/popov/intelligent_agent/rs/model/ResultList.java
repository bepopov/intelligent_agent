package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model;

import java.util.List;

public class ResultList<T> {

    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
