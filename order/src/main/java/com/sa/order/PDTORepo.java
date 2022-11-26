package com.sa.order;

import com.sa.order.DIOS.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PDTORepo extends JpaRepository<ProductDTO,Integer> {
}
