package com.rahul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		//Student st=(Student)session.get(Student.class, 103);
		Student st=(Student)session.load(Student.class, 103);
		System.out.println(st);
		Address ad=(Address)session.get(Address.class, 3);
		System.out.println(ad);
		factory.close();
	}

}
