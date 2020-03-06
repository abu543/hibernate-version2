package com.abusaquib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.abusaquib.entity.User;

public class ReadUser {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(User.class)
				 .buildSessionFactory();
			
		Session session =factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			User user = session.get(User.class,1);
			
			System.out.println(user);
			
			session.getTransaction().commit();
		}
	finally {
		factory.close();
	}

}
}
