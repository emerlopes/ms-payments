package com.techchallenge.mspayments.application.mapper;

import com.techchallenge.mspayments.application.entrypoint.rest.paymentreceipt.dto.PaymentReceiptDTO;
import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityOutput;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.ParkingPaymentReceiptEntity;

import java.time.LocalDateTime;

public class ParkingPaymentReceiptMappers {

    public static ParkingPaymentReceiptDomainEntityInput mapToParkingPaymentReceiptDomainEntityInput(PaymentReceiptDTO input) {
        return ParkingPaymentReceiptDomainEntityInput.builder()
                .paymentDate(input.getPaymentDate())
                .customerName(input.getCustomerName())
                .vehiclePlateNumber(input.getVehiclePlateNumber())
                .paymentAmount(input.getPaymentAmount())
                .paymentMethod(input.getPaymentMethod())
                .build();
    }

    public static ParkingPaymentReceiptDomainEntityOutput mapToParkingPaymentReceiptDomainEntityOutput(ParkingPaymentReceiptEntity entity) {
        return ParkingPaymentReceiptDomainEntityOutput.builder()
                .receiptNumber(entity.getReceiptNumber())
                .paymentDate(entity.getPaymentDate())
                .customerName(entity.getCustomerName())
                .vehiclePlateNumber(entity.getVehiclePlateNumber())
                .paymentAmount(entity.getPaymentAmount())
                .paymentMethod(entity.getPaymentMethod())
                .build();
    }

    public static ParkingPaymentReceiptEntity mapToParkingPaymentReceiptEntity(ParkingPaymentReceiptDomainEntityInput input) {
        final var parkingPaymentReceiptEntity = new ParkingPaymentReceiptEntity();
        parkingPaymentReceiptEntity.setPaymentDate(LocalDateTime.now());
        parkingPaymentReceiptEntity.setCustomerName(input.getCustomerName());
        parkingPaymentReceiptEntity.setVehiclePlateNumber(input.getVehiclePlateNumber());
        parkingPaymentReceiptEntity.setPaymentAmount(input.getPaymentAmount());
        parkingPaymentReceiptEntity.setPaymentMethod(input.getPaymentMethod());
        return null;
    }
}
