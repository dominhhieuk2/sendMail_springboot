package org.example.sendmail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
    @Autowired
    JavaMailSender mailSender;

    @RequestMapping("/")
    public String showForm() {
        return "FormSendMail";
    }

    @RequestMapping("/send")
    public String sendMail(@RequestParam("to")String to,
                           @RequestParam("subject")String subject,
                           @RequestParam("content")String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
        return "Result";
    }
}
