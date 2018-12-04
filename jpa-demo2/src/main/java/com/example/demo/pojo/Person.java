package com.example.demo.pojo;

import javax.persistence.*;
import java.util.List;

//当实体类与其映射的数据库表名不同名时需要使用 @Table 标注说明，
// 该标注与 @Entity 标注并列使用，置于实体类声明语句之前，可写于单独语句行，也可与声明语句同行
@Table(name = "PERSON")
@Entity
@NamedQuery(name= "Person.findAll",query = "select p from Person p")

public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长
    private Integer id;
    @Column(nullable = false,length =20,unique = true)
    private String name;//姓名
    @Column(length =4)
    private  String age;
    @ManyToMany
    @JoinTable(name = "person_duty",joinColumns = @JoinColumn(name = "person_id"),inverseJoinColumns = @JoinColumn(name="duty_id"))
  
    private List<Duty> dutyList;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAge() {
        return age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    public List<Duty> getDutyList() {
        return dutyList;
    }
    
    public void setDutyList(List<Duty> dutyList) {
        this.dutyList = dutyList;
    }
}
