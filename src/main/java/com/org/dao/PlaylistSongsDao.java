package com.org.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.PSong;
import com.org.dto.Playlist;
import com.org.dto.Song;
import com.org.utility.Helper;

public class PlaylistSongsDao {

	public void saveAndUpdate(Playlist s) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(s);
		et.commit();

	}

	public List<Playlist> fetchAllPlaylistSongs() {

		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		String jpql = "select s from Playlist s";

		Query query = em.createQuery(jpql);

		List<Playlist> playlists = query.getResultList();

		return playlists;
	}

	public Playlist fetchPlaylistSongsById(int id) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();

		return em.find(Playlist.class, id);

	}

	public void removeSongFromPlaylist(int songId, int playlistId) {
		EntityManagerFactory emf = Helper.getEMFactory();

		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();

		PSong song = em.find(PSong.class, songId);
		Playlist playlistSongs = em.find(Playlist.class, playlistId);

		List<PSong> songs = playlistSongs.getSongs();
		List<PSong> list = new ArrayList<>();

		for (int i = 0; i < songs.size(); i++)
			if (songId != songs.get(i).getId()) {
				list.add(songs.get(i));
			}
		playlistSongs.setSongs(list);
		
		et.begin();
		em.merge(playlistSongs);
		em.remove(song);
		et.commit();
	}
}
