package com.rahul.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		// Creating Question
		
		Question q1=new Question();
		q1.setQuestionId(1);
		q1.setQuestion("What is Database");
		
		Answer a1= new Answer();
		a1.setAnswerID(11);
		a1.setAnswer("DBMS");
		a1.setQuestion(q1);
		
		q1.setAnswer(a1);
		// Second Question
		Question q2=new Question();
		q2.setQuestionId(2);
		q2.setQuestion("What is Javascript");
		
		Answer a2= new Answer();
		a2.setAnswerID(12);
		a2.setAnswer("Scripting Language");
		a2.setQuestion(q2);
		q2.setAnswer(a2);

		
		
		Session sa= factory.openSession();
		Transaction tx=sa.beginTransaction();
		sa.save(q1);
		sa.save(q2);
		sa.save(a1);
		sa.save(a2);
		tx.commit();
		factory.close();
		
		
	}

}
