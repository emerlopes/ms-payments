package com.techchallenge.mspayments.domain.entity;

import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PaymentOptionDomainEntityOutput {
    private UUID externalDriverId;
    private PaymentOptionTypeEntity paymentOptionType;
    private LocalDateTime createdAt;
}
