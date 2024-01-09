package com.org.usercontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.AdminDao;
import com.org.dao.UserDao;
import com.org.dto.Admin;
import com.org.dto.User;

@WebServlet("/user_register")
public class RegisterUser extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		
		user.setName(name);
		user.setEmail(email);
		user.setMobile(Long.parseLong(mobile));
		user.setPassword(password);
		
		Admin admin = new AdminDao().fetchAdminById(1);
		user.setAdmin(admin);
		
		List<User> users = admin.getUsers();
		admin.setUsers(users);
		
		UserDao dao = new UserDao();
		dao.saveAndUpdate(user);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("success", "Registration Successful");
		
		resp.sendRedirect("user/user_login.jsp");
	
	}
}
