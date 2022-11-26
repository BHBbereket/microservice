package com.sa.payment;

import lombok.Data;

import java.util.List;

@Data
public class OrderDIO {
    private int id;
    private List<Object> productDTOS;
    private double total_price;
    private int customer_id;
    private boolean isPaid;
}
