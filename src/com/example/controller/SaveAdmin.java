package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.AdminDao;
import com.example.model.Admin;

@WebServlet(urlPatterns = { "/saveAdmin" })

public class SaveAdmin extends HttpServlet {
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
		PrintWriter out = resp.getWriter();
		if (this.adminDao.isAlreadyExit(admin)) {
			System.out.println("Sign up failed");
			System.out.println("This gmail account is already exit.");

		} else {
			this.adminDao.saveAdmin(admin);
			System.out.println("sign up successful");
			RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
			dis.forward(req, resp);
		}

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		adminDao = new AdminDao();
	}

}
