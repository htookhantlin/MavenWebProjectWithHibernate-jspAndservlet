package com.example.dao;

import java.util.List;

import org.hibernate.Session;

import com.example.model.Admin;
import com.example.util.HibernateUtil;

public class AdminDao {
	public List<Admin> selectAllAdmin() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query="from Admin";
		List<Admin> adminList=(List<Admin>)session.createQuery(query).list();
		session.getTransaction().commit();
		session.close();
		return adminList;
	}
	public void saveAdmin(Admin admin) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}
	public boolean isAlreadyExit(Admin admin) {
		List<Admin> adminList=this.selectAllAdmin();
		boolean flag=false;
		for(Admin a: adminList) {
			if(a.getGmail().equals(admin.getGmail())) {
				flag=true;
			}
		}
		return flag;
	}
	public Admin selectAdminByGmail(Admin admin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query="select admin from Admin admin where admin.gmail='"+admin.getGmail()+"'";
		List<Admin> adminList=(List<Admin>)session.createQuery(query).list();
		Admin a=new Admin();
		a=adminList.get(0);
		session.getTransaction().commit();
		session.close();
		return a;
	}
	
	public boolean login(Admin admin) {
		Admin a=new Admin();
		
		 a=this.selectAdminByGmail(admin);
		 System.out.println(a.getGmail()+"  "+a.getUserName()+"  "+a.getPassword());
		 System.out.println(admin.getGmail()+"  "+admin.getUserName()+"  "+admin.getPassword());
		 if(a.getUserName().equals(admin.getUserName()) & a.getPassword().equals(admin.getPassword())) {
			 System.out.println("true");
			 return true;
		 }
		 else {
			 System.out.println("false");
			 return false;
		 }
	}
}
