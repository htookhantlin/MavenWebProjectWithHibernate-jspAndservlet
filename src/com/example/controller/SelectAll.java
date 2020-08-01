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

@WebServlet(urlPatterns = { "/selectAll" })
public class SelectAll extends HttpServlet {
	private StudentDao studentDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> studentList=studentDao.selectAll();
		req.setAttribute("studentList", studentList);
		RequestDispatcher dis=req.getRequestDispatcher("showAllStudents.jsp");
		dis.forward(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		studentDao=new StudentDao();
	}

}
