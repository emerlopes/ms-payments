package com.techchallenge.mspayments.application.builders.paymentoptiontype;

import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityInput;
import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;

public class PaymentOptionTypeDomainEntityInputBuilder {

    private final PaymentOptionTypeDomainEntityInput paymentOptionTypeDomainEntityInput;

    public PaymentOptionTypeDomainEntityInputBuilder() {
        this.paymentOptionTypeDomainEntityInput = new PaymentOptionTypeDomainEntityInput();
    }

    public PaymentOptionTypeDomainEntityInputBuilder withPaymentOptionTypeEnum(PaymentOptionTypeEnum paymentOptionTypeEnum) {
        this.paymentOptionTypeDomainEntityInput.setPaymentOptionType(paymentOptionTypeEnum);
        return this;
    }

    public PaymentOptionTypeDomainEntityInput build() {
        return this.paymentOptionTypeDomainEntityInput;
    }
}
