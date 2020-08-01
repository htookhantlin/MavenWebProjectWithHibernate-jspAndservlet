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

@WebServlet(urlPatterns = { "/searchStudentBySection" })

public class SearchStudentBySection extends HttpServlet {
	private StudentDao studentdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> sectionList = this.studentdao.selectAllSection();
		req.setAttribute("sectionList", sectionList);
		RequestDispatcher dis = req.getRequestDispatcher("searchBySection.jsp");
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String section = req.getParameter("section");
		List<Student> studentList = this.studentdao.searchStudentBySection(section);
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
