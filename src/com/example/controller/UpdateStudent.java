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
import com.example.model.Address;
import com.example.model.Student;

@WebServlet(urlPatterns = { "/updateStudent" })

public class UpdateStudent extends HttpServlet {
	private StudentDao studentDao;
	long ID;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("Id"));
		List<Student> studentList = this.studentDao.getStudentById(id);
		ID = studentList.get(0).getId();
		req.setAttribute("studentList", studentList);
		RequestDispatcher dis = req.getRequestDispatcher("UpdateForm.jsp");
		dis.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName, lastName, section, street, city, country;
		firstName = req.getParameter("firstName");
		lastName = req.getParameter("lastName");
		System.out.println(lastName);
		section = req.getParameter("section");
		street = req.getParameter("street");
		city = req.getParameter("city");
		country = req.getParameter("country");
		
		
		
		this.studentDao.updateStudent(ID, firstName,lastName,section,street,city,country);
		List<Student> studentList = this.studentDao.selectAll();
		req.setAttribute("studentList", studentList);
		RequestDispatcher dis = req.getRequestDispatcher("showAllStudents.jsp");
		dis.forward(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		studentDao = new StudentDao();
	}

}
