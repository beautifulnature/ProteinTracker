package com.simpleprogrammer;

import java.util.Date;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {

		System.out.println("Hello World");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User();
		user.setName("Joe");
		//user.getHistory().add(new UserHistory(new Date(), "set name to Joe"));
		user.addHistory(new UserHistory(new Date(), "set name to Joe"));
		//user.getHistory().put("GL123", new UserHistory(new Date(), "set name to Joe"));
		user.getProteinData().setGoal(250);
		//user.getHistory().add(new UserHistory(new Date(), "set the goal to 250"));
		//user.getHistory().put("GL124",new UserHistory(new Date(), "set the goal to 250"));
		user.addHistory(new UserHistory(new Date(), "set the goal to 250"));
		//user.setGoalAlert(new GoalAlert("Congractualtions!"));
		user.getGoalAlerts().add(new GoalAlert("Congractualtions!"));
		user.getGoalAlerts().add(new GoalAlert("You did it!"));
		session.save(user);

		session.getTransaction().commit();

		session.beginTransaction();

		User loadedUser = (User) session.get(User.class, user.getId());
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		for (UserHistory history : loadedUser.getHistory()){
		    System.out.println(history.getEntryTime() + " " + history.getEntry());
		}
		/*for (Entry<String, UserHistory> history : loadedUser.getHistory().entrySet()){
		    System.out.println("Key value: " + history.getKey());
            System.out.println(history.getValue().getEntryTime() + " " + history.getValue().getEntry());
        }*/
		
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
		//user.getHistory().add(new UserHistory(new Date(), "added 50 protein"));
		//user.getHistory().put("GL125", new UserHistory(new Date(), "added 50 protein"));
		user.addHistory(new UserHistory(new Date(), "added 50 protein"));
		user.setProteinData(new ProteinData());
		
		session.getTransaction().commit();

		/*		
        session.beginTransaction();

		User loadedUser1 = (User) session.get(User.class, 2);
		System.out.println(loadedUser1.getName());
		System.out.println(loadedUser1.getGoal());

		session.getTransaction().commit();

		session.close();

		session.beginTransaction();
		 */
		/*
		User loadedUser3 = (User) session.load(User.class, 2);
		System.out.println(loadedUser3.getName());
		System.out.println(loadedUser3.getGoal());

		session.getTransaction().commit();
		*/
		HibernateUtilities.getSessionFactory().close();
	}
}
