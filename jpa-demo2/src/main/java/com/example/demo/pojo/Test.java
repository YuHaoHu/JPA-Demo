package com.example.demo.pojo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Test {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-demo");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		User1Entity user1Entity = new User1Entity();
		user1Entity.setId(5);
		user1Entity.setName("555");
		user1Entity.setAge(18);
//		User1Entity user1Entity = entityManager.find(User1Entity.class,2);
//		user1Entity
		
		

		// 添加user到数据库，相当于hibernate的save();
		entityManager.persist(user1Entity);

		// 5. 提交事务
		transaction.commit();

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}

 

}
