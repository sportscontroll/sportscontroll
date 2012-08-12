package de.dhbw.sportcontroll.db;



import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import sun.nio.cs.US_ASCII;

import de.dhbw.sportcontroll.controller.ActionController;
import de.dhbw.sportcontroll.dataobjects.*;
import de.dhbw.sportcontroll.exceptions.SQLCantDeleteException;
import de.dhbw.sportcontroll.exceptions.SQLConnectionException;
import de.dhbw.sportcontroll.exceptions.SQLQueryException;
import de.dhbw.sportcontroll.exceptions.SQLDriverNotFoundException;

/**
 * This DataHandler provides simple functions to access data in the db and
 * returns only Objects from the dataobject package This is a singelton to make
 * sure only one instance is accessing the DB
 * 
 * @author daniel
 * 
 */

public class DataHandler {

	private static final String DB_FILE_NAME = "scProfiles.sqlite";

	private static DataHandler dh;
	private Connection dbCon;
	

	/**
	 * private construktor
	 */
	private DataHandler() {	}

	/**
	 * 
	 * @return returns the Instance of the Datahandler
	 * @throws SQLConnectionException 
	 * @throws SQLDriverNotFoundException 
	 */
	public static DataHandler getInstance() throws SQLDriverNotFoundException, SQLConnectionException {
		if (dh == null) {
			dh = new DataHandler();
			dh.dbConnect(DB_FILE_NAME);
			return dh;
		} else {
			return dh;
		}
	}

	/**
	 * Deletes the DataHandler Instance and closes the DB-Connection
	 * closes the DB-Connection to the SQLite-File
	 * @throws SQLConnectionException
	 */
	public void cleanUp() throws SQLConnectionException  {
		if(dh != null) {
			if(dh.dbCon != null) {
				try {
					dh.dbCon.close();
					
				} catch (SQLException e) {
					throw new SQLConnectionException(e);
				}
				finally {
					dh.dbCon = null;
					dh = null;
				}
			}
		}
	}
	
	
	/**
	 * connects to SQlite-Db-File 
	 * @param dbFileName
	 * @throws SQLDriverNotFoundException
	 * @throws SQLConnectionException
	 */	
	private void dbConnect(String dbFileName) throws SQLDriverNotFoundException, SQLConnectionException{ 		
		try {
			Class.forName("org.sqlite.JDBC");
			dbCon = DriverManager.getConnection("jdbc:sqlite:" + dbFileName);
		}
		catch (ClassNotFoundException e) {
			if(dbCon != null){
				try {
					dbCon.close();
					dbCon = null;
				} 
				catch (SQLException e2) {					
					e2.printStackTrace();
				}
				finally {
					System.exit(-1);
				}
			}
			throw new SQLDriverNotFoundException(e);
		}
		catch (SQLException e) {
			if(dbCon != null){
				try {
					dbCon.close();
					dbCon = null;
				} 
				catch (SQLException e2) {					
					e2.printStackTrace();
				}
			}
			throw new SQLConnectionException(e);
		}
		try {
			createTables();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 *  created SQLTables and adds default user
	 * @throws SQLException 
	 */	
	public void createTables() throws SQLException{
		Statement stat;
		ResultSet rs;
		boolean defaultExists = false;

		stat = dbCon.createStatement();		    
	    stat.executeUpdate("CREATE TABLE IF NOT EXISTS userprofile ( name, birthday, gender, height);");
	    stat.executeUpdate("CREATE TABLE IF NOT EXISTS weight (uid, date, weight);");
	    stat.executeUpdate("CREATE TABLE IF NOT EXISTS workout ( uid, did, date, duration, heartrate, location, energy, comment);");
	    stat.executeUpdate("CREATE TABLE IF NOT EXISTS sportdiscipline ( name, energyfactor);");
	
	    
		stat = dbCon.createStatement();	
		rs = stat.executeQuery("SELECT rowid FROM userprofile WHERE rowid = " + ActionController.USER_ID + " ; ");
		while(rs.next()){
			defaultExists = true;
		}
		if(defaultExists == false){			
		
			Date today = new Date();
			long todayInMillisec = today.getTimeInMillis();
			//profiles
			stat.executeUpdate("insert into userprofile values ( 'Username', '" + todayInMillisec + " ', '', 0); ");
		}
								
		
	}	

	/**
	 * loads complete WeightHistory from a given UserId
	 * @param profileId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserWeight> loadUserWeights(int profileId)	throws SQLException {
		Statement st = dbCon.createStatement();
		ArrayList<UserWeight> weight = new ArrayList<UserWeight>();
		
		ResultSet rsWeight = st.executeQuery("SELECT * FROM weight WHERE uid = " + profileId	+ " ;");
		
		while (rsWeight.next()) {			
			UserWeight uw = new UserWeight(rsWeight.getInt("date"),
					rsWeight.getDouble("weight"));
			weight.add(uw);
		}
		
		st.close();
		Collections.sort(weight);
		
		return weight;
	}

	

	/**
	 * Saves {@link UserWeight} in to DB, expects filled Obkects
	 * Detemines by ID if new Object(id==0) or if Object needs to be updated (id >0) 
	 * @param uw UserWeight Obkect
	 * @return returns new or current ID
	 * @throws SQLException
	 * @throws SQLQueryException 
	 */
	public int saveUserWeight(UserWeight uw) throws SQLException, SQLQueryException {		
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
	
	
		//new UserProfile
		if(uw.getId() == 0) {
			pst = dbCon.prepareStatement("INSERT INTO weight ('uid', 'date', 'weight') values (?, ?, ?) ;");
			pst.setInt(1, uw.getUserId());
			pst.setLong(2, uw.getDate().getTimeInMillis());
			pst.setDouble(3,uw.getWeight());
			
			
			int affectedRows = pst.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLQueryException("Creating Weight failed, no rows affected.");
	        }
	        
	        generatedKeys = pst.getGeneratedKeys();
	        if (generatedKeys.next()) {
	        	uw.setId((int)generatedKeys.getLong(1));
	        	System.out.print("new Weight rwoId " + uw.getId());
	        	generatedKeys.close();
	        	pst.close();
	        } else {
	            throw new SQLException("Creating Weight failed, no generated key obtained.");
	        }
	   	}
		else {
		//Workout exists just an Update
		
			pst = dbCon.prepareStatement("UPDATE weight SET 'uid' = ?, 'date' = ? , 'weight' = ? WHERE rowid = ? ;");
			
			pst.setInt(1, uw.getUserId());
			pst.setLong(2, uw.getDate().getTimeInMillis());
			pst.setDouble(3,uw.getWeight());
			pst.setInt(4, uw.getId());
			pst.execute();
			
			pst.close();			
		}
		return uw.getId();		
	}
	
	/**
	 * deletes a given UserWeight Object from the SQL DB an stets the five Object to null 
	 * @param uw
	 * @throws SQLException
	 */
	public void deleteUserWeight(UserWeight uw) throws SQLException {
		PreparedStatement pst = null;
		
		if(uw != null && uw.getId() > 0) {
		
			pst = dbCon.prepareStatement("DELETE FROM weight rowid = ? ;");
			
			pst.setInt(1, uw.getId());
			pst.execute();
		}
		uw = null;
		pst.close();	
	}
	
	
	/**
	 * Loads alle SportDiscilines from the Db into an ArrayList
	 * @return sdList list of all SportDisciplines
	 * @throws SQLException
	 */
	public ArrayList<SportDiscipline> loadAllSportDisciplines() throws SQLException {
		Statement st = dbCon.createStatement();
		ArrayList<SportDiscipline> sdList = new ArrayList<SportDiscipline>();
		
		ResultSet rsSD = st.executeQuery("SELECT rowid, name, energyfactor FROM sportdiscipline;");
		while(rsSD.next()){
			SportDiscipline sd = new SportDiscipline(rsSD.getInt("rowid"), rsSD.getString("name"), rsSD.getDouble("energyfactor"));
			sdList.add(sd);
		}
		return sdList;		
	}
	
	
	/**
	 * Loads a single SportDiscipline from a given dId
	 * @param id discipline-ID
	 * @return SportDiscipline-Object
	 * @throws SQLException
	 */
	public SportDiscipline loadSportDiscipline(int id) throws SQLException {
		Statement st = dbCon.createStatement();
		SportDiscipline sd = null;
		
		ResultSet rsSD = st.executeQuery("SELECT * FROM sportdiscipline WHERE rowid = " + id + " ;");
		while(rsSD.next()){
			sd = new SportDiscipline(id, rsSD.getString("name"), rsSD.getDouble("energyfactor"));			
		}
		return sd;	
	}
	
	/**
	 * saves a {@link SportDiscipline}-Object in DB. Determines by the ID if its a new entry(id = 0) or 
	 * an existsing one to update
	 * @param sd completely filled {@link SportDiscipline} Object
	 * @return returns the new /current ID
	 * @throws SQLException
	 * @throws SQLQueryException
	 */
	public int SaveSportDiscipline(SportDiscipline sd) throws SQLException, SQLQueryException{
		
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
	
	
		//new UserProfile
		if(sd.getId() == 0) {
			pst = dbCon.prepareStatement("INSERT INTO sportdiscipline ('name', 'energyFactor') values (?, ?) ;");
			pst.setString(1, sd.getName());
			pst.setDouble(2, sd.getEnergyfactor());
			
			
			int affectedRows = pst.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLQueryException("Creating sportdiscipline failed, no rows affected.");
	        }
	        
	        generatedKeys = pst.getGeneratedKeys();
	        if (generatedKeys.next()) {
	        	sd.setId((int)generatedKeys.getLong(1));
	        	System.out.print("new SportDiscipline rwoId " + sd.getId());
	        	generatedKeys.close();
	        	pst.close();
	        } else {
	            throw new SQLException("Creating sportdiscipline failed, no generated key obtained.");
	        }
	   	}
		else {
		//Workout exists just an Update
		
			pst = dbCon.prepareStatement("UPDATE sportdiscipline SET 'name' = ?, 'energyfactor' = ?  WHERE rowid = ? ;");
			
			pst.setString(1, sd.getName());
			pst.setDouble(2, sd.getEnergyfactor());
			pst.setInt(3, sd.getId());
			pst.execute();
			
			pst.close();			
		}
		return sd.getId();		
	}

	/**
	 * deletes a given sportdiscipline Object from the SQL DB an stets the five Object to null 
	 * @param sd
	 * @throws SQLException
	 */
	public void deleteSportDiscipline(SportDiscipline sd) throws SQLException {
		PreparedStatement pst = null;
		
		if(sd != null && sd.getId() > 0) {
		
			pst = dbCon.prepareStatement("DELETE FROM sportdiscipline rowid = ? ;");			
			pst.setInt(1, sd.getId());
			pst.execute();
		}
		sd = null;
		pst.close();	
	}
	
	
	
	
	/**
	 * fetches all available Profiles, so user can choose which one should be
	 * loaded
	 * @throws SQLConnectionException 
	 * @throws SQLQueryException 
	 * 
	 * @throws SQLException
	 */
	public ArrayList<UserProfile> fetchAllProfiles() throws SQLConnectionException, SQLQueryException {
		ArrayList<UserProfile> profiles = new ArrayList<UserProfile>();
		
		Statement st;
		try {
			st = dbCon.createStatement();
		} 
		catch (SQLException e) {
			if(dbCon != null)
				try {
					dbCon.close();
				} catch (SQLException e2) {					
					e2.printStackTrace();
			}
			throw new SQLConnectionException(e);			
		}
		finally{
			
		}
		
		
		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT rowid, name FROM userprofile");
		} catch (SQLException e) {
			throw new SQLQueryException(e);
		}
		
		try {
			while (rs.next()) {
				UserProfile up = new UserProfile(rs.getInt("rowid"),
						rs.getString("name"));
				profiles.add(up);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			st.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}

		return profiles;
	}

	/**
	 * Loads a complete Profile from a given ProfileId, including complete WeightHistorie and workoutlits as Arraylists 
	 * @param profileId
	 * @return
	 * @throws SQLException
	 */
	public UserProfile loadUserProfile(int profileId) throws SQLException {
		Statement st;
		ResultSet rsProfile;

		st = dbCon.createStatement();
		rsProfile = st.executeQuery("SELECT * FROM userprofile WHERE rowid = '"
						+ profileId + "' ;");

		UserProfile userProfile = new UserProfile(profileId,
				rsProfile.getString("name"), new Date(rsProfile.getLong("birthday")),
				rsProfile.getString("gender"), rsProfile.getInt("height"));

		ArrayList<UserWeight> weight = loadUserWeights(profileId);
		ArrayList<Workout> workout = loadUserWorkouts(profileId);

		// userProfile = new UserProfile(profileId, rsProfile.getString("name"),
		// rsProfile.getInt("birthday"), rsProfile.getString("gender"), weight,
		// workout);
		userProfile.setWorkouts(workout);
		userProfile.setUserWeightHistorie(weight);

		st.close();
		
		return userProfile;
	}

	

	
	public void saveUserProfile(UserProfile p) throws SQLException, SQLQueryException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
	
		//new UserProfile
		if(p.getId() == 0) {
			pst = dbCon.prepareStatement("INSERT INTO userprofile ('name', 'birthday', 'gender', 'height') values (?, ?, ?, ? ) ;");
			pst.setString(1, p.getName());
			pst.setLong(2, p.getBirthday().getTimeInMillis());
			pst.setString(3, p.getGender());
			pst.setInt(4, p.getHeight());
			
			int affectedRows = pst.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLQueryException("Creating user failed, no rows affected.");
	        }
	        
	        generatedKeys = pst.getGeneratedKeys();
	        if (generatedKeys.next()) {
	        	p.setId((int)generatedKeys.getLong(1));
	        	System.out.print("new userId " + p.getId());
	        	generatedKeys.close();
	        	pst.close();
	        } else {
	            throw new SQLException("Creating user failed, no generated key obtained.");
	        }
	       
	        
	        // new user, so no workouts yet

		}
		else {
		//user Exists just an Update
		
			pst = dbCon.prepareStatement("UPDATE userprofile SET 'name' = ? , 'birthday' = ?, 'gender' = ?, 'height' = ?  WHERE rowid = ? ;");
			pst.setString(1, p.getName());
			pst.setLong(2, p.getBirthday().getTimeInMillis());
			pst.setString(3, p.getGender());
			pst.setInt(4, p.getHeight());
			pst.setInt(5, p.getId());
			pst.execute();
			pst.close();
			
		}
		
		if(p.getUserWeightHistorie() != null && !p.getUserWeightHistorie().isEmpty()){
			for(UserWeight uw : p.getUserWeightHistorie()){
				if(uw.getUserId() == 0)
					uw.setUserId(p.getId());
				dh.saveUserWeight(uw);
			}
		}
		
		if(p.getWorkouts() != null && !p.getWorkouts().isEmpty()) {
			for(Workout w : p.getWorkouts()){
				if(w.getUid() == 0)
					w.setUid(p.getId());
				dh.saveWorkout(w);
			}
		}
			
	}
	/**
	 * Dummy function. this version is with one standard user which cannot be deleted
	 * @param up
	 * @throws SQLCantDeleteException
	 */
	public void deleteUserProfile(UserProfile up) throws SQLCantDeleteException {
		System.out.println("dummy we don't delete user Data!");
		if(up != null)
			throw new SQLCantDeleteException();
	}
	
	/**
	 * Loads complete Workoutlist
	 * @param profileId
	 * @return ArrayList of Workouts from uID
	 * @throws SQLException
	 */
	public ArrayList<Workout> loadUserWorkouts(int profileId)throws SQLException {
		System.out.println("Loading Workouts from UserId: " + profileId);
		Statement st = dbCon.createStatement();
		ArrayList<Workout> workout = new ArrayList<Workout>();
		
		ResultSet rsWorkout = st.executeQuery("SELECT rowid, did, uid, date, duration, heartrate, location, energy, comment FROM workout WHERE uid = " + profileId + " ;");
		while (rsWorkout.next()) {
			SportDiscipline sd = loadSportDiscipline(rsWorkout.getInt("did"));
			Workout wo = new Workout(rsWorkout.getInt("rowid"),
									rsWorkout.getInt("uid"),
									rsWorkout.getInt("did"), 
									loadSportDiscipline(rsWorkout.getInt("did")), 
									new Date(rsWorkout.getLong("date")), 
									rsWorkout.getInt("duration"),
									rsWorkout.getInt("heartrate"),
									rsWorkout.getString("location"), 
									rsWorkout.getInt("energy"),
									rsWorkout.getString("comment"));
			workout.add(wo);
			
		}		
		
		st.close();		
		return workout;
	}
	
	/**
	 * Loads single Workout from given wID
	 * @param profileId
	 * @return ArrayList of Workouts from uID
	 * @throws SQLException
	 */
	public Workout loadUserWorkout(int id)throws SQLException {
		Statement st = dbCon.createStatement();
		Workout wo = null;
		System.out.println("ID " + id);
		ResultSet rsWorkout = st.executeQuery("SELECT * FROM workout WHERE rowid = " + id + " ;");
		while (rsWorkout.next()) {
			SportDiscipline sd = loadSportDiscipline(rsWorkout.getInt("did"));
			System.out.println("ROW  " + rsWorkout.getRow());
			wo = new Workout(id ,
									rsWorkout.getInt("uid"),
									rsWorkout.getInt("did"), 
									sd, 
									new Date(rsWorkout.getLong("date")), 
									rsWorkout.getInt("duration"), 
									rsWorkout.getInt("heartrate"),
									rsWorkout.getString("location"), 
									rsWorkout.getInt("energy"),
									rsWorkout.getString("comment"));
		}		
		
		st.close();	
		wo.setDisciplin(dh.loadSportDiscipline(wo.getDid()));
		System.out.println(wo.getId() + "  loaded");
		return wo;
	}	
	
	
	/**
	 * Expects a complet filled Workout Object, so UserId and DicipliId  must be set!
	 * if no Id is set, new entry in DB
	 * if Id is set, update in DB
	 * @param Workout w
	 * @return returns the new or current Workout-ID
	 * @throws SQLException
	 * @throws SQLQueryException
	 */
	public int saveWorkout(Workout w ) throws SQLException, SQLQueryException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
	
	
		//new UserProfile
		if(w.getId() == 0) {
			pst = dbCon.prepareStatement("INSERT INTO workout ('uid', 'did', 'date', 'duration', 'heartrate', 'location', 'energy', 'comment') values (?, ?, ?, ?, ?, ?, ?, ? ) ;");
			pst.setInt(1, w.getUid());
			pst.setInt(2, w.getDid());
			pst.setLong(3, w.getDate().getTimeInMillis());
			pst.setDouble(4, w.getDuration());
			pst.setInt(5, w.getHeartRate());
			pst.setString(6, w.getLocation());
			pst.setInt(7, w.getConsumedCalories());
			pst.setString(8, w.getComment());
			
			int affectedRows = pst.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLQueryException("Creating Workout failed, no rows affected.");
	        }
	        
	        generatedKeys = pst.getGeneratedKeys();
	        if (generatedKeys.next()) {
	        	w.setId((int)generatedKeys.getLong(1));
	        	System.out.print("new workout rwoId " + w.getId());
	        	generatedKeys.close();
	        	pst.close();
	        } else {
	            throw new SQLException("Creating Workout failed, no generated key obtained.");
	        }
	   	}
		else {
		//Workout exists just an Update
		
			System.out.println("update Workout " + w.getId());
			pst = dbCon.prepareStatement("UPDATE workout SET 'uid' = ?, 'did' = ?, 'date' = ?, 'duration' = ?, 'heartrate' = ?, 'location' = ?, 'energy' = ?, 'comment' = ? WHERE rowid = ? ;");
			
			pst.setInt(1, w.getUid());
			pst.setInt(2, w.getDid());
			pst.setLong(3, w.getDate().getTimeInMillis());
			pst.setDouble(4, w.getDuration());
			pst.setInt(5, w.getHeartRate());
			pst.setString(6, w.getLocation());
			pst.setInt(7, w.getConsumedCalories());
			pst.setString(8, w.getComment());
			pst.setInt(9, w.getId());
			pst.execute();
			
			pst.close();			
		}
		return w.getId();		
	}
	public void deleteWorkout(Workout w) throws SQLException {
		
		PreparedStatement pst = null;
		
		if(w != null && w.getId() > 0) {
			System.out.println("delete Wokout " + w.getId());
			pst = dbCon.prepareStatement("DELETE FROM workout WHERE rowid = ? ;");			
			pst.setInt(1, w.getId());
			pst.execute();
		}
		w = null;
		pst.close();	
	}
	

}
