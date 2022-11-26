package com.sa.payment.payment.account_options;

import com.sa.payment.payment.PaymentType;
import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class CreditCard extends PaymentType {
    private int cardnumber;
    private String ccv;

    @Override
    public String makePayment(double amount){
        return "here creditcard "+ amount;
    }

}
