package com.techchallenge.mspayments.domain.usecase.parkingpaymenteeceipt.impl;

import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IssuanceReceiptPaymentDomainService;
import com.techchallenge.mspayments.domain.usecase.parkingpaymenteeceipt.ExecuteIssuanceReceiptPaymentUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteIssuanceReceiptPaymentUseCaseImpl implements ExecuteIssuanceReceiptPaymentUseCase {

    private final IssuanceReceiptPaymentDomainService issuanceReceiptPaymentDomainService;

    public ExecuteIssuanceReceiptPaymentUseCaseImpl(IssuanceReceiptPaymentDomainService issuanceReceiptPaymentDomainService) {
        this.issuanceReceiptPaymentDomainService = issuanceReceiptPaymentDomainService;
    }

    @Override
    public ParkingPaymentReceiptDomainEntityOutput execute(Long parkingControlId) {

//        return issuanceReceiptPaymentDomainService.saveIssuanceReceiptPayment();

        return null;
    }
}
