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

@WebServlet(urlPatterns = { "/searchStudentByCity" })

public class SearchStudentByCity extends HttpServlet {
	private StudentDao studentdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> cityList = this.studentdao.selectAllCity();
		req.setAttribute("cityList", cityList);
		RequestDispatcher dis = req.getRequestDispatcher("searchByCity.jsp");
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String city = req.getParameter("city");
		List<Student> studentList = this.studentdao.searchStudentByCity(city);
		req.setAttribute("studentList", studentList);
		RequestDispatcher dis = req.getRequestDispatcher("showAllStudents.jsp");
		dis.forward(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		studentdao = new StudentDao();
	}

}
