package com.simpleprogrammer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
	
	private int id;
	private String name;
	//private ProteinData proteinData = new ProteinData();
	private ProteinData proteinData;
	//private Set<UserHistory> history = new HashSet<UserHistory>();
	private List<UserHistory> history = new ArrayList<UserHistory>();
	//private Map<String, UserHistory> history = new HashMap<String, UserHistory>();
	//private Collection<UserHistory> history = new ArrayList<UserHistory>();
	//private GoalAlert goalAlert;
	private Set<GoalAlert> goalAlerts = new HashSet<GoalAlert>();
	public User() {
	    setProteinData(new ProteinData());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public ProteinData getProteinData() {
        return proteinData;
    }
    public void setProteinData(ProteinData proteinData) {
        this.proteinData = proteinData;
        proteinData.setUser(this);
    }
    /*public Set<UserHistory> getHistory()
    {
        return history;
    }
    public void setHistory(Set<UserHistory> history)
    {
        this.history = history;
    }*/
    public List<UserHistory> getHistory()
    {
        return history;
    }
    public void setHistory(List<UserHistory> history)
    {
        this.history = history;
    }
    /*public Map<String, UserHistory> getHistory(){
        return history;
    }
    public void setHistory(Map<String, UserHistory> history){
        this.history = history;
    }*/
    /*public Collection<UserHistory> getHistory(){
        return history;
    }
    public void setHistory(Collection<UserHistory> history){
        this.history = history;
    }*/
    
    public void addHistory(UserHistory historyItem) {
        historyItem.setUser(this);
        history.add(historyItem);
    }

    /*public GoalAlert getGoalAlert(){
        return goalAlert;
    }

    public void setGoalAlert(GoalAlert goalAlert){
        this.goalAlert = goalAlert;
    }*/

    public Set<GoalAlert> getGoalAlerts(){
        return goalAlerts;
    }

    public void setGoalAlerts(Set<GoalAlert> goalAlerts){
        this.goalAlerts = goalAlerts;
    }
    
}
