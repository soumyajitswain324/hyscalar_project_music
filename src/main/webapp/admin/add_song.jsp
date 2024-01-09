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
	<%@ include file="../components/admin_navbar.jsp"%>



	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center text-info">Add Songs</p>

						<%
						String str = (String) session.getAttribute("added");

						if (str != null) {
						%>
							<p class="text text-center fs-4 text-success"> <%= str %> </p> 

						<%
							session.removeAttribute("added");
						}
						%>
						<form action="../add_song" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Year</label> <input name="year"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Movie Name</label> <input name="movie"
									type="text" class="form-control" required>
							</div>
							<button type="submit" class="btn bg-info text-white col-md-12">Add
								This Song</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>