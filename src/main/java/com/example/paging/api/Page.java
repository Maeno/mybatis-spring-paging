package com.example.paging.api;

import java.util.List;

public class Page<T> {

    private PageConditon pageConditon;

    private List<T> items;

    public PageConditon getPageConditon() {
        return pageConditon;
    }

    public void setPageConditon(final PageConditon pageConditon) {
        this.pageConditon = pageConditon;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

}
