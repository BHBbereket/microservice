package com.sa.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<Stock,Integer> {
    @Query("select s from Stock as s where s.product_id=?1")
    public Stock findStockByProduct_id(int id);
}
