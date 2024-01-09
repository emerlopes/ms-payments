package com.techchallenge.mspayments.application.builders;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;

import java.util.UUID;

public class PaymentOptionDomainEntityInputBuilder {

    private final PaymentOptionDomainEntityInput paymentOptionDomainEntityInput;

    public PaymentOptionDomainEntityInputBuilder() {
        this.paymentOptionDomainEntityInput = new PaymentOptionDomainEntityInput();
    }

    public PaymentOptionDomainEntityInputBuilder withExternalDriverId(UUID externalDriverId) {
        this.paymentOptionDomainEntityInput.setExternalDriverId(externalDriverId);
        return this;
    }

    public PaymentOptionDomainEntityInputBuilder withPaymentOptionType(PaymentOptionTypeEntity paymentOptionType) {
        this.paymentOptionDomainEntityInput.setPaymentOptionType(paymentOptionType);
        return this;
    }

    public PaymentOptionDomainEntityInput build() {
        return this.paymentOptionDomainEntityInput;
    }
}
