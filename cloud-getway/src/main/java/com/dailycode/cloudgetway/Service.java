//package com.dailycode.cloudgetway;
//
//import com.dailycode.cloudgetway.dioObjects.Account;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@org.springframework.stereotype.Service
//public class Service implements UserDetailsService {
//    @Autowired
//    private RestTemplate template;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account=template.getForObject("http://ACCOUNT-SERVICE/api/account/"+username,Account.class);
//        if(account==null)
//            throw new UsernameNotFoundException("user not found");
//        else{
//            System.out.println("user found by :"+username);
//        }
//        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
//        account.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        });
//
//        return new org.springframework.security.core.userdetails.User(account.getEmail(),account.getPassword(),authorities);
//    }
//}
