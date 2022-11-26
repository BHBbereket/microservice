package com.sa.order;

import com.sa.order.DIOS.OrderDIO;
import com.sa.order.DIOS.PaymentDIO;
import com.sa.order.DIOS.ProductDTO;
import com.sa.order.payment.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderService {
    @Autowired
    private OrderRepo repo;
    @Autowired
    private RestTemplate template;
    public Order add(OrderDIO orderDIO, int cust_id){
        Order order= new Order();
        AtomicReference<Double> total= new AtomicReference<>(0.0);
        orderDIO.getProductDTOS().forEach(productDTO -> {
            productDTO.setOrder(order);
            String str=template.getForObject("http://sto-service:8084/api/stock/reduce/"+productDTO.getProduct_id()+"/"+productDTO.getQuantity(),String.class);
            TamplateProduct product=template.getForObject("http://pro-service:8083/api/product/"+productDTO.getProduct_id(),TamplateProduct.class);
            total.updateAndGet(v -> {
                assert product != null;
                return (double) (v + product.getPrice() * productDTO.getQuantity());
            });
        });

        order.setProductDTOS(orderDIO.getProductDTOS());
        order.setPayment_type_id(orderDIO.getPayment_id());
        order.setTotal_price(total.get());
        order.setCustomer_id(cust_id);
        return repo.save(order);
    }
    public Order get(int id){
        return repo.findById(id).get();
    }

    public String makepayment(int order) {
        Order order1=repo.findById(order).orElse(null);
        if (order1==null)
            return "order number doesn't exist";
        PaymentType type=new PaymentType();
        int payment_type=order1.getPayment_type_id();
        if(payment_type==0){
            type=template.getForObject("http://acc-service:8080/api/account/getPrefered/"+order1.getCustomer_id(),PaymentType.class);
            if(type==null)
                return "please set payment type, your account doesn't have prefered payment type. try again";
            else{
                //String paymentclass=type.getClass().getSimpleName();
                return requestforPayment(order1, type);
            }
        }else{
            type=template.getForObject("http://acc-service:8080/api/account/getPaymentOption/"+order1.getCustomer_id()+"/"+payment_type,PaymentType.class);
            if(type==null)
                return "payment type doesnt exist in your accouont. try again";
            else{
                //String paymentclass=type.getClass().getSimpleName();
                return requestforPayment(order1, type);
            }
        }



    }

    private String requestforPayment(Order order1, PaymentType type) {
        PaymentDIO dio=new PaymentDIO();
        dio.setOrder(order1);
        dio.setPaymentType(type);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PaymentDIO> requestEntity =
                new HttpEntity<>(dio, headers);
        String str=template.postForObject("http://pay-service:8085/api/payment/make",requestEntity,String.class);
        if(str.startsWith("succes")){
            order1.setPaid(true);
            repo.save(order1);
        }

        return str;
    }
}
