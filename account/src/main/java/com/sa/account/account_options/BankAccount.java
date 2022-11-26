package com.sa.account.account_options;

import com.sa.account.model.PaymentMethods;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@ToString
public class BankAccount extends PaymentMethods {
    private int account_number;
    private String account_type;

}
