package com.example.paging.api;

import java.util.List;

public class Page<T> {

    private PageInformation pageInformation;

    private List<T> items;

    public PageInformation getPageInformation() {
        return pageInformation;
    }

    public void setPageInformation(PageInformation pageInformation) {
        this.pageInformation = pageInformation;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

}
