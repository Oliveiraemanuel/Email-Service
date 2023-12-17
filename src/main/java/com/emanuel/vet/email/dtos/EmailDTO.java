package com.emanuel.vet.email.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record EmailDTO(@NotBlank @Email String from, @NotBlank @Email String to, @NotBlank String subject, @NotBlank String text) {
}
