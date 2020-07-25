package com.demo.registration.dto;

public class EmailResponse {

    private final String sendResponse;

    public EmailResponse(String sendResponse) {
        this.sendResponse = sendResponse;
    }

    public String getSendResponse() {
        return sendResponse;
    }
}
