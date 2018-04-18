package com.simpleprogrammer;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ProgramHQL{

    public static void main(String[] args){
        System.out.println("Hello world! from HQL");
        
        PopulateSampleData();
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.enableFilter("nameFilter").setParameter("name", "%j");
        session.beginTransaction();
        
        //Query query = session.createQuery("from User");
        /*Query query = session.createQuery("select user from User user where user.name = :name")
                .setString("name", "Joe");*/
        /*Query query = session.createQuery("from GoalAlert")
                .setFirstResult(2)
                .setMaxResults(1);*/
        //Query query = session.getNamedQuery("AllGoalAlerts");
        //Query query = session.createQuery("select new com.simpleprogrammer.UserTotal(user.name, user.proteinData.total) from User user");
        /*Criteria criteria = session.createCriteria(User.class)
        		.add(Restrictions.or(
        				Restrictions.eq("name", "Joe"),
        				Restrictions.eq("name", "Bob")
        				)).setProjection(Projections.projectionList()
        						.add(Projections.property("id"))
        						.add(Projections.property("name")));*/
        
        //List<User> users = query.list();
        //List<GoalAlert> alerts = query.list();
                
        /*for (User user : users){
            System.out.println(user.getName());
        }*/
        /*for (GoalAlert alert : alerts){
            System.out.println(alert.getMessage());
        }*/
        		
        //List<UserTotal> userTotals = query.list();
        //List<User> users = criteria.list();
        /*for (UserTotal userTotal : userTotals) {
			System.out.println(userTotal.getName() + ": " + userTotal.getTotal());
		}*/
        
        
        
        /*for (User user : users) {
			System.out.println(user.getName());
		}*/
        /*List<Object[]> results = criteria.list();
        for (Object[] result : results) {
			for (Object o : result) {
				System.out.println(o.toString());
			}
		}
        
        Query query = session.createQuery("update ProteinData  pd set pd.total = 0");
        query.executeUpdate();*/
        /*Criteria criteria = session.createCriteria(User.class);
        ScrollableResults users = criteria.setCacheMode(CacheMode.IGNORE).scroll();
        int count = 0;
        while(users.next()) {
        	User user = (User) users.get(0);
        	user.setProteinData(new ProteinData());
        	session.save(user);
        	if(++count % 2 == 0) {
        		session.flush();
        		session.clear();
        	}
        	System.out.println(user.getName());
        }*/
        
        /*Query query = session.createSQLQuery("SELECT * FROM Users").addEntity(User.class);
        List<User> users = query.list();
        for (User user : users) {
			System.out.println(user.getName());
		}
        User u = (User) session.load(User.class, 1);
        System.out.println(u.getName());*/
        
        Query query = session.createQuery("from User");
        List<User> users = query.list();
        for (User user : users) {
			System.out.println(user.getName());
		}
        
        User u = (User) session.load(User.class, 1);
        System.out.println(u.getName());
        
        session.getTransaction().commit();
        session.close();
        
        HibernateUtilities.getSessionFactory().close();
    }
    
    private static void PopulateSampleData() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
        
        User joe = CreateUser("Joe", 500, 50, "Good Job", "You made it!");
        session.save(joe);
        
        User bob = CreateUser("Bob", 300, 20, "Taco time!");
        session.save(bob);
        
        User amy = CreateUser("Amy", 250, 200, "Yes");
        session.save(amy);
        
        session.getTransaction().commit();
        session.close();
    }

    private static User CreateUser(String name, int goal, int total, String ... alerts){
        User user = new User();
        user.setName(name);
        user.getProteinData().setGoal(goal);
        user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));
        user.getProteinData().setTotal(total);
        user.addHistory(new UserHistory(new Date(), "Set total to " + total));
        for (String alert : alerts){
            user.getGoalAlerts().add(new GoalAlert(alert));
        }
        return user;
    }
}
