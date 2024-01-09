package com.techchallenge.mspayments.application.builders;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentOptionDomainEntityOutputBuilder {

    private final PaymentOptionDomainEntityOutput paymentOptionDomainEntityOutput;

    public PaymentOptionDomainEntityOutputBuilder() {
        this.paymentOptionDomainEntityOutput = new PaymentOptionDomainEntityOutput();
    }

    public PaymentOptionDomainEntityOutputBuilder withExternalDriverId(UUID externalDriverId) {
        this.paymentOptionDomainEntityOutput.setExternalDriverId(externalDriverId);
        return this;
    }

    public PaymentOptionDomainEntityOutputBuilder withPaymentOptionType(PaymentOptionTypeEntity paymentOptionTypeId) {
        this.paymentOptionDomainEntityOutput.setPaymentOptionType(paymentOptionTypeId);
        return this;
    }

    public PaymentOptionDomainEntityOutputBuilder withCreatedAt(LocalDateTime createdAt) {
        this.paymentOptionDomainEntityOutput.setCreatedAt(createdAt);
        return this;
    }

    public PaymentOptionDomainEntityOutput build() {
        return this.paymentOptionDomainEntityOutput;
    }

}
