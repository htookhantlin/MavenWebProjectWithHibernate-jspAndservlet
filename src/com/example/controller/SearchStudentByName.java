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

@WebServlet(urlPatterns = { "/searchStudentByName" })

public class SearchStudentByName extends HttpServlet {
	private StudentDao studentdao;

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String[] string = name.split(" ", 2); 
		String firstName=string[0];
		String lastName=string[1];
		List<Student> studentList=this.studentdao.searchStudentByName(firstName, lastName);
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
