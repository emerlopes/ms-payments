package com.techchallenge.mspayments.domain.usecase.paymentoptiostype.impl;

import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IPaymentOptionTypeDomainService;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.IExecuteFindPaymentOptionsUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteFindPaymentOptionTypeByIdUseCase;
import com.techchallenge.mspayments.domain.usecase.paymentoptiostype.IExecuteSavePaymentOptionTypeUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecuteFindPaymentOptionTypeByIdUseCaseImpl implements IExecuteFindPaymentOptionTypeByIdUseCase {

    private final IPaymentOptionTypeDomainService paymentOptionTypeDomainService;

    public ExecuteFindPaymentOptionTypeByIdUseCaseImpl(IPaymentOptionTypeDomainService paymentOptionTypeDomainService) {
        this.paymentOptionTypeDomainService = paymentOptionTypeDomainService;
    }

    @Override
    public CustomData<PaymentOptionTypeDomainEntityOutput> execute(PaymentOptionTypeDomainEntityInput domainObject) {
        return null;
    }
}
