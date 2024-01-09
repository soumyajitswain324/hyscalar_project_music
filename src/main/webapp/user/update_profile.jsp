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
	%>
	<%@ include file="../components/user_navbar.jsp"%>


	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center"><%=user.getName()%>
							Profile
						</p>
						<p class="fs-4 text-center text-success">
							<%
							String str = (String) session.getAttribute("success");
							if (str != null) {
							%>
							 <%=str%>
							<%
							session.removeAttribute("success");
							
							}
							%>
						</p>

						<form action="../user_update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" value="<%=user.getName()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									value="<%=user.getMobile()%>" type="text"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input name="email"
									value="<%=user.getEmail()%>" type="email"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input
									value="<%=user.getPassword()%>" name="password"
									type="password" class="form-control" required>
							</div>
							<input type="hidden" name="id" value="<%=user.getId()%>">

							<button type="submit" class="btn bg-info text-white col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>