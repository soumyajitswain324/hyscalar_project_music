package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.Admin;
import com.org.utility.Helper;

public class AdminDao {

	public void saveAndUpdate(Admin s) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(s);
		et.commit();

	}

	public List<Admin> fetchAdminByEmailPassword(String email, String password) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		String jpql = "select p from Admin p where p.email=?1 and p.password=?2";

		Query query = em.createQuery(jpql);

		query.setParameter(1, email);
		query.setParameter(2, password);

		List<Admin> admins = query.getResultList();

		return admins;

	}

	public List<Admin> fetchAllAdmins() {

		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		String jpql = "select s from Admin s";

		Query query = em.createQuery(jpql);

		List<Admin> admins = query.getResultList();

		return admins;
	}

	public Admin fetchAdminById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		return em.find(Admin.class, id);

	}
}
