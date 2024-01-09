package com.org.songcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.SongDao;
import com.org.dto.Song;

@WebServlet("/update_song")
public class Update_Song extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter("songId"));
		
		Song song = new SongDao().fetchSongById(id);
		String name = req.getParameter("name");
		String year = req.getParameter("year");
		String movie = req.getParameter("movie");
		
		song.setSongName(name);
		song.setYear(Integer.parseInt(year));
		song.setMovieName(movie);
		
		new SongDao().saveAndUpdate(song);
		
		resp.sendRedirect("admin/admin_home.jsp");
		
	}
}
