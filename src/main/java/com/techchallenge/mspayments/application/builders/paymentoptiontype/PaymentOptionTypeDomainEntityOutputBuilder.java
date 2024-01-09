package com.techchallenge.mspayments.application.builders.paymentoptiontype;

import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;

public class PaymentOptionTypeDomainEntityOutputBuilder {

    private final PaymentOptionTypeDomainEntityOutput paymentOptionTypeDomainEntityOutput;

    public PaymentOptionTypeDomainEntityOutputBuilder() {
        this.paymentOptionTypeDomainEntityOutput = new PaymentOptionTypeDomainEntityOutput();
    }

    public PaymentOptionTypeDomainEntityOutputBuilder withPaymentOptionTypeId(Long paymentOptionTypeId) {
        this.paymentOptionTypeDomainEntityOutput.setPaymentOptionTypeId(paymentOptionTypeId);
        return this;
    }

    public PaymentOptionTypeDomainEntityOutputBuilder withPaymentOptionType(PaymentOptionTypeEnum paymentOptionType) {
        this.paymentOptionTypeDomainEntityOutput.setPaymentOptionType(paymentOptionType);
        return this;
    }

    public PaymentOptionTypeDomainEntityOutput build() {
        return this.paymentOptionTypeDomainEntityOutput;
    }
}
