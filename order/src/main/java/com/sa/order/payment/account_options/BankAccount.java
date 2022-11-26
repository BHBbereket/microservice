package com.sa.order.payment.account_options;

import com.sa.order.payment.PaymentType;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class BankAccount extends PaymentType {
    private int account_number;
    private String account_type;

}
