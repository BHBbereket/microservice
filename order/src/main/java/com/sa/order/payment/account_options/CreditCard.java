package com.sa.order.payment.account_options;

import com.sa.order.payment.PaymentType;
import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class CreditCard extends PaymentType {
    private int cardnumber;
    private String ccv;

}
