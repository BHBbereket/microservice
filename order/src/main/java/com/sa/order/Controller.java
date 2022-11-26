package com.sa.order;

import com.sa.order.DIOS.OrderDIO;
import com.sa.order.DIOS.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class Controller {
    @Autowired
    private OrderService service;
    @PostMapping("/add/{cust_id}")
    public Order add(@RequestBody OrderDIO orderDIO, @PathVariable int cust_id){
        return service.add(orderDIO,cust_id);
    }
    @GetMapping("/get/{id}")
    public Order get(@PathVariable int id){
        return service.get(id);
    }

    @PostMapping("/make_payment/{id}")
    public String makePayment(@PathVariable int id){
        return service.makepayment(id);
    }
}
