package com.techchallenge.mspayments.domain.usecase.parkingpaymenteeceipt;

import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityOutput;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.shared.IExecuteArgs;

public interface ExecuteIssuanceReceiptPaymentUseCase extends IExecuteArgs<CustomData<ParkingPaymentReceiptDomainEntityOutput>, ParkingPaymentReceiptDomainEntityInput> {
}
