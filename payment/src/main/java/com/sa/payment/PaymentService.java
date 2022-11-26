package com.sa.payment;

import com.sa.payment.payment.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class PaymentService {
    @Autowired
    private RestTemplate template;
    public String makepayment(PaymentDIO orderDIO) {
        String method=orderDIO.getPaymentType().getName();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        Payload payload=new Payload();
        payload.setPrice(orderDIO.getOrder().getTotal_price());
        HttpEntity<Payload> requestEntity =
                new HttpEntity<>(payload, headers);
        System.out.println(method+" "+ payload.getPrice());
        String response;
        if(method.equals("bank")){
             response=template.postForObject("http://ban-service:8011/api/bank/make",requestEntity,String.class);
        } else if (method.equals("paypal")) {
             response=template.postForObject("http://pal-service:8012/api/paypal/make",requestEntity,String.class);
        }else if (method.equals("creditcard")){
             response=template.postForObject("http://cre-service:8010/api/creditcard/make",requestEntity,String.class);
        }else
            return null;
        System.out.println(response);
        return response;
    }
}
