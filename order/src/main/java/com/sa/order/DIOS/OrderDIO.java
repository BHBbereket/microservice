package com.sa.order.DIOS;

import lombok.Data;

import java.util.List;

@Data
public class OrderDIO {
    private int payment_id;
    private List<ProductDTO> productDTOS;

}
