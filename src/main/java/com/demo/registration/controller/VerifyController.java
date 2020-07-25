package com.demo.registration.controller;

import com.demo.registration.model.OTP;
import com.demo.registration.service.OTPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class VerifyController {
    @Autowired
    OTP otp;

    @Autowired
    private OTPService otpService;

    @GetMapping("/verify")
    public String verifyOTP(@RequestParam Long number)
    {
        if (number.equals(otp.getOtpNumber()))
        {
            log.info("correct otp");
            otpService.generateOTP();
            return "Correct OTP";

        }
        log.info("wrong otp");
        return "wrong OTP";

    }
}
