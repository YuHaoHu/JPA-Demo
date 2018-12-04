package com.example.demo;

import com.example.demo.pojo.User1Entity;

import javax.persistence.*;

public class DemoApplication {
    @PersistenceContext
    EntityManager em;
    public static void main(String[] args) {
    
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test2");
        
        EntityManager entityManager = factory.createEntityManager();
    
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
    
        User1Entity user1Entity = new User1Entity();
        user1Entity.setId(5);
        user1Entity.setName("555");
        user1Entity.setAge(18);
        
        entityManager.persist(user1Entity);
        
        transaction.commit();
        
        entityManager.close();
        factory.close();
        
    }
}
