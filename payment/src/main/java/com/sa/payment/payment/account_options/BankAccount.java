package com.sa.payment.payment.account_options;


import com.sa.payment.payment.PaymentType;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class BankAccount extends PaymentType {
    private int account_number;
    private String account_type;
    @Override
    public String makePayment(double amount){
        return "here Bank account "+ amount;
    }

}
