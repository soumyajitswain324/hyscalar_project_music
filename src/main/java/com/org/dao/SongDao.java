package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.Song;
import com.org.utility.Helper;

public class SongDao {


	public void saveAndUpdate(Song s) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(s);
		et.commit();

	}

	public List<Song> fetchAllSongs() {

		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		String jpql = "select s from Song s";

		Query query = em.createQuery(jpql);

		List<Song> songs = query.getResultList();

		return songs;
	}

	public Song fetchSongById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		return em.find(Song.class, id);
		
	}
}
