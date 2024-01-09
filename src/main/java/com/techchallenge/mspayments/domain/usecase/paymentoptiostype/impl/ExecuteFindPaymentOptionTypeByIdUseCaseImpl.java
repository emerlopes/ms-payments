package com.techchallenge.mspayments.domain.usecase.paymentoptiostype.impl;

import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptionTypeDomainService;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindPaymentOptionTypeByIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteFindPaymentOptionTypeByIdUseCaseImpl implements IExecuteFindPaymentOptionTypeByIdUseCase {

    private final IPaymentOptionTypeDomainService paymentOptionTypeDomainService;

    public ExecuteFindPaymentOptionTypeByIdUseCaseImpl(IPaymentOptionTypeDomainService paymentOptionTypeDomainService) {
        this.paymentOptionTypeDomainService = paymentOptionTypeDomainService;
    }

    @Override
    public CustomData<PaymentOptionTypeDomainEntityOutput> execute(Long input) {
        final var paymentOptionType = paymentOptionTypeDomainService.findPaymentOptionTypeById(input);
        CustomData<PaymentOptionTypeDomainEntityOutput> customData = new CustomData<>();
        customData.setData(paymentOptionType);

        return customData;
    }
}
