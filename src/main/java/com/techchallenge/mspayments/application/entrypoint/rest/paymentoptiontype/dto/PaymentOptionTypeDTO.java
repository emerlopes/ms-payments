package com.techchallenge.mspayments.application.entrypoint.rest.paymentoptiontype.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;
import lombok.Data;

@Data
public class PaymentOptionTypeDTO {

    @JsonProperty("payment_option_type_id")
    private Long paymentOptionTypeId;
}
