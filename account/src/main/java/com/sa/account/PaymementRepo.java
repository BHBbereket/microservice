package com.sa.account;

import com.sa.account.model.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymementRepo extends JpaRepository<PaymentMethods,Integer> {
    @Query("select p from PaymentMethods as p where p.owner_id=?1")
    List<PaymentMethods> findByOwner(int id);
}
