package com.org.songcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PSongDao;
import com.org.dao.SongDao;
import com.org.dto.PSong;
import com.org.dto.Song;

@WebServlet("/add_song")
public class AddSong extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String year = req.getParameter("year");
		String movie = req.getParameter("movie");
		
		Song song = new Song();
		song.setSongName(name);
		song.setYear(Integer.parseInt(year));
		song.setMovieName(movie);
		
		PSong psong = new PSong();
		psong.setSongName(name);
		psong.setYear(Integer.parseInt(year));
		psong.setMovieName(movie);
	
		new SongDao().saveAndUpdate(song);
		new PSongDao().saveAndUpdate(psong);
		
		HttpSession session = req.getSession();
		session.setAttribute("added", "Song added successfully");
		
		resp.sendRedirect("admin/add_song.jsp");
	}
}
