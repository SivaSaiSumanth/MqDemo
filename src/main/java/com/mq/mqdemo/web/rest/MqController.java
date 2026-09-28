package com.mq.mqdemo.web.rest;

import com.mq.mqdemo.model.CustomerMessage;
import com.mq.mqdemo.service.MqProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MqController {

    private final MqProducer mqProducer;

    public MqController(MqProducer mqProducer) {
        this.mqProducer = mqProducer;
    }

    @PostMapping("/string")
    public String sendMessageString(@RequestBody String message) {

        mqProducer.sendMessageString(message);

        return "String message sent successfully";
    }

    @PostMapping("/json")
    public String sendMessageJson(@RequestBody CustomerMessage message) {

        mqProducer.sendMessageJson(message);

        return "JSON message sent successfully";
    }

    @PostMapping("/xml")
    public String sendMessageXml(@RequestBody CustomerMessage message) {

        mqProducer.sendMessageXml(message);

        return "XML message sent successfully";
    }
}