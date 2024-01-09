package com.techchallenge.mspayments.repositories.paymentsdatabase.repository;

import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentOptionTypeEntityRepository extends JpaRepository<PaymentOptionTypeEntity, Long> {
}
