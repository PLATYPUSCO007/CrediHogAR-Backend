package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionfactory;

	static {
		sessionfactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionfactory;
	}

}
