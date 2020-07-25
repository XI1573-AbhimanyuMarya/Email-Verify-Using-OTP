package com.demo.registration.controller;

import com.demo.registration.dto.EmailResponse;
import com.demo.registration.model.Email;
import com.demo.registration.service.EmailService;
import com.demo.registration.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private OTPService otpService;

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody Email email) throws MessagingException, IOException {
        otpService.generateOTP();
        emailService.sendAnEmail(email);
        return ResponseEntity.ok(new EmailResponse("Email Sent Successfully"));

    }


}
