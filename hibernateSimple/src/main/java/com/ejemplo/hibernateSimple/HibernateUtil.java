package com.ejemplo.hibernateSimple;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = construirSessionFactory();

	private static SessionFactory construirSessionFactory() {
		SessionFactory sf = null;
		try {
			return new Configuration().configure().buildSessionFactory();
		}catch(Exception e) {}
		return sf;
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
