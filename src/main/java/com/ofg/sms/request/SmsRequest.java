package com.ofg.sms.request;

import lombok.Data;

@Data
public class SmsRequest {
    private String to;
    private String message;
}