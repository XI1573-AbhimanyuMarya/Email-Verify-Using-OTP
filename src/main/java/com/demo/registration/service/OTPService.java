package com.demo.registration.service;

import com.demo.registration.model.OTP;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class OTPService {
    @Autowired
    private OTP otp;

    public void generateOTP()
    {
        otp.setOtpNumber(makeOTP());
        log.info("Token Generated : {}",otp.getOtpNumber());
    }

    public long getOTP()
    {
        return otp.getOtpNumber();
    }


    long makeOTP()
    {
        Random randomNumber=new Random();
        return randomNumber.nextInt(100000);
    }


}
