package de.dhbw.sportcontroll.dataobjects;

import java.util.ArrayList;
import java.util.Date;


public class UserProfile {
	
	private int id;
	private String name;
	private Date birthday;
	private String gender;
	private int height;
	private ArrayList<UserWeight> weightHistorie;
	private ArrayList<Workout>	workouts;
	
	public UserProfile(int id, String name, int birthday, String gender, ArrayList<UserWeight> userWeightHistorie, ArrayList<Workout> workouts){
		this.id = id;
		this.name = name;
		this.birthday = new Date(birthday);
		this.setGender(gender);
		this.weightHistorie = userWeightHistorie;
		this.workouts = workouts;	
	}
	public UserProfile(int id, String name, int birthday, String gender){
		this.id = id;
		this.name = name;
		this.birthday = new Date(birthday);
		this.setGender(gender);
		this.weightHistorie = null;
		this.workouts = null;	
	}
	
	public UserProfile(int id, String name){
		this.id = id;
		this.name = name;
		this.birthday = null;
		this.gender = null;
		this.weightHistorie = null;
		this.workouts = null;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}	
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the userWeightHistorie
	 */
	public ArrayList<UserWeight> getUserWeightHistorie() {
		return weightHistorie;
	}
	/**
	 * @param userWeightHistorie the userWeightHistorie to set
	 */
	public void setUserWeightHistorie(ArrayList<UserWeight> userWeightHistorie) {
		this.weightHistorie = userWeightHistorie;
	}
	/**
	 * @return the workouts
	 */
	public ArrayList<Workout> getWorkouts() {
		return workouts;
	}
	/**
	 * @param workouts the workouts to set
	 */
	public void setWorkouts(ArrayList<Workout> workouts) {
		this.workouts = workouts;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	public void printProfile(){
		System.out.println("name\t" + name);
		System.out.print("\t birthday " + birthday.toLocaleString());
		System.out.print("\t gender " + gender);
		System.out.println("\t Weights " + weightHistorie.size());
		System.out.println("\t workouts " + workouts.size());
	}
	
	

}
