package com.techchallenge.mspayments.application.entrypoint.rest.paymentreceipt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class PaymentReceiptDTO {
    @JsonProperty("payment_date")
    private LocalDateTime paymentDate;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("vehicle_plate_number")
    private String vehiclePlateNumber;

    @JsonProperty("payment_amount")
    private BigDecimal paymentAmount;

    @JsonProperty("payment_method")
    private String paymentMethod;
}
