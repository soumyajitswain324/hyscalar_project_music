package com.org.admincontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.AdminDao;
import com.org.dto.Admin;

@WebServlet("/admin_login")
public class LoginAdmin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		AdminDao dao = new AdminDao();
		List<Admin> admins = dao.fetchAdminByEmailPassword(email, password);

		HttpSession session = req.getSession();

		if (!admins.isEmpty()) {
			Admin admin = admins.get(0);
			System.out.println(admin.getName());
			System.out.println(admin.getEmail());

			session.setAttribute("adminId", admin.getId());
			resp.sendRedirect("admin/admin_home.jsp");

		} else {
			session.setAttribute("fail", "Invalid email or password");
			resp.sendRedirect("admin/admin_login.jsp");
		}
	}
}
