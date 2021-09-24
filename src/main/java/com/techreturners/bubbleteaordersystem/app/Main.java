package com.techreturners.bubbleteaordersystem.app;

import com.techreturners.bubbleteaordersystem.model.BubbleTeaOrderRequest;
import com.techreturners.bubbleteaordersystem.model.BubbleTeaTypeEnum;
import com.techreturners.bubbleteaordersystem.model.SimpleLoggerImpl;
import com.techreturners.bubbleteaordersystem.service.BubbleTeaMessenger;

public class Main {
    public static SimpleLoggerImpl simpleLogger;
    private static BubbleTeaOrderRequest bubbleTeaOrderRequest;
    //BubbleTeaOrderRequest bubbleTeaOrderRequest;

    public static void main(String[] args) {

        System.out.println("I like Bubble Tea! " +
                "This is a slimmed down version of a Bubble Tea Order System!");
        BubbleTeaOrderRequest bubbleTeaOrderRequest = new BubbleTeaOrderRequest(
                "hello kitty",
                "sanrio puroland",
                "0123456789",
                BubbleTeaTypeEnum.OolongMilkTea
        );


        BubbleTeaMessenger bubbleTeaMessenger = new BubbleTeaMessenger(simpleLogger);
        bubbleTeaMessenger.sendBubbleTeaOrderRequestEmail(bubbleTeaOrderRequest);
    }

}
