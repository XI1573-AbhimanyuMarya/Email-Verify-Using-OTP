package com.demo.registration.service;

import com.demo.registration.model.Email;
import com.demo.registration.model.OTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService {
    @Value("${email.username}")
    private String username;
    @Value("${email.password}")
    private String password;
    @Autowired
    private OTP otp;

    public void sendAnEmail(Email email) throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getpasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(username, false));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo_address()));
        message.setSubject("OTP: Email");
        message.setContent(" Your OTP Number is: " + otp.getOtpNumber(), "text/html");
        message.setSentDate(new Date());
/*


        MimeBodyPart mimeBodyPart=new MimeBodyPart();
        mimeBodyPart.setContent(email.getBody(),"text/html");

        Multipart multipart=new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        MimeBodyPart attachPart=new MimeBodyPart();

        attachPart.attachFile("C:\\Users\\Abhimanyu.Marya\\Downloads\\image23.png");

        multipart.addBodyPart(attachPart);
        message.setContent(multipart);
*/

        //TODO SEND Email
        Transport.send(message, "xebiaupdates@gmail.com", "Quiz@123");


    }


}
