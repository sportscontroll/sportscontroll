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

import de.dhbw.sportcontroll.dataobjects.*;
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
	public static void cleanUp() throws SQLConnectionException  {
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
	        //add first Weight if existts
	        if(!p.getUserWeightHistorie().isEmpty()){
	        	
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
	}
	
	
	/**
	 * Loads complete Workoutlist
	 * @param profileId
	 * @return ArrayList of Workouts from uID
	 * @throws SQLException
	 */
	public ArrayList<Workout> loadUserWorkouts(int profileId)throws SQLException {
		Statement st = dbCon.createStatement();
		ArrayList<Workout> workout = new ArrayList<Workout>();
		
		ResultSet rsWorkout = st.executeQuery("SELECT * FROM workout WHERE uid = " + profileId + " ;");
		while (rsWorkout.next()) {
			SportDiscipline sd = loadSportDiscipline(rsWorkout.getInt("did"));
			Workout wo = new Workout(rsWorkout.getRow() ,
									rsWorkout.getInt("uid"),
									rsWorkout.getInt("did"), 
									loadSportDiscipline(rsWorkout.getInt("did")), 
									new Date(rsWorkout.getLong("date")), 
									rsWorkout.getInt("duration"), 
									rsWorkout.getString("location"), 
									rsWorkout.getInt("energy"));
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
		
		ResultSet rsWorkout = st.executeQuery("SELECT * FROM workout WHERE rowid = " + id + " ;");
		while (rsWorkout.next()) {
			SportDiscipline sd = loadSportDiscipline(rsWorkout.getInt("did"));
			wo = new Workout(rsWorkout.getRow() ,
									rsWorkout.getInt("uid"),
									rsWorkout.getInt("did"), 
									loadSportDiscipline(rsWorkout.getInt("did")), 
									new Date(rsWorkout.getLong("date")), 
									rsWorkout.getInt("duration"), 
									rsWorkout.getString("location"), 
									rsWorkout.getInt("energy"));			
			
		}		
		
		st.close();		
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
			pst = dbCon.prepareStatement("INSERT INTO workout ('uid', 'did', 'date', 'duration', 'location', 'energy') values (?, ?, ?, ?, ?, ? ) ;");
			pst.setInt(1, w.getUid());
			pst.setInt(2, w.getDid());
			pst.setLong(3, w.getDate().getTimeInMillis());
			pst.setDouble(4, w.getDuration());
			pst.setString(5, w.getLocation());
			pst.setInt(6, w.getConsumedCalories());
			
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
		
			pst = dbCon.prepareStatement("UPDATE workout SET 'uid' = ?, 'did' = ?, 'date' = ?, 'duration' = ?, 'location' = ?, 'energy' = ? WHERE rowid = ? ;");
			
			pst.setInt(1, w.getUid());
			pst.setInt(2, w.getDid());
			pst.setLong(3, w.getDate().getTimeInMillis());
			pst.setDouble(4, w.getDuration());
			pst.setString(5, w.getLocation());
			pst.setInt(6, w.getConsumedCalories());
			pst.setInt(7, w.getId());
			pst.execute();
			
			pst.close();			
		}
		return w.getId();		
	}


	

	

	
	
	
	
	
	
	public void createTables(){
		Statement stat;
		try {
			stat = dbCon.createStatement();		    
		    stat.executeUpdate("create table userprofile ( name, birthday, gender, height);");
		    stat.executeUpdate("create table weight (uid, date, weight);");
		    stat.executeUpdate("create table workout ( uid, did, date, duration, location, energy);");
		    stat.executeUpdate("create table sportdiscipline ( name, energyfactor);");
		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
	}
	
	
	/**
	 * filling Db with dummy data
	 */
	public void fillDB(){
		createTables();		
		
		Date today = new Date();
		
		Statement stat;
		try {
			stat = dbCon.createStatement();
			//profiles
			stat.executeUpdate("insert into userprofile values ( 'Daniel', '01081987', 'male', 182); ");
			stat.executeUpdate("insert into userprofile values ('Katja', '20101992', 'female', 169); ");

			//weights
			stat.executeUpdate("insert into weight (uid, date, weight) values (1, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (1, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (1, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (1, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			
			stat.executeUpdate("insert into weight (uid, date, weight) values (2, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (2, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (2, "+ (int)(Math.random() * 100000000.0) +", 75); ");
			stat.executeUpdate("insert into weight (uid, date, weight) values (2, "+ (int)(Math.random() * 100000000.0) +", 75); ");	
			
			
			//dicipline
			stat.executeUpdate("insert into sportdiscipline (name, energyFactor) values ('Schwimmen', 21); ");
			stat.executeUpdate("insert into sportdiscipline (name, energyFactor) values ('Laufen', 25); ");
			stat.executeUpdate("insert into sportdiscipline (name, energyFactor) values ('Radfahren', 18); ");
			
			//workouts
			stat.executeUpdate("insert into workout values (1, 1,"+ (System.currentTimeMillis()/1000) +", (60*30), 'Parkschwimmbad' , 500); ");
			stat.executeUpdate("insert into workout values (1, 1,"+ (System.currentTimeMillis()/1000) +", (60*30), 'Parkschwimmbad' , 500); ");
			stat.executeUpdate("insert into workout values (2, 1,"+ (System.currentTimeMillis()/1000) +", (60*30), 'Parkschwimmbad' , 500); ");
			stat.executeUpdate("insert into workout values (2, 1,"+ (System.currentTimeMillis()/1000) +", (60*30), 'Parkschwimmbad' , 500); ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
