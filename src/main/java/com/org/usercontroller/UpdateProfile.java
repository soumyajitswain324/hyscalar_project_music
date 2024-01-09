package com.org.usercontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/user_update")
public class UpdateProfile extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserDao dao = new UserDao();
		User user = dao.fetchUserById(id);
		user.setId(id);		
		user.setName(name);
		user.setEmail(email);
		user.setMobile(Long.parseLong(mobile));
		user.setPassword(password);
		
		dao.saveAndUpdate(user);
		
		HttpSession session = req.getSession();
		session.setAttribute("success", name+ "'s Profile Updated");
		
		resp.sendRedirect("user/update_profile.jsp");
		
	}
}
