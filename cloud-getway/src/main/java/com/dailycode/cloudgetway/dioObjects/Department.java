package com.dailycode.cloudgetway.dioObjects;

public class Department {
    private Long id;
    private String name;
    private String address;
    private String dep_code;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDep_code() {
        return dep_code;
    }

    public void setDep_code(String dep_code) {
        this.dep_code = dep_code;
    }

    public Department(Long id, String name, String address, String dep_code) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dep_code = dep_code;
    }

    public Department(String name, String address, String dep_code) {
        this.name = name;
        this.address = address;
        this.dep_code = dep_code;
    }

    public Department() {
    }
}
