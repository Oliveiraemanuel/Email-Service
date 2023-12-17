package com.emanuel.vet.email.controller;

import com.emanuel.vet.email.domains.Email;
import com.emanuel.vet.email.dtos.EmailDTO;
import com.emanuel.vet.email.mapper.EmailMapper;
import com.emanuel.vet.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){

        Email email = EmailMapper.INSTANCE.EmailDTOToEmail(emailDTO);

        emailService.sendEmail(email);

        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
