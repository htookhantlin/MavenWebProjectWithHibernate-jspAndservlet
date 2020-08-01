package com.example.app;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.example.model.Student;
import com.example.dao.StudentDao;
import com.example.model.Address;
import com.example.util.HibernateUtil;

public class Myapp {
	public static void main(String[] args) {
		StudentDao stdDao = new StudentDao();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter section you want to search::::");
		String section = s.nextLine();
		List<Student> list = stdDao.searchStudentBySection(section);
		stdDao.show(list);

	}
}
