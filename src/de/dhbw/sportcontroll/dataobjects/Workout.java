package de.dhbw.sportcontroll.dataobjects;

import java.util.Date;



public class Workout {
	
	private int id;
	private SportDiscipline disciplin;
	private Date date;
	private int duration;
	private String location;
	
	public Workout(int date, int duration, String location, SportDiscipline disciplin){
		this.date = new Date(date);
		this.duration = duration;
		this.location = location;
		this.disciplin = disciplin;
		//TODO calory consumption
		
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
	 * @return the disciplin
	 */
	public SportDiscipline getDisciplin() {
		return disciplin;
	}
	/**
	 * @param disciplin the disciplin to set
	 */
	public void setDisciplin(SportDiscipline disciplin) {
		this.disciplin = disciplin;
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
	 * @return the duration
	 */
	public long getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
