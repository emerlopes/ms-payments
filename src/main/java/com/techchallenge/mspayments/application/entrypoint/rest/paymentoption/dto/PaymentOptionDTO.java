package com.techchallenge.mspayments.application.entrypoint.rest.paymentoption.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class PaymentOptionDTO {

    @JsonProperty("external_driver_id")
    private UUID externalDriverId;

    @JsonProperty("payment_option_type_id")
    private Long paymentOptionTypeId;
}
