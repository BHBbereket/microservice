package com.sa.account;

import com.sa.account.model.PaymentMethods;
import lombok.Data;

import java.util.List;

@Data
public class ReponseTemplate {
    private List<PaymentMethods> methods;
    private int prefered;
}
