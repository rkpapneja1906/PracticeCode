package com.rahul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		
		Student st=new Student();
		st.setId(1000);
		st.setName("Samta");
		st.setCity("Panipat");
		
		Certificate ct= new Certificate();
		ct.setCourseName("Java");
		ct.setDuration("3 Months");
		
		st.setCerti(ct);
		
		Student st1=new Student();
		st1.setId(1001);
		st1.setName("Samta Papneja");
		st1.setCity("Hissar");
		
		Certificate ct1= new Certificate();
		ct1.setCourseName("Android");
		ct1.setDuration("1 Month");
		
		st1.setCerti(ct1);
		Session session= factory.openSession();
		Transaction tx= session.beginTransaction();
		
		session.save(st1);
		session.save(st);
		tx.commit();
		session.close();
		factory.close();

	}

}
