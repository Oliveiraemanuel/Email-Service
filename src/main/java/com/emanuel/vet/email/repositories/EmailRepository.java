package com.emanuel.vet.email.repositories;

import com.emanuel.vet.email.domains.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
