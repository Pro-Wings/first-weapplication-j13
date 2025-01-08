package com.prowings.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null) {
			System.out.println("Creating session factory object!!");
			sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		}
		else {
			System.out.println("SessionFactory is already initialized.. so returning same sessionfactory object!!");
			return sessionFactory;
		}
	}
	
	public static void shutDownSessionFactory()
	{
		try {
			System.out.println("Shtting down Session Factory!!!");
			sessionFactory.close();
			System.out.println("Session Factory Closed!!!");

		} catch (Exception e) {
			System.out.println("Some exception occurred during closing Session Factory!!!"+e.getMessage());
		}
	}
}
