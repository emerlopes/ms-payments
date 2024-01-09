package com.techchallenge.mspayments.repositories.paymentsdatabase.repository;

import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentOptionEntityRepository extends JpaRepository<PaymentOptionEntity, Long> {
}
