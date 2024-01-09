package com.techchallenge.mspayments.repositories.paymentsdatabase.dto;

public enum PaymentOptionTypeEnum {
    CREDIT_CARD("Cartão de Crédito"),
    DEBIT_CARD("Débito"),
    PIX("Pix");

    private String displayName;

    PaymentOptionTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

