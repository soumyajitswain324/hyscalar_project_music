package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.PSong;
import com.org.utility.Helper;

public class PSongDao {
	

	public void saveAndUpdate(PSong s) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(s);
		et.commit();

	}

	public List<PSong> fetchAllPSongs() {

		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		String jpql = "select s from PSong s";

		Query query = em.createQuery(jpql);

		List<PSong> songs = query.getResultList();

		return songs;
	}

	public PSong fetchPSongById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		return em.find(PSong.class, id);
		
	}
}
