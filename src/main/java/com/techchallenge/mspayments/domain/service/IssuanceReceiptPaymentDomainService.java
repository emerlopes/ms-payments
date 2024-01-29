package com.techchallenge.mspayments.domain.service;

import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityOutput;

public interface IssuanceReceiptPaymentDomainService {

    ParkingPaymentReceiptDomainEntityOutput saveIssuanceReceiptPayment(ParkingPaymentReceiptDomainEntityInput input);
}
