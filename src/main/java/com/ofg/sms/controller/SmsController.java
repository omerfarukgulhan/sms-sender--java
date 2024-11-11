package com.ofg.sms.controller;

import com.ofg.sms.request.SmsRequest;
import com.ofg.sms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {
    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send-sms")
    public String sendSms(@RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
        return "SMS sent!";
    }
}
