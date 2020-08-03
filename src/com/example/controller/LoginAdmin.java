package com.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.AdminDao;
import com.example.model.Admin;

@WebServlet(urlPatterns = { "/loginAdmin" })
public class LoginAdmin extends HttpServlet {
	AdminDao adminDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName, gmail, password;
		userName = req.getParameter("userName");
		gmail = req.getParameter("gmail");
		password = req.getParameter("password");
		Admin admin = new Admin(userName, gmail, password);
		System.out.println(admin.getUserName() + "  " + admin.getGmail() + "  " + admin.getPassword());
		if (this.adminDao.isAlreadyExit(admin) & this.adminDao.login(admin)) {
			System.out.println("login successful");
			Admin a=new Admin();
			a=this.adminDao.selectAdminByGmail(admin);
			System.out.println(a.getId());
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			RequestDispatcher dis = req.getRequestDispatcher("home.jsp");
			dis.forward(req, resp);
		} else {
			System.out.println("login failed");
		}

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		adminDao = new AdminDao();
	}

}
