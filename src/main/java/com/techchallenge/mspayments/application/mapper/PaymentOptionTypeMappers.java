package com.techchallenge.mspayments.application.mapper;

import com.techchallenge.mspayments.application.builders.PaymentOptionDomainEntityOutputBuilder;
import com.techchallenge.mspayments.application.builders.paymentoptiontype.PaymentOptionTypeDomainEntityInputBuilder;
import com.techchallenge.mspayments.application.builders.paymentoptiontype.PaymentOptionTypeDomainEntityOutputBuilder;
import com.techchallenge.mspayments.application.builders.paymentoptiontype.PaymentOptionTypeEntityBuilder;
import com.techchallenge.mspayments.application.entrypoint.rest.paymentoptiontype.dto.PaymentOptionTypeDTO;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.repositories.paymentsdatabase.dto.PaymentOptionTypeEnum;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionEntity;
import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.PaymentOptionTypeEntity;

import java.util.ArrayList;
import java.util.List;

public class PaymentOptionTypeMappers {

    public static PaymentOptionTypeDomainEntityInput mapToPaymentOptionTypeDomainEntityInput(PaymentOptionTypeDTO input) {
        final var paymentOptionTypeId = input.getPaymentOptionTypeId();

        return new PaymentOptionTypeDomainEntityInputBuilder()
                .withPaymentOptionTypeEnum(PaymentOptionTypeEnum.valueOf(paymentOptionTypeId))
                .build();
    }

    public static PaymentOptionTypeDomainEntityOutput mapToPaymentOptionTypeDomainEntityOutput(PaymentOptionTypeEntity input) {
        return new PaymentOptionTypeDomainEntityOutputBuilder()
                .withPaymentOptionTypeId(input.getPaymentOptionTypeId())
                .withPaymentOptionType(input.getPaymentOptionType())
                .build();
    }

    public static List<PaymentOptionTypeDomainEntityOutput> mapToPaymentOptionsTypesDomainEntitiesOutput(List<PaymentOptionTypeEntity> paymentOptionEntities) {
        List<PaymentOptionTypeDomainEntityOutput> outputs = new ArrayList<>();

        for (PaymentOptionTypeEntity paymentOptionTypeEntity : paymentOptionEntities) {
            final var output = new PaymentOptionTypeDomainEntityOutputBuilder()
                    .withPaymentOptionTypeId(paymentOptionTypeEntity.getPaymentOptionTypeId())
                    .withPaymentOptionType(paymentOptionTypeEntity.getPaymentOptionType())
                    .build();

            outputs.add(output);
        }

        return outputs;
    }

    public static PaymentOptionTypeEntity mapToPaymentOptionEntity(PaymentOptionTypeDomainEntityInput input) {
        return new PaymentOptionTypeEntityBuilder()
                .withPaymentOptionType(input.getPaymentOptionType())
                .build();
    }
}
