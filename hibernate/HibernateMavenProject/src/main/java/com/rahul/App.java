package com.rahul;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws HibernateException, IOException
    {
        System.out.println( "Hello World!" );
		/*
		 * Configuration cfg=new Configuration(); cfg.configure();
		 */
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
       // System.out.println(factory);
        //System.out.println(factory.isClosed());
        Student st=new Student();
        st.setId(105);
        st.setName("Rahul");
        st.setCity("Panipat");

        System.out.println(st);
		/*
		 * Student st1=new Student(); st1.setId(102); st1.setName("Rahul Papneja");
		 * st1.setCity("Panipat_Panipat");
		 */

        Address address=new Address();
        address.setStreet("Ram Nagar");
        address.setCity("Panipat");
        address.setOpen(true);
        address.setX(22.7);
        address.setAddedDate(new Date());
        FileInputStream fis=new FileInputStream("src/main/java/index.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        address.setImage(data);
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();        
        session.save(st);
        session.save(address);
       // session.save(st1);
        tx.commit();
        //Transaction tx1=session.beginTransaction();        
        
        //tx1.commit();        // session.getTransaction().commit();
        session.close();
        
        
        
    }
}
