<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.Playlist"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.PlaylistSongsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%
	int id = (Integer) session.getAttribute("userId");
	UserDao dao = new UserDao();
	User user = dao.fetchUserById(id);
	if(user.getStatus().equals("inactive")){
		%>
			
			<p class="text-center text-danger fs-1"> Your status is Inactive. Please come after Sometime</p>
		
		<%
		
		
		
	}
	else{
	%>
	<%@ include file="../components/user_navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<form action="../create_playlist">
							<div class="mb-3">
								<input name="playlistName" type="text" class="form-control"
									required>
							</div>
							<button type="submit" class="btn bg-info text-white col-md-12">Create</button>
						</form>

						<%
						List<Playlist> playList = user.getPlaylists();

						for (Playlist p : playList) {
						%>
						<div class="container p-2">
							<div class="card paint-card">
								<div class="card-body">
									<p class="text-primary text-center fs-6">
										<a href="playlist_songs.jsp?playlistId=<%=p.getId()%>"
											class="text-secondary fs-3 text-decoration-none"> <%=p.getPlaylistName()%>
											<br> <span class="text-primary text-center fs-6">
												Click Here to View Songs</span>
										</a>
									</p>
								</div>
							</div>
						</div>
						<%
						}
						%>
			<a href="../user/user_home.jsp" class="btn btn-sm btn-info">Back to Music</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%} %>
</body>
</html>