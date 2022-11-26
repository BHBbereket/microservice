package com.sa.order.payment;

import lombok.Data;

@Data
public class PaymentType {
    private int id;
    private String name;
    private int owner_id;
}
