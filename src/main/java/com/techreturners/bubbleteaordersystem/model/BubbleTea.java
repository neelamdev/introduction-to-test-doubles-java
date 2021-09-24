package com.techreturners.bubbleteaordersystem.model;

public class BubbleTea {

    private final BubbleTeaTypeEnum BUBBLETEATYPE;
    private final Double UNITPRICE;

    public BubbleTea(BubbleTeaTypeEnum bubbleTeaType, Double unitPrice) {
        this.BUBBLETEATYPE = bubbleTeaType;
        this.UNITPRICE = unitPrice;
    }

    public BubbleTeaTypeEnum getBubbleTeaType() {
        return this.BUBBLETEATYPE;
    }

    public Double getUnitPrice() {
        return this.UNITPRICE;
    }

    //if order ask more than 1 bubble tea


}
