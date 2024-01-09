<%@page import="com.org.dto.PSong"%>
<%@page import="com.org.dto.Song"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.PlaylistSongsDao"%>
<%@page import="com.org.dto.Playlist"%>
<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
<style type="text/css">
.card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%
	int id = (Integer) session.getAttribute("userId");
		UserDao dao = new UserDao();
		User user = dao.fetchUserById(id);
	%>
	<%@ include file="../components/user_navbar.jsp"%>
	<%
	int playlistId = Integer.parseInt(request.getParameter("playlistId"));
		session.setAttribute("playlistId", playlistId);
	%>



	<p class="fs-5">
		<a href="list_of_songs.jsp?playlistId=<%=playlistId%>"
			class="text-primary text-decoration-none fs-4"> Click </a> here to
		add Songs
	</p>
	<div class="container">
		<div class="row gy-3 my-3">
			<%
			Playlist playlist = new Playlist();
				PlaylistSongsDao dao1 = new PlaylistSongsDao();
				Playlist listSongs = dao1.fetchPlaylistSongsById(playlistId);

				List<PSong> list = listSongs.getSongs();

				boolean flag = true;
				for (PSong p : list) {
					flag = false;
			%>

			<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="card" style="width: 18rem;">

					<div class="card-body">
						<h5 class="card-title">
							Movie Name :
							<%=p.getMovieName()%>
						</h5>
						<p class="card-text">
							Year :
							<%=p.getYear()%></p>
						<p class="card-text">
							Song Name :
							<%=p.getSongName()%>
						</p>
						 <a
							href="../delete_song?songId=<%=p.getId()%>&playlistId=<%= playlistId %>"
							class="btn btn-sm btn-danger">Remove</a>
					</div>

				</div>

			</div>

			<%
			}
			if (flag) {
			%>
			<p class="text-ccenter fs-1 text-warning"><i class="fa-solid fa-face-frown"></i> No Songs are Added</p>
			<%
			}
			%>
		</div>
	</div>
	
				<a href="../user/create_playlist.jsp" class="btn btn-sm btn-info">Back to PlayList</a>
	



</body>
</html>