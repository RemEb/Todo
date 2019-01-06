package com.todo.service;


import java.util.*;

/**
 * 邮件服务
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param to 
     * @param subject 
     * @param text 
     * @return
     */
    public void send(String to, String subject, String text);

}