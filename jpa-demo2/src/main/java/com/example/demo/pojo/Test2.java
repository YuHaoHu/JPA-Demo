package com.example.demo.pojo;

import javax.persistence.*;
import java.util.List;

public class Test2 {
    @PersistenceContext
    EntityManager em;
    public static void main(String[] args) {
        // 1. 创建EntityManagerFactory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-demo");
    
    // 2. 创建EntityManager
    EntityManager entityManager = factory.createEntityManager();
    
//      addUser(entityManager);
    //  addAuthority(entityManager);
//        delUser(entityManager);
    
        delAuthority(entityManager);
    
    // 6. 关闭EntityManager----
        entityManager.close();
    
    // 7. 关闭EntityManagerFactory
        factory.close();
}
    
    //添加用户
    public static  void addUser(EntityManager entityManager){
    
        // 3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Authority> authorities = entityManager.createQuery("select  a from Authority a").getResultList();
    
        // 4. 持久化操作
        User user = new User();
        user.setAuthorityList(authorities);
        user.setUsername("345");
        user.setPassword("3333");
    
        // 添加user到数据库，相当于hibernate的save();
        entityManager.persist(user);
    
        // 5. 提交事务
        transaction.commit();
    }
    
    //添加图书
    public static  void addAuthority(EntityManager entityManager){
        // 3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        
        // 4. 持久化操作
        Authority a = new Authority();
        a.setName("lllll");
        
        // 添加user到数据库，相当于hibernate的save();
        entityManager.persist(a);
    
        // 5. 提交事务
        transaction.commit();
    }
    
    //删除用户
    public static void delUser(EntityManager entityManager){
        //3.开启事务
        EntityTransaction transaction =entityManager.getTransaction();
        transaction.begin();
        //4.持久化操作
        User u =entityManager.find(User.class,10);
        entityManager.remove(u);
        //5.添加到数据库
        transaction.commit();
    }
    
    //删除图书
    public static void delAuthority(EntityManager entityManager){
        //3.开启事务
        EntityTransaction transaction =entityManager.getTransaction();
        transaction.begin();
        //4.持久化操作
        Authority a = entityManager.find(Authority.class,1);
        entityManager.remove(a);
        //5.添加到数据库
        transaction.commit();
    }
    
}
