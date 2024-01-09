package com.techchallenge.mspayments.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;
import lombok.Data;

@Data
public class PaymentOptionTypeDomainEntityOutput {
    @JsonProperty("payment_option_type_id")
    private Long paymentOptionTypeId;

    @JsonProperty("payment_option_type")
    private PaymentOptionTypeEnum paymentOptionType;
}
