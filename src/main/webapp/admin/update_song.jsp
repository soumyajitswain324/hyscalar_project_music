<%@page import="com.org.dto.Song"%>
<%@page import="com.org.dao.SongDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<%@include file="../components/allcss.jsp"%>
</head>
<body>

	<%@include file="../components/admin_navbar.jsp"%>


	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center text-info">Add Songs</p>

						<%
						int songId = Integer.parseInt(request.getParameter("songId"));

						Song song = new SongDao().fetchSongById(songId);
						String str = (String) session.getAttribute("updated");

						if (str != null) {
						%>
						<p class="text text-center fs-4 text-success">
							<%=str%>
						</p>

						<%
						session.removeAttribute("updated");
						}
						%>
						<form action="../update_song" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" value="<%=song.getSongName()%>"
									class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Year</label> <input name="year"
									type="text" class="form-control" value="<%=song.getYear()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Movie Name</label> <input name="movie"
									type="text" class="form-control"
									value="<%=song.getMovieName()%>" required>
							</div>

							<input type="hidden" name="songId" value="<%=song.getId()%>">
							<button type="submit" class="btn bg-info text-white col-md-12">Update
								This Song</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>