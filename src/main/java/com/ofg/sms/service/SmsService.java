package com.ofg.sms.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Value("${app.twilio.account.sid}")
    private String accountSid;
    @Value("${app.twilio.auth.token}")
    private String authToken;
    @Value("${app.twilio.phone.number}")
    private String fromPhoneNumber;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String toPhoneNumber, String messageBody) {
        Message message = Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                messageBody
        ).create();

        System.out.println("SMS sent: " + message.getSid());
    }

    @Scheduled(fixedRate = 300000)
    public void TestPrinter() {
        sendSms("Test Phone", "Hello World!");
    }
}
