package com.techchallenge.mspayments.repositories.paymentsdatabase.service;

import com.techchallenge.mspayments.application.mapper.ParkingPaymentReceiptMappers;
import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityInput;
import com.techchallenge.mspayments.domain.entity.ParkingPaymentReceiptDomainEntityOutput;
import com.techchallenge.mspayments.domain.service.IssuanceReceiptPaymentDomainService;
import com.techchallenge.mspayments.repositories.paymentsdatabase.repository.ParkingPaymentReceiptEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class IssuanceReceiptPaymentDomainServiceImpl implements IssuanceReceiptPaymentDomainService {

    private final ParkingPaymentReceiptEntityRepository parkingPaymentReceiptEntityRepository;

    public IssuanceReceiptPaymentDomainServiceImpl(ParkingPaymentReceiptEntityRepository parkingPaymentReceiptEntityRepository) {
        this.parkingPaymentReceiptEntityRepository = parkingPaymentReceiptEntityRepository;
    }

    @Override
    public ParkingPaymentReceiptDomainEntityOutput saveIssuanceReceiptPayment(ParkingPaymentReceiptDomainEntityInput input) {
        final var entity = ParkingPaymentReceiptMappers.mapToParkingPaymentReceiptEntity(input);
        final var entitySaved = parkingPaymentReceiptEntityRepository.save(entity);

        return ParkingPaymentReceiptMappers.mapToParkingPaymentReceiptDomainEntityOutput(entitySaved);
    }
}
