package com.sa.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class Controller {
    @Autowired
    private ProductService service;
    @PostMapping("/addProduct")
    public Product save(@RequestBody Product product){
        return service.save(product);
    }
    @PostMapping("/addlist")
    public List<Product> addList(@RequestBody List<Product> products){
        return service.addList(products);
    }
    @GetMapping("/getAll")
    public List<Product> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return service.getById(id);
    }

}
