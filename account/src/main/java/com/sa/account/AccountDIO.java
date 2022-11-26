package com.sa.account;

import com.sa.account.model.Account;
import com.sa.account.model.PaymentMethods;
import lombok.Data;

import java.util.List;

@Data
public class AccountDIO {

    private Account account;
    private List<PaymentMethods> methods;

}
