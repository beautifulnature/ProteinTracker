package com.simpleprogrammer;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {

		System.out.println("Hello World");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User();
		user.setName("Joe");
		user.setGoal(250);
		session.save(user);

		session.getTransaction().commit();

		session.beginTransaction();

		User loadedUser = (User) session.get(User.class, user.getId());
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getGoal());
		
		loadedUser.setTotal(loadedUser.getTotal() + 50);

		session.getTransaction().commit();

/*		session.beginTransaction();

		User loadedUser1 = (User) session.get(User.class, 2);
		System.out.println(loadedUser1.getName());
		System.out.println(loadedUser1.getGoal());

		session.getTransaction().commit();

		session.close();

		session.beginTransaction();
*/
		/*User loadedUser3 = (User) session.load(User.class, 2);
		System.out.println(loadedUser3.getName());
		System.out.println(loadedUser3.getGoal());

		session.getTransaction().commit();*/

		HibernateUtilities.getSessionFactory().close();
	}

}
