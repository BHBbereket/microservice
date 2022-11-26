package com.sa.account.account_options;

import com.sa.account.model.PaymentMethods;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@ToString
@Data
public class CreditCard extends PaymentMethods {
    private int cardnumber;
    private String ccv;

}
