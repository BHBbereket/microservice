package com.dailycode.cloudgetway;

import com.dailycode.cloudgetway.dioObjects.Department;
import com.dailycode.cloudgetway.dioObjects.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/accountServiceFalback")
    public Account accountServiceFallBackMethod(){
        System.out.println("user service is taking longer than expected.\n  please try again ....\n");
        return null;
    }
    @GetMapping("/productServiceFalback")
    public Account productServiceFallBackMethod(){
        System.out.println("user service is taking longer than expected.\n  please try again ....\n");
        return null;
    }
    @GetMapping("/orderServiceFallBack")
    public Department orderServiceFallBackMethod(){
        System.out.println("department-service service is taking longer than expected.\n  please try again ....\n");
        return null;
    }

}
