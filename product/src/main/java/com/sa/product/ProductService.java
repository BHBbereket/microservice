package com.sa.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;
    @Autowired
    private RestTemplate template;
    private final String baseurl="http://sto-service:8084/api/stock";
    public Product save(Product product){
        repo.saveAndFlush(product);
        StockDIO response=template.getForObject(baseurl+"/save/"+product.getId()+"/"+55,StockDIO.class);
        return product;

    }
    public List<Product> addList(List<Product> products){
        products.forEach(product -> {
            repo.saveAndFlush(product);
            StockDIO response=template.getForObject(baseurl+"/save/"+product.getId()+"/"+55,StockDIO.class);
        });
        return products;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(int id) {
        return repo.findById(id).get();
    }
}
