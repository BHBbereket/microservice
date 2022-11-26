package com.sa.account;

import com.sa.account.model.Account;
import com.sa.account.model.PaymentMethods;
import com.sa.account.model.Role;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepo repo;
//    @Autowired
//    private PasswordEncoder encoder;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PaymementRepo paymementRepo;
    public Account save(Account account){
        //System.out.println(account.getMethods());
        //account.setPassword(encoder.encode(account.getPassword()));
        //System.out.println(account.getRoles().toString());
        //List<Role> roles=account.getRoles();
        repo.save(account);
//        roles.forEach(role -> {
//            role.setAccount(account);
//            System.out.println(role.toString());
//        });
       // roleRepo.saveAll(roles);
       // account.getRoles().forEach(role -> role.setAccount(account));
        return account;
    }
    public AccountDIO getaccount(int id){
        Account account=repo.findById(id).get();
        List<PaymentMethods> dios=new ArrayList<>();
        if(account!=null){
           dios =paymementRepo.findByOwner(id);
        }
        AccountDIO accountDIO=new AccountDIO();
        accountDIO.setAccount(account);
        accountDIO.setMethods(dios);
        return accountDIO;
    }
    public String setPrefered(int id,int method){
        Account account=repo.findById(id).get();
        account.setPrefered_type_id(method);
        repo.save(account);
        return "successfully setted";
    }
    public Account getUser(String email){
        return repo.findAccountByEmail(email);
    }

    public PaymentMethods getPrefered(int id) {
        Account account= repo.findById(id).get();
        int preferd=account.getPrefered_type_id();
        PaymentMethods p=paymementRepo.findById(preferd).get();
        System.out.println(p.getName());
        return p;//paymementRepo.findById(preferd).orElse(null);
    }

    public PaymentMethods getPaymentOption(int id, int payment_option) {
        //Account account=repo.findById(id);
        PaymentMethods paymentMethods=paymementRepo.findById(payment_option).orElse(null);
        return paymentMethods;
    }

    public Account findByEmail(String email, String password) {
        return repo.findAccountByEmail(email);
    }
}
