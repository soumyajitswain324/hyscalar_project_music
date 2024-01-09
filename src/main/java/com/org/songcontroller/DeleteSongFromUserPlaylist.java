package com.org.songcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.PlaylistSongsDao;
import com.org.dao.SongDao;
import com.org.dto.Playlist;
import com.org.dto.Song;

@WebServlet("/delete_song")
public class DeleteSongFromUserPlaylist extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int songId =Integer.parseInt( req.getParameter("songId"));
		
		int playlistId =Integer.parseInt(req.getParameter("playlistId"));
		
		new PlaylistSongsDao().removeSongFromPlaylist(songId,playlistId);
		
		resp.sendRedirect("user/list_of_songs.jsp");
		
	}
}
