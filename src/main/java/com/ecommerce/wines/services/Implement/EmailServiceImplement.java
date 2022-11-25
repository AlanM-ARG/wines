package com.ecommerce.wines.services.Implement;

import com.ecommerce.wines.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplement  implements EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String body) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("LightBank");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);

        mailSender.send(simpleMailMessage);

    }
}
