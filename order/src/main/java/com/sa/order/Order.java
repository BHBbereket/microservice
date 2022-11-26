package com.sa.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sa.order.DIOS.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product_order")
public class Order {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ProductDTO> productDTOS;
    private double total_price;
    private int customer_id;
    @ColumnDefault(value = "false")
    private boolean isPaid;
    @ColumnDefault("0")
    private int payment_type_id;

}
