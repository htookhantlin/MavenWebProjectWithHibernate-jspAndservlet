package com.example.dao;

import java.util.List;

import org.hibernate.Session;

import com.example.model.Address;
import com.example.model.Student;
import com.example.util.HibernateUtil;

public class StudentDao {
	public void show(List<Student> l) {
		if (!l.isEmpty()) {
			StudentDao stdDao = new StudentDao();
			// List<Student> studentList = stdDao.select();
			System.out.println("NO\t" + "Student Name\t" + "City\t" + "Street");

			for (Student std : l) {
				System.out.println(std.getId() + "\t" + std.getFirstName() + std.getLastName() + "\t\t"
						+ std.getAddress().getCity() + "\t" + std.getAddress().getStreet());
			}
		} else {
			System.out.print("There is no student in this city");
		}
	}

	public void addStudent(Student student, Address address) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.persist(student);

		address.setId(student.getId());
		student.setAddress(address);
		session.save(student);

		session.getTransaction().commit();
		session.close();
	}

	public List<Student> selectAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select student from Student student INNER JOIN student.address addr  ";
		List<Student> list = (List<Student>) session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<Student> searchStudentByCity(String city) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select student from Student student INNER JOIN student.address addr with addr.city='" + city
				+ "'";
		List<Student> list = (List<Student>) session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<Student> searchStudentByName(String firstName, String lastName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select student from Student student where student.firstName='" + firstName
				+ "' AND student.lastName='" + lastName + "'";
		List<Student> list = (List<Student>) session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<Student> searchStudentBySection(String section) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select student from Student student INNER JOIN student.address addr with student.section='"
				+ section + "'";
		List<Student> list = (List<Student>) session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<String> selectAllSection() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select distinct student.section from Student student";
		List<String> list = (List<String>) session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<String> selectAllCity() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "select distinct addr.city from Student student INNER JOIN student.address addr ";
		List<String> list = (List<String>) session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
}
