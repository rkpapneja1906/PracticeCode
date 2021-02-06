package com.rahul.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// Creating Question

		
		  Question q1 = new Question(); q1.setQuestionId(1);
		  q1.setQuestion("What is Database");
		  
		  Answer a1 = new Answer(); a1.setAnswerID(11); a1.setAnswer("DBMS");
		  a1.setQuestion(q1);
		  
		  // q1.setAnswer(a1); // Second Question
		  
		  Answer a2 = new Answer(); a2.setAnswerID(12);
		  a2.setAnswer("Scripting Language"); a2.setQuestion(q1);
		  
		  List<Answer> list = new ArrayList<Answer>(); list.add(a1); list.add(a2);
		  q1.setAnswer(list);
		  
		 		Session sa = factory.openSession();
		Transaction tx = sa.beginTransaction();
		sa.save(q1);
		sa.save(a1); sa.save(a2);

		
		  
		  
		 

		tx.commit();
		Question q= sa.get(Question.class,1); 
		  System.out.println("Question: "+ q.getQuestion());
		 for(Answer a : q.getAnswer())
		 {
			 System.out.println("Answer: "+ a.getAnswer());
		 }

		factory.close();

	}

}
