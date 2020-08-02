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
import com.example.model.Student;

@WebServlet(urlPatterns = { "/deleteStudent" })

public class DeleteStudent extends HttpServlet {
	private StudentDao studentDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("Id"));
		this.studentDao.deleteStudent(id);
		List<Student> studentList=this.studentDao.selectAll();
		req.setAttribute("studentList", studentList);
		RequestDispatcher dis=req.getRequestDispatcher("showAllStudents.jsp");
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		studentDao = new StudentDao();
	}

}
