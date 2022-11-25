package com.ecommerce.wines.services;

public interface EmailService {

    void sendEmail(String to, String subject, String body);

}
