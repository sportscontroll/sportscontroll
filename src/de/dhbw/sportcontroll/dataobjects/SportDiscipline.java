package de.dhbw.sportcontroll.dataobjects;

import java.util.ArrayList;


public class SportDiscipline {

	private int id;
	private String name;
	private double caloryConsumption;
	private ArrayList<SportEquitment> equitment;
	
	
	
	

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
	 * @return the caloryConsumption
	 */
	public double getCaloryConsumption() {
		return caloryConsumption;
	}
	/**
	 * @param caloryConsumption the caloryConsumption to set
	 */
	public void setCaloryConsumption(double caloryConsumption) {
		this.caloryConsumption = caloryConsumption;
	}
	/**
	 * @return the equitment
	 */
	public ArrayList<SportEquitment> getEquitment() {
		return equitment;
	}
	/**
	 * @param equitment the equitment to set
	 */
	public void setEquitment(ArrayList<SportEquitment> equitment) {
		this.equitment = equitment;
	}
	
	
	
	
	
}