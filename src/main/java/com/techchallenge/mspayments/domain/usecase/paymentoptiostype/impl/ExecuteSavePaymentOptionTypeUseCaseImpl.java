package com.techchallenge.mspayments.domain.usecase.paymentoptiostype.impl;

import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptionTypeDomainService;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteSavePaymentOptionTypeUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteSavePaymentOptionTypeUseCaseImpl implements IExecuteSavePaymentOptionTypeUseCase {

    private final IPaymentOptionTypeDomainService paymentOptionTypeDomainService;

    public ExecuteSavePaymentOptionTypeUseCaseImpl(IPaymentOptionTypeDomainService paymentOptionTypeDomainService) {
        this.paymentOptionTypeDomainService = paymentOptionTypeDomainService;
    }

    @Override
    public CustomData<PaymentOptionTypeDomainEntityOutput> execute(PaymentOptionTypeDomainEntityInput input) {
        final var paymentOptionType = paymentOptionTypeDomainService.savePaymentOptionType(input);
        CustomData<PaymentOptionTypeDomainEntityOutput> customData = new CustomData<>();
        customData.setData(paymentOptionType);

        return customData;
    }
}
