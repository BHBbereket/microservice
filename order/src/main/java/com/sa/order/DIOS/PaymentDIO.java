package com.sa.order.DIOS;

import com.sa.order.Order;
import com.sa.order.payment.PaymentType;
import lombok.Data;

@Data
public class PaymentDIO {
    private Order order;
    private PaymentType paymentType;

}
