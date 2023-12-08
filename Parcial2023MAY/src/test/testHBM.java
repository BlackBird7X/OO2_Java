package test;

import org.hibernate.Session;

import dao.HibernateUtil;

public class testHBM {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
	}
}
