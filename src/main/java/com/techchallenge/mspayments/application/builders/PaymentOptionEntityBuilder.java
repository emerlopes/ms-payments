package com.techchallenge.mspayments.application.builders;

import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionEntity;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentOptionEntityBuilder {

    private final PaymentOptionEntity paymentOptionEntity;

    public PaymentOptionEntityBuilder() {
        this.paymentOptionEntity = new PaymentOptionEntity();
    }

    public PaymentOptionEntityBuilder withExternalDriverId(UUID externalDriverId) {
        this.paymentOptionEntity.setExternalDriverId(externalDriverId);
        return this;
    }

    public PaymentOptionEntityBuilder withPaymentOptionTypeId(PaymentOptionTypeEntity paymentOptionTypeId) {
        this.paymentOptionEntity.setPaymentOptionType(paymentOptionTypeId);
        return this;
    }

    public PaymentOptionEntityBuilder withCreatedAt(LocalDateTime createdAt) {
        this.paymentOptionEntity.setCreatedAt(createdAt);
        return this;
    }

    public PaymentOptionEntity build() {
        return this.paymentOptionEntity;
    }
}
