package de.dhbw.sportcontroll.dataobjects;




public class Workout {
	
	public static final int SEHR_GUT 		= 1;
    public static final int GUT 			= 2;
    public static final int BEFRIEDIGEND 	= 3;
    public static final int AUSREICHEND 	= 4;
   
	
	
	
	private int id;	
	private int uid;
	private int did;
	private SportDiscipline disciplin;
	private Date date;
	private int duration;
	private String location;
	private int energy;
	private int heartRate;
	private String comment;
	//private enum rating{"sehr gut", };
	
	public Workout() {
		
	}
	
	public Workout(int id, int uid, int did, SportDiscipline disciplin, Date date, int duration, int heartRate, String location, int consumedCalories, String comment){
		this.id = id;
		this.uid = uid;
		this.did = did;
		this.date = date;
		this.duration = duration;
		this.heartRate = heartRate;
		this.location = location;
		this.disciplin = disciplin;
		this.energy = consumedCalories;
		this.comment = comment;
	}
	
	public Workout(int id, int uid, int did, Date d, int duration, int heartRate, String location, String comment){		
		this.id = id;
		this.uid = uid;
		this.did = did;
		this.date = d;
		this.duration = duration;
		this.heartRate = heartRate;
		this.location = location;
		this.disciplin = null;
		this.energy = calculateConsumedCalories();
		this.comment = comment;
		
	}
	
	public Workout( int uid, int did, Date date, int duration, int heartrate, String location, String comment){
		this(0, uid, did, date, duration, heartrate, location, comment);
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
	
	
	
	/**
	 * @return the heartRate
	 */
	public int getHeartRate() {
		return heartRate;
	}

	/**
	 * @param heartRate the heartRate to set
	 */
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public int calculateConsumedCalories() {
		// check for did or disciplin!
		//TODO
		return 1;
	}
	
	/*
	 * print workoutObject just for testing pourpous
	 */
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
