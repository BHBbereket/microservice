package com.sa.payment.payment.account_options;

import com.sa.payment.payment.PaymentType;
import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class PayPal extends PaymentType {
    private int paypal_number;
    private String issued_Country;

    @Override
    public String makePayment(double amount){
        return "here paypal "+ amount;
    }
}
