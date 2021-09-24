package com.techreturners.bubbleteaordersystem.service;

import com.techreturners.bubbleteaordersystem.model.BubbleTeaOrderRequest;
import com.techreturners.bubbleteaordersystem.model.EmailUtil;
import com.techreturners.bubbleteaordersystem.model.SimpleLoggerImpl;

import javax.mail.Session;
import java.util.Properties;

public class BubbleTeaMessenger {

    private final SimpleLoggerImpl simpleLogger;

    public BubbleTeaMessenger(SimpleLoggerImpl simpleLogger) {
        this.simpleLogger = simpleLogger;
    }

    public void sendBubbleTeaOrderRequestEmail(BubbleTeaOrderRequest bubbleTeaOrderRequest) {
        //Do something fancy here/use another service/method to send an email over SMTP
        System.out.println("SimpleEmail Start");

        String smtpHostServer = "smtp.gmail.com";
        String emailID = "bubbleteatest02@gmail.com";

        //Properties props = System.getProperties();


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", smtpHostServer);
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, null);
        System.out.println("session is set");

        EmailUtil.sendEmail(session, emailID, bubbleTeaOrderRequest.getName() + "   Email Testing Subject ", bubbleTeaOrderRequest.getBubbleTeaType() + "   SimpleEmail Testing Body");

        simpleLogger.addLoggingText("Yay! I just sent the Order Request email for the " +
                "following Bubble Tea Order Request " + bubbleTeaOrderRequest.toString());
    }

}
