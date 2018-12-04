package com.example.demo.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "j_cuntomer")
@Entity
public class Customer {
    private int id;
    private String name;
    private int age;
    private Set<Order> orderSet = new HashSet();
    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @JoinColumn(name = "CUSTOMER")
    @OneToMany(cascade = {CascadeType.REMOVE})
    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
