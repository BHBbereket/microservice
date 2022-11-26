package com.sa.payment;

import com.sa.payment.payment.PaymentType;
import lombok.Data;

@Data
public class PaymentDIO {
    private OrderDIO order;
    private PaymentType paymentType;

}
