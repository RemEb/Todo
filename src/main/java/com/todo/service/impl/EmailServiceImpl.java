package com.todo.service.impl;

import com.todo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



/**
 * 
 */
@Component
public class EmailServiceImpl implements EmailService {
    @Autowired
    public JavaMailSender emailSender;

    /**
     * Default constructor
     */
    @Value("${spring.mail.username}")
    private String username;
    public EmailServiceImpl() {
    }

    /**
     * 发送邮件
     * @param to 
     * @param subject 
     * @param text 
     * @return
     */
    public void send(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

}