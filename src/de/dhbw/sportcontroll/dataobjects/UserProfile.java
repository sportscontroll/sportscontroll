package de.dhbw.sportcontroll.dataobjects;

import java.util.ArrayList;
import java.util.Collections;



public class UserProfile {
	
	private int id;
	private String name;
	private Date birthday;
	private String gender;
	private int height;
	private ArrayList<UserWeight> weightHistorie;
	private ArrayList<Workout>	workouts;
	
	public UserProfile(int id, String name, Date birthday, String gender, int height, ArrayList<UserWeight> userWeightHistorie, ArrayList<Workout> workouts){
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.height = height;
		this.weightHistorie = userWeightHistorie;
		this.workouts = workouts;	
	}
	public UserProfile(int id, String name, Date birthday, String gender, int height){
		this(id, name, birthday, gender,  height, null,null );
	}
	
	public UserProfile(int id, String name){
		this(id, name, null,null,0,null, null);
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
	 * adding new UserWeight object to ArrayList
	 * @param uw
	 */
	public void addUserWeight(UserWeight uw){
		this.weightHistorie.add(uw);
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
	 * not jet implemented
	 * FIXME
	 * @param w
	 */
	public void addWorkout(Workout w){
		w.setUid(this.id);
		w.setConsumedCalories(w.calculateConsumedCalories());
		
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
		System.out.print("\t birthday " + birthday.toString());
		System.out.print("\t gender " + gender);
		System.out.println("\t Weights " + weightHistorie.size());
		System.out.println("\t workouts " + workouts.size());
	}
	
	public double getCurrentWeight(){
		double currentWeight = 0;
		if(weightHistorie != null && !weightHistorie.isEmpty() ){
			
			Collections.sort(weightHistorie);
			currentWeight = weightHistorie.get(weightHistorie.size()-1).getWeight();
		}		
		
		return currentWeight;
	}
	
	
	/**
	 * Calculates the BMI from the currentWeight
	 * @return BMI as double
	 */	
	public double getBMI(){
		//BMI = weight / heightInMeter^2
		
		double heightInMeter = ((double)height) / 100;
		
		return getCurrentWeight() / Math.pow(heightInMeter, 2);
	}
	

}
