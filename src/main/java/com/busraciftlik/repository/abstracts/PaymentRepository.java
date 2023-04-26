package com.busraciftlik.repository.abstracts;

import com.busraciftlik.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
