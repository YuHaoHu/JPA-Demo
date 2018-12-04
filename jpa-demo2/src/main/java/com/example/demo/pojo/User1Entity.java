package com.example.demo.pojo;

import javax.persistence.*;


@Entity
@Table(name = "user1", schema = "sqdb1", catalog = "")
public class User1Entity {
    private String name;
    private Integer age;
    private Integer id;
    
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Column(name = "id")
    @Id
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
   
}
