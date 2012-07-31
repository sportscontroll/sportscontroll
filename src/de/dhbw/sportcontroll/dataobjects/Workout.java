package de.dhbw.sportcontroll.dataobjects;




public class Workout {
	
	private int id;	
	private int uid;
	private int did;
	private SportDiscipline disciplin;
	private Date date;
	private int duration;
	private String location;
	private int energy;
	
	public Workout(int id, int uid, int did, SportDiscipline disciplin, Date date, int duration, String location, int consumedCalories){
		this.id = id;
		this.uid = uid;
		this.did = did;
		this.date = date;
		this.duration = duration;
		this.location = location;
		this.disciplin = disciplin;
		this.energy = consumedCalories;		
	}
	
	public Workout(int id, int uid, int did, Date d, int duration, String location){		
		this.id = id;
		this.uid = uid;
		this.did = did;
		this.date = d;
		this.duration = duration;
		this.location = location;
		this.disciplin = null;
		this.energy = calculateConsumedCalories();
		
	}
	
	public Workout( int uid, int did, Date date, int duration, String location){
		this(0, uid, did, date, duration, location);
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
	 * @return the did
	 */
	public int getDid() {
		return did;
	}

	/**
	 * @param did the did to set
	 */
	public void setDid(int did) {
		this.did = did;
	}

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
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

	/**
	 * @return the consumedCalories
	 */
	public int getConsumedCalories() {
		return energy;
	}

	/**
	 * @param consumedCalories the consumedCalories to set
	 */
	public void setConsumedCalories(int consumedCalories) {
		this.energy = consumedCalories;
	}
	
	public int calculateConsumedCalories() {
		// check for did or disciplin!
		//TODO
		return 1;
	}
	
	public void printWorkout() {
		System.out.println("id = " + id);
		System.out.println("uid = " + uid);
		System.out.println("did = " + did);
		System.out.println("date = " + date.toString());
		System.out.println("duration = " + duration);
		System.out.println("location = " + location);
		System.out.println("energy = " + energy);
	}
	

}
