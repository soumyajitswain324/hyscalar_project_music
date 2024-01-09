package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.User;
import com.org.utility.Helper;

public class UserDao {

	public void saveAndUpdate(User s) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(s);
		et.commit();
		
	}

	public List<User> fetchUserByEmailPassword(String email, String password) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		String jpql = "select p from User p where p.email=?1 and p.password=?2";

		Query query = em.createQuery(jpql);

		query.setParameter(1, email);
		query.setParameter(2, password);

		List<User> users = query.getResultList();

		return users;

	}

	public List<User> fetchAllUsers() {

		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		String jpql = "select s from User s";

		Query query = em.createQuery(jpql);

		List<User> users = query.getResultList();

		return users;
	}

	public User fetchUserById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		return em.find(User.class, id);

	}
}
