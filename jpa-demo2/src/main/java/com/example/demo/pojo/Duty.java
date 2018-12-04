package com.example.demo.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Duty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String pDuty;         //职务
    @ManyToMany(mappedBy = "dutyList")
    private List<Person> personList;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getpDuty() {
        return pDuty;
    }
    
    public void setpDuty(String pDuty) {
        this.pDuty = pDuty;
    }
    
    public List<Person> getPersonList() {
        return personList;
    }
    
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
