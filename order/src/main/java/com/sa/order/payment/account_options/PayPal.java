package com.sa.order.payment.account_options;

import com.sa.order.payment.PaymentType;
import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class PayPal extends PaymentType {
    private int paypal_number;
    private String issued_Country;
}
