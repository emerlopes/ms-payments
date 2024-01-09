package com.techchallenge.mspayments.domain.usecase.paymentoptiostype;

import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.shared.IExecuteArgs;

public interface IExecuteFindPaymentOptionTypeByIdUseCase extends IExecuteArgs<CustomData<PaymentOptionTypeDomainEntityOutput>, Long> {
}
