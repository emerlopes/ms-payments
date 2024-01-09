package com.techchallenge.mspayments.application.builders.paymentoptiontype;

import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;

public class PaymentOptionTypeEntityBuilder {

    private final PaymentOptionTypeEntity paymentOptionTypeEntity;

    public PaymentOptionTypeEntityBuilder() {
        this.paymentOptionTypeEntity = new PaymentOptionTypeEntity();
    }

    public PaymentOptionTypeEntityBuilder withPaymentOptionType(PaymentOptionTypeEnum paymentOptionTypeEnum) {
        this.paymentOptionTypeEntity.setPaymentOptionType(paymentOptionTypeEnum);
        return this;
    }

    public PaymentOptionTypeEntity build() {
        return this.paymentOptionTypeEntity;
    }
}
