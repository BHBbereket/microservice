package com.sa.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {
    @Autowired
    private StockRepo repo;
    private RestTemplate template=new RestTemplate();
    public Stock addAmount(int id,int amount){
        Stock p=repo.findStockByProduct_id(id);
        p.setAmount(amount);
        repo.save(p);
        return p;
    }
    public Stock save(Stock stock){
        return repo.save(stock);
    }
    public String reduceAmmount(int id,int amount){
        Stock p=repo.findStockByProduct_id(id);
        int balance= p.getAmount();
        if(balance<50||balance<amount){
            Stock response=addAmount(id,2*balance-amount);
            System.out.println(response.getProduct_id()+" from add amount"+response.getAmount());
        }else{
            addAmount(id,balance-amount);
        }
//        p=repo.findStockByProduct_id(id);
//        p.setAmount(p.getAmount()-amount);
        repo.save(p);
        return "order placed successfully";
    }
}
