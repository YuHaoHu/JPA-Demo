package com.example.demo.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Table(name = "j_order")
@Entity
public class Order {
    private int id;
    private String name;
   // private Customer customer;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    @Column(name = "o_name")
    public String getName() {
        return name;
    }
   /* @JoinColumn(name = "CUSTOMER_ID")
    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/
}
