package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDao;
import com.example.model.*;

@WebServlet(urlPatterns = { "/addStudent" })

public class AddStudent extends HttpServlet {
	private StudentDao studentDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName, lastName, section, street, city, country;
		firstName = req.getParameter("firstName");
		lastName = req.getParameter("lastName");
		section = req.getParameter("section");
		street = req.getParameter("street");
		city = req.getParameter("city");
		country = req.getParameter("country");
		Student student = new Student(firstName, lastName, section);
		Address address = new Address(street, city, country);
		this.studentDao.addStudent(student, address);
		RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
		dis.forward(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		studentDao = new StudentDao();
	}

}
