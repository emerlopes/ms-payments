package com.techchallenge.mspayments.domain.entity;

import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class PaymentOptionDomainEntityInput {

    private UUID externalDriverId;

    private PaymentOptionTypeEntity paymentOptionType;
}
