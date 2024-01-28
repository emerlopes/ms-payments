package com.techchallenge.mspayments.application.entrypoint.rest.paymentreceipt.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class PaymentReceiptDTO {
    private LocalDateTime paymentDate;
    private String customerName;
    private String vehiclePlateNumber;
    private BigDecimal paymentAmount;
    private String paymentMethod;
}
