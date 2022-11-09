package com.itcm.structural_design.models;

public class ExGroupChildModel {

  private final String title;
  private int id;

  public ExGroupChildModel(String title, int id){
    this.title = title;
    this.id = id;
  }

  public String getTitle() { return title; }

  public int getId() {
    return id;
  }
}
