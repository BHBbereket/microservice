package com.sa.payment.payment;

import lombok.Data;

@Data
public class PaymentType {
    private int id;
    private String name;
    private int owner_id;

    public String makePayment(double amount){
        return null;
    }
}
