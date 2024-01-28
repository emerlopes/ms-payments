package com.techchallenge.mspayments.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ParkingPaymentReceiptDomainEntityOutput {
    private Long receiptNumber;
    private LocalDateTime paymentDate;
    private String customerName;
    private String vehiclePlateNumber;
    private BigDecimal paymentAmount;
    private String paymentMethod;
}
