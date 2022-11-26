package com.dailycode.cloudgetway.dioObjects;

import lombok.Data;

import java.util.List;
@Data
public class Account {
    private int id;
    private String fristname;
    private String lastname;
    private String email;
    private String password;
    private List<Role> roles;
    private int prefered_type_id;
}
