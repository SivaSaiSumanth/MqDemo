package com.mq.mqdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mq.mqdemo.model.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MqProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private XmlMapper xmlMapper = new XmlMapper();


    public void sendMessageString(String message) {

        jmsTemplate.convertAndSend(
                "DEV.QUEUE.1",
                message
        );
    }

    public void sendMessageJson(CustomerMessage message) {

        try {

            String json = objectMapper.writeValueAsString(message);

            jmsTemplate.convertAndSend(
                    "DEV.QUEUE.1",
                    json
            );

        } catch (JsonProcessingException e) {

            throw new RuntimeException(
                    "Failed to convert message to JSON", e
            );
        }
    }

    public void sendMessageXml(CustomerMessage message) {

        try {

            String xml = xmlMapper.writeValueAsString(message);

            jmsTemplate.convertAndSend(
                    "DEV.QUEUE.1",
                    xml
            );

        } catch (JsonProcessingException e) {

            throw new RuntimeException(
                    "Failed to convert message to XML", e
            );
        }
    }
}