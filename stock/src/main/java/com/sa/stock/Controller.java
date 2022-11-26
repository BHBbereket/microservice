package com.sa.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class Controller {
    @Autowired
    private StockService service;

    @GetMapping("/save/{id}/{amount}")
    public Stock save(@PathVariable int id, @PathVariable int amount){
        Stock stock=new Stock(0,id,amount);
        return service.save(stock);
    }
    @GetMapping("/reduce/{id}/{amount}")
    public String getStock(@PathVariable int id, @PathVariable int amount){
        return service.reduceAmmount(id,amount);
    }



}
