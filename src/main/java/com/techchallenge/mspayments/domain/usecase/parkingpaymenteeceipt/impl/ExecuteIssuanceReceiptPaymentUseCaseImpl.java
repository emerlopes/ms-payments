package com.techchallenge.mspayments.domain.usecase.parkingpaymenteeceipt.impl;

import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IssuanceReceiptPaymentDomainService;
import com.techchallenge.mspayments.domain.shared.CustomData;
import com.techchallenge.mspayments.domain.usecase.parkingpaymenteeceipt.ExecuteIssuanceReceiptPaymentUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteIssuanceReceiptPaymentUseCaseImpl implements ExecuteIssuanceReceiptPaymentUseCase {

    private final IssuanceReceiptPaymentDomainService issuanceReceiptPaymentDomainService;

    public ExecuteIssuanceReceiptPaymentUseCaseImpl(IssuanceReceiptPaymentDomainService issuanceReceiptPaymentDomainService) {
        this.issuanceReceiptPaymentDomainService = issuanceReceiptPaymentDomainService;
    }

    @Override
    public CustomData<ParkingPaymentReceiptDomainEntityOutput> execute(ParkingPaymentReceiptDomainEntityInput input) {
        final var output = issuanceReceiptPaymentDomainService.saveIssuanceReceiptPayment(input);
        final CustomData<ParkingPaymentReceiptDomainEntityOutput> customData = new CustomData<>();

        customData.setData(output);

        return customData;
    }
}
