package de.dhbw.sportcontroll.dataobjects;



public class SportDiscipline {

	private int id;
	private String name;
	private double energyfactor;	
	
	

	public SportDiscipline(int id, String name, double eneryFactor) {
		this.id = id;
		this.name = name;
		this.energyfactor = eneryFactor;
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
	 * @return the energyfactor
	 */
	public double getEnergyfactor() {
		return energyfactor;
	}
	/**
	 * @param energyfactor the energyfactor to set
	 */
	public void setEnergyfactor(double energyfactor) {
		this.energyfactor = energyfactor;
	}
	
	
	
	
}