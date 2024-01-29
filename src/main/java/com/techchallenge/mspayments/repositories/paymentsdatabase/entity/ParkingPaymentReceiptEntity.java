package com.techchallenge.mspayments.repositories.paymentsdatabase.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tb06_parking_payment_receipt")
public class ParkingPaymentReceiptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_number")
    private Long receiptNumber;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "vehicle_plate_number")
    private String vehiclePlateNumber;

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;

    @Column(name = "paymment_method")
    private String paymentMethod;


}
