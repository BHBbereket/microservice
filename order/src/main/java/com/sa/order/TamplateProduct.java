package com.sa.order;

import lombok.Data;

@Data
public class TamplateProduct {
    private int id;
    private String name;
    private double price;
    private String vendor;
    private Category category;
}
