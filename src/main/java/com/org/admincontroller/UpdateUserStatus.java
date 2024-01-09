package com.org.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/update_user_status")
public class UpdateUserStatus extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt( req.getParameter("userId"));
		
		UserDao dao = new UserDao();
		User user = dao.fetchUserById(userId);
		
		if(user.getStatus().equals("active")) {
			user.setStatus("inactive");
		}else
			user.setStatus("active");
		
		dao.saveAndUpdate(user);;
		
		resp.sendRedirect("admin/allusers.jsp");
	}
}
