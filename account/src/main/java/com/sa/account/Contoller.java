package com.sa.account;

import com.sa.account.account_options.BankAccount;
import com.sa.account.account_options.CreditCard;
import com.sa.account.account_options.PayPal;
import com.sa.account.model.Account;
import com.sa.account.model.PaymentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class Contoller {
    @Autowired
    private AccountService service;
    @Autowired
    private PaymementRepo repo;
    @GetMapping("/get/{id}")
    public Account getUser(@PathVariable int id){
        return null;
    }
    @PostMapping("/save")
    public Account save(@RequestBody Account account){
        return service.save(account);
    }
    @PostMapping("/addCreditCard")
    public PaymentMethods addCreditCard(@RequestBody CreditCard card){
        return repo.save(card);
    }
    @PostMapping("/addBank")
    public PaymentMethods addBankAccount(@RequestBody BankAccount bank){
        return repo.save(bank);
    }
    @PostMapping("/addPayPal")
    public PaymentMethods addPayPal(@RequestBody PayPal pal){
        return repo.save(pal);
    }
    @GetMapping("/getaccount/{id}")
    public AccountDIO getAccount(@PathVariable int id){
        return service.getaccount(id);
    }
    @PostMapping("/setPrefered/{owner_id}/{method_id}")
    public String setPrefered(@PathVariable int owner_id,@PathVariable int method_id){
        return service.setPrefered(owner_id,method_id);
    }

    @GetMapping("/get/{email}/{password}")
    public String getUser(@PathVariable String email,@PathVariable String password){
        Account account=service.findByEmail(email,password);
        boolean acc=account.getEmail().equals(email)&&account.getPassword().equals(password);
        String response=acc?"true":"false";
        return response;
    }
    @GetMapping("/getPrefered/{id}")
    public PaymentMethods getPrefered(@PathVariable int id){
        System.out.println("here");
        return service.getPrefered(id);
    }
    @GetMapping("/getPaymentOption/{id}/{payment_option}")
    public PaymentMethods getPaymentOption(@PathVariable int id,@PathVariable int payment_option){
        return service.getPaymentOption(id,payment_option);
    }

}
