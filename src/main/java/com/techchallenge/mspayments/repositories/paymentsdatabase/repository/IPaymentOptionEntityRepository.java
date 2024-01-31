package com.techchallenge.mspayments.repositories.paymentsdatabase.repository;

import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IPaymentOptionEntityRepository extends JpaRepository<PaymentOptionEntity, Long> {
    Optional<PaymentOptionEntity> findByExternalDriverId(UUID id);
}
