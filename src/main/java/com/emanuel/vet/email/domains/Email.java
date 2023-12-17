package com.emanuel.vet.email.domains;

import com.emanuel.vet.email.dtos.EmailDTO;
import com.emanuel.vet.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "email")
@Data
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromEmail;

    private String toEmail;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime sendDateEmail;

    private StatusEmail statusEmail;

    public Email(EmailDTO data) {
        this.fromEmail = data.from();;
        this.toEmail = data.to();
        this.subject = data.subject();
        this.text = data.text();
    }
}
