package com.org.songcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PSongDao;
import com.org.dao.PlaylistSongsDao;
import com.org.dao.SongDao;
import com.org.dto.PSong;
import com.org.dto.Playlist;
import com.org.dto.Song;

@WebServlet("/add_to_playlist")
public class AddToPlaylist extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int songId =Integer.parseInt( req.getParameter("songId"));
		int playlistId =Integer.parseInt( req.getParameter("playlistId"));
		
		Song so = new SongDao().fetchSongById(songId);
		
		PSong psong = new PSong();
		psong.setId(so.getId());
		psong.setMovieName(so.getMovieName());
		psong.setSongName(so.getSongName());
		psong.setYear(so.getYear());
		
		
		Playlist playlist = new PlaylistSongsDao().fetchPlaylistSongsById(playlistId);
		
		List<PSong> songs = playlist.getSongs();
		songs.add(psong);
		
		List<Playlist> playlists = psong.getPlaylistSongs();
		playlists.add(playlist);
		
		psong.setPlaylistSongs(playlists);
		playlist.setSongs(songs);
		
		PlaylistSongsDao dao = new PlaylistSongsDao();
		dao.saveAndUpdate(playlist);
		
		HttpSession session = req.getSession();
		session.setAttribute("song_added","Added");
		resp.sendRedirect("user/list_of_songs.jsp");
		
	}
}
