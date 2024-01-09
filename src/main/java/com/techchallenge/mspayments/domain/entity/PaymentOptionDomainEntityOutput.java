package com.techchallenge.mspayments.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PaymentOptionDomainEntityOutput {
    @JsonProperty("external_driver_id")
    private UUID externalDriverId;

    @JsonProperty("payment_option_type")
    private PaymentOptionTypeEntity paymentOptionType;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
