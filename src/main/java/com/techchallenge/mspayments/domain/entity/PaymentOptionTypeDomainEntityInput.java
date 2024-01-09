package com.techchallenge.mspayments.domain.entity;

import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;
import lombok.Data;

@Data
public class PaymentOptionTypeDomainEntityInput {
    private PaymentOptionTypeEnum paymentOptionType;
}
