package com.techchallenge.mspayments.domain.usecase;

import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.IExecuteArgs;

public interface IExecuteCreatePaymentOptionUseCase extends IExecuteArgs<CustomData<PaymentOptionDomainEntityOutput>, PaymentOptionDomainEntityInput> {
}
