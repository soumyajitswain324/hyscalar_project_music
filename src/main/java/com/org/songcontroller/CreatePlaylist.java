package com.org.songcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PlaylistSongsDao;
import com.org.dao.UserDao;
import com.org.dto.Playlist;
import com.org.dto.User;

@WebServlet("/create_playlist")
public class CreatePlaylist extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("playlistName");
		HttpSession session = req.getSession();
		int id = (int)session.getAttribute("userId");
		
		User user = new UserDao().fetchUserById(id);
		
		List<Playlist> playlists = user.getPlaylists();
		
		
		Playlist songs = new Playlist();
		songs.setPlaylistName(name);
		
		playlists.add(songs);
		songs.setUser(user);
		
		PlaylistSongsDao dao = new PlaylistSongsDao();
		dao.saveAndUpdate(songs);
		
		resp.sendRedirect("user/create_playlist.jsp");
	}
}
