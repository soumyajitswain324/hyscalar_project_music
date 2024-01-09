<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.AdminDao"%>
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
	<%@ include file="../components/navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center text-info">Admin Login</p>
						<%
						String id = (String) session.getAttribute("fail");
						if (id != null) {
						%>

						<p class="text-center text-danger fs-5">
							<%=id%>
						</p>
						<%
						session.removeAttribute("fail");
						}
						%>

						<form action="../admin_login" method="post">
							<div class="mb-3">
								<label class="form-label">Email</label> <input name="email"
									type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<button type="submit" class="btn bg-info text-white col-md-12">Login</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>