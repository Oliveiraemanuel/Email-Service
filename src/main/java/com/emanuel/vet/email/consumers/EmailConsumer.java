package com.emanuel.vet.email.consumers;

import com.emanuel.vet.email.domains.Email;
import com.emanuel.vet.email.dtos.EmailDTO;
import com.emanuel.vet.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO emailDTO){

        var email = new Email(emailDTO);

        emailService.sendEmail(email);
    }
}
