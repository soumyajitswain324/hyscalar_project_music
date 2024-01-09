package com.org.usercontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/user_login")
public class LoginUser extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao dao = new UserDao();
		List<User> users = dao.fetchUserByEmailPassword(email, password);

		HttpSession session = req.getSession();

		if (!users.isEmpty()) {
			User user = users.get(0);
			System.out.println(user.getName());
			System.out.println(user.getEmail());

			session.setAttribute("userId", user.getId());
			resp.sendRedirect("user/user_home.jsp");

		} else {
			session.setAttribute("fail", "Invalid email or password");
			resp.sendRedirect("user/user_login.jsp");
		}
	}
}
