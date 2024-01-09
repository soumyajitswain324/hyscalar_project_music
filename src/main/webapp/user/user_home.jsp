<%@page import="com.org.dto.Song"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.SongDao"%>
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
		<p class="text-primary text-center fs-3">Welcome</p>
	<div class="container">
		<div class="row gy-3 my-3">
			<%
			SongDao dao1 = new SongDao();
			List<Song> list = dao1.fetchAllSongs();
			for (Song p : list) {
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
					</div>

				</div>

			</div>
			
			<%
			}
			%>

		</div>
	</div>
</body>
</html>