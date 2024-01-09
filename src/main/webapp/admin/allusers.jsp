<%@page import="com.org.dto.User"%>
<%@page import="java.util.List"%>
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
<%@ include file="../components/admin_navbar.jsp"%>

	
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>

						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Mobile</th>
									<th>Email</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody>
								<% List<User> users = new UserDao().fetchAllUsers(); 
									for(User user : users){
										%>
										
										<tr>
											<td><%= user.getName() %> </td>
											<td><%= user.getMobile() %> </td>
											<td><%= user.getEmail() %></td>
											<td>
											
											
											
											<% String status = user.getStatus();
												if(status.equals("inactive"))
												{%>
											<a href="../update_user_status?userId=<%= user.getId() %>" class="btn btn-sm btn-success">Active</a>
												
												
													
											<%	}
												else{
													%>
											<a href="../update_user_status?userId=<%= user.getId() %>" class="btn btn-sm btn-danger">InActive</a>
													
													
													<%
												}
											%>
											
											</td>
										</tr>										
										
										<%
										
										
									}
								
								%>
							</tbody>
						</table>
					<a href="../admin/admin_home.jsp" class="btn btn-sm btn-info">Back to Home</a>
						
					</div>
				</div>
			</div>
		</div>
	</div>

	
</body>
</html>