package com.itcm.structural_design.models;

public class StructuralDesignModel {

    private final int id;
    private final String title;
    private final String measuringUnitOne;
    private String measuringUnitTwo;
    private String resultTitle;
    private int numberPickerPosition;

    public StructuralDesignModel(int id, String title, String measuringUnitOne, String measuringUnitTwo, String resultTitle, int spinnerPosition){
        this.id = id;
        this.title = title;
        this.measuringUnitOne = measuringUnitOne;
        this.measuringUnitTwo = measuringUnitTwo;
        this.resultTitle = resultTitle;
        this.numberPickerPosition = spinnerPosition;
    }

    public String getTitle() {
        return title;
    }
    public String getMeasuringUnitOne() {
        return measuringUnitOne;
    }
    public String getMeasuringUnitTwo() { return measuringUnitTwo; }
    public void setMeasuringUnitTwo(String measuringUnitTwo) { this.measuringUnitTwo = measuringUnitTwo; }
    public int getId() { return id; }
    public String getResultTitle() { return resultTitle; }
    public void setResultTitle(String resultTitle) { this.resultTitle = resultTitle; }
    public void setPickerPosition(int position){ this.numberPickerPosition = position; }
    public int getPickerPosition() { return numberPickerPosition; }
}
