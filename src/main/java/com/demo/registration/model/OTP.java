package com.demo.registration.model;

import org.springframework.stereotype.Component;

@Component
public class OTP {

    private Long otpNumber;

    public Long getOtpNumber() {
        return otpNumber;
    }

    public void setOtpNumber(Long otpNumber) {
        this.otpNumber = otpNumber;
    }
}
