package com.techchallenge.mspayments.domain.usecase.paymentoptiostype;

import com.techchallenge.mspayments.domain.entity.PaymentOptionTypeDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.shared.IExecuteNoArgs;

import java.util.List;

public interface IExecuteFindAllPaymentOptionsTypeUseCase extends IExecuteNoArgs<CustomData<List<PaymentOptionTypeDomainEntityOutput>>> {
}
