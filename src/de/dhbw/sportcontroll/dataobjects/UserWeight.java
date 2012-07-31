package de.dhbw.sportcontroll.dataobjects;

import java.util.Date;



public class UserWeight implements Comparable<UserWeight>{
	
	private int id;
	private int UserId;
	private Date date;
	private double weight;
	
	
	public UserWeight(int date, double weight){
		this.weight = weight;
		this.date = new Date(date);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return UserId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		UserId = userId;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(UserWeight o) {
		return date.compareTo(o.date);
	}
	
	
	

}
