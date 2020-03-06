package com.abusaquib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.abusaquib.entity.User;

public class CreateUser {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(User.class)
				 .buildSessionFactory();
			
		Session session =factory.getCurrentSession();
		try {
			User user = new User("Ravita","singh");
			
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}
	finally {
		factory.close();
	}

}
}
