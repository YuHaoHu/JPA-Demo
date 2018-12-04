package com.example.demo.pojo;

import javax.persistence.*;
import java.util.List;

public class Test3 {
    @PersistenceContext
    EntityManager em;
    
    public static void main(String[] args) {
        EntityManagerFactory factory =Persistence.createEntityManagerFactory("jpa-demo");
        EntityManager entityManager=factory.createEntityManager();
//        addPerson(entityManager);
        addDuty(entityManager);
        entityManager.close();
        factory.close();
    }
    private static void  addPerson(EntityManager entityManager){
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        List<Duty> duties=entityManager.createQuery("select d from Duty  d").getResultList();
        Person person=new Person();
       
        person.setDutyList(duties);
        person.setName("小王");
        person.setAge("18");
        entityManager.persist(person);
        
        transaction.commit();
    }
    
    private static  void  addDuty(EntityManager entityManager){
        // 3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        
        Duty duty = new Duty();
        duty.setpDuty("班长");
        entityManager.persist(duty);
        
        transaction.commit();
        
    }
}
