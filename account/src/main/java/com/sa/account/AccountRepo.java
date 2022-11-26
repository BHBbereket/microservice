package com.sa.account;

import com.sa.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {
    @Query(value = "select a from Account as a where a.email=?1")
    Account findAccountByEmail(String email);
}
