package com.mq.mqdemo.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MqConsumer {

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String message) {

        System.out.println("Received message from IBM MQ: " + message);
    }
}