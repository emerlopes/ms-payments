package com.techchallenge.mspayments.application.exceptions;

public class PaymentOptionNotFoundException extends RuntimeException {
    public PaymentOptionNotFoundException(String message) {
        super(message);
    }
}
