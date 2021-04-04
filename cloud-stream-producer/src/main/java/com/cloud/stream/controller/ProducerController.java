package com.cloud.stream.controller;

import com.cloud.stream.service.ProducerSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/stream/producer")
public class ProducerController {

    @Autowired
    private ProducerSenderService producerSenderService;

    @GetMapping("/send")
    public void send() throws UnsupportedEncodingException {
        producerSenderService.send();
    }
}
