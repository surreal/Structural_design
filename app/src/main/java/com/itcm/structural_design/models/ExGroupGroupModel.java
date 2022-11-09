package com.itcm.structural_design.models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ExGroupGroupModel extends ExpandableGroup {

    private final String title;
    private final List items;
    private int id;

    public ExGroupGroupModel(List items, String title, int id) {
        super(title, items);
        this.title = title;
        this.items = items;
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List getItems() {
        return items;
    }

    public int getId() {
        return id;
    }
}
