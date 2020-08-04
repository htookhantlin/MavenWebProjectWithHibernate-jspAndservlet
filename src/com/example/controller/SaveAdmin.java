package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.AdminDao;
import com.example.dao.EmailDao;
import com.example.model.Admin;

@WebServlet(urlPatterns = { "/saveAdmin" })

public class SaveAdmin extends HttpServlet {
	AdminDao adminDao;
	EmailDao emailDao;
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
			RequestDispatcher dis = req.getRequestDispatcher("signUpFailed.jsp");
			dis.forward(req, resp);
		} else {
			this.adminDao.saveAdmin(admin);
			System.out.println("sign up successful");
			try {
				this.emailDao.sendAsHtml(admin.getGmail(), "Account Cretion",
						"<h1>Your account is successfully created</h1>Have a nice day");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
			dis.forward(req, resp);
		}

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		adminDao = new AdminDao();
		emailDao=new EmailDao();
		
	}

}
