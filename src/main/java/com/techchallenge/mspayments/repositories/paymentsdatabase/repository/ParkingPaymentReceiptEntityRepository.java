package com.techchallenge.mspayments.repositories.paymentsdatabase.repository;

import com.techchallenge.mspayments.repositories.paymentsdatabase.entity.ParkingPaymentReceiptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPaymentReceiptEntityRepository extends JpaRepository<ParkingPaymentReceiptEntity, Long> {
}
