package com.sa.order.DIOS;

import com.sa.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private int product_id;
   private int quantity;
   @ManyToOne
   @JoinColumn(name = "order_id",referencedColumnName = "id")
   private Order order;
}
