package com.emanuel.vet.email.service;

import com.emanuel.vet.email.domains.Email;
import com.emanuel.vet.email.enums.StatusEmail;
import com.emanuel.vet.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("no-reply@chaka.live");
            message.setTo(email.getTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            email.setStatusEmail(StatusEmail.SENT);
        }catch (MailException ex){
            email.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return emailRepository.save(email);
        }

    }
}
