package com.techchallenge.mspayments.application.mapper;

import com.techchallenge.mspayments.application.builders.PaymentOptionDomainEntityInputBuilder;
import com.techchallenge.mspayments.application.builders.PaymentOptionDomainEntityOutputBuilder;
import com.techchallenge.mspayments.application.builders.PaymentOptionEntityBuilder;
import com.techchallenge.mspayments.application.entrypoint.rest.paymentoption.dto.PaymentOptionDTO;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentOptionMappers {

    public static PaymentOptionDomainEntityInput mapToPaymentOptionDomainEntityInput(PaymentOptionDTO input) {
        return new PaymentOptionDomainEntityInputBuilder()
                .withExternalDriverId(input.getExternalDriverId())
                .build();
    }

    public static PaymentOptionDomainEntityOutput mapToPaymentOptionDomainEntityOutput(PaymentOptionEntity input) {
        return new PaymentOptionDomainEntityOutputBuilder()
                .withExternalDriverId(input.getExternalDriverId())
                .withPaymentOptionType(input.getPaymentOptionType())
                .withCreatedAt(input.getCreatedAt())
                .build();
    }

    public static List<PaymentOptionDomainEntityOutput> mapToPaymentOptionsDomainEntitiesOutput(List<PaymentOptionEntity> paymentOptionEntities) {
        List<PaymentOptionDomainEntityOutput> outputs = new ArrayList<>();

        for (PaymentOptionEntity paymentOptionEntity : paymentOptionEntities) {
            final var output = new PaymentOptionDomainEntityOutputBuilder()
                    .withExternalDriverId(paymentOptionEntity.getExternalDriverId())
                    .withPaymentOptionType(paymentOptionEntity.getPaymentOptionType())
                    .withCreatedAt(paymentOptionEntity.getCreatedAt())
                    .build();

            outputs.add(output);
        }

        return outputs;
    }

    public static PaymentOptionEntity mapToPaymentEntity(PaymentOptionDomainEntityInput input) {
        return new PaymentOptionEntityBuilder()
                .withExternalDriverId(input.getExternalDriverId())
                .withPaymentOptionTypeId(input.getPaymentOptionType())
                .withCreatedAt(LocalDateTime.now())
                .build();
    }
}
