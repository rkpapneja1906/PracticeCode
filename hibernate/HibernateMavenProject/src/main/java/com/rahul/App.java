package com.rahul;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws HibernateException
    {
        System.out.println( "Hello World!" );
		/*
		 * Configuration cfg=new Configuration(); cfg.configure();
		 */
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
}
