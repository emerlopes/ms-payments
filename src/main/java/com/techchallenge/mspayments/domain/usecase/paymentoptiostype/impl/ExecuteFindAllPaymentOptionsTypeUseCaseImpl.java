package com.techchallenge.mspayments.domain.usecase.paymentoptiostype.impl;

import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptionTypeDomainService;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindAllPaymentOptionsTypeUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecuteFindAllPaymentOptionsTypeUseCaseImpl implements IExecuteFindAllPaymentOptionsTypeUseCase {

    private final IPaymentOptionTypeDomainService paymentOptionTypeDomainService;

    public ExecuteFindAllPaymentOptionsTypeUseCaseImpl(IPaymentOptionTypeDomainService paymentOptionTypeDomainService) {
        this.paymentOptionTypeDomainService = paymentOptionTypeDomainService;
    }

    @Override
    public CustomData<List<PaymentOptionTypeDomainEntityOutput>> execute() {
        final var paymentOptionType = paymentOptionTypeDomainService.findAllPaymentOptions();

        CustomData<List<PaymentOptionTypeDomainEntityOutput>> customData = new CustomData<>();
        customData.setData(paymentOptionType);
        return customData;
    }
}
