package de.dhbw.sportcontroll.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.security.auth.UserPrincipal;

import de.dhbw.sportcontroll.dataobjects.*;

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

	private SqlManager mSqlManager;

	/**
	 * private construktor
	 */
	private DataHandler() {	}

	/**
	 * 
	 * @return returns the Instance of the Datahandler
	 */
	public static DataHandler getInstance() {
		if (dh == null) {
			dh = new DataHandler();
			try {
				dh.mSqlManager = new SqlManager(DB_FILE_NAME);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dh;
		} else {
			return dh;
		}
	}

	/**
	 * fetches all available Profiles, so user can choose which one should be
	 * loaded
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<UserProfile> fetchAllProfiles() throws SQLException, ClassNotFoundException {
		
		ArrayList<UserProfile> profiles = new ArrayList<UserProfile>();

		ResultSet rs = dh.mSqlManager
				.dbSingleQuery("SELECT rowid, name FROM userprofile");
		while (rs.next()) {
			UserProfile up = new UserProfile(rs.getInt("rowid"),
					rs.getString("name"));
			profiles.add(up);
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
		

		ResultSet rsProfile = dh.mSqlManager
				.dbSingleQuery("SELECT * FROM userprofile WHERE rowid = '"
						+ profileId + "' ;");

		UserProfile userProfile = new UserProfile(profileId,
				rsProfile.getString("name"), rsProfile.getInt("birthday"),
				rsProfile.getString("gender"));

		ArrayList<UserWeight> weight = loadUserWeights(profileId);
		ArrayList<Workout> workout = loadUserWorkouts(profileId);

		// userProfile = new UserProfile(profileId, rsProfile.getString("name"),
		// rsProfile.getInt("birthday"), rsProfile.getString("gender"), weight,
		// workout);
		userProfile.setWorkouts(workout);
		userProfile.setUserWeightHistorie(weight);

		return userProfile;
	}

	/**
	 * loads complete WeightHistory from a given UserId
	 * @param profileId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserWeight> loadUserWeights(int profileId)	throws SQLException {
		
		// get WeightHistorie
		ArrayList<UserWeight> weight = new ArrayList<UserWeight>();
		ResultSet rsWeight = dh.mSqlManager.dbSingleQuery("SELECT * FROM weight WHERE uid = " + profileId	+ " ;");
		
		while (rsWeight.next()) {			
			UserWeight uw = new UserWeight(rsWeight.getInt("date"),
					rsWeight.getDouble("weight"));
			weight.add(uw);
		}
		return weight;
	}

	/**
	 * Loads complete Workoutlist
	 * @param profileId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Workout> loadUserWorkouts(int profileId)throws SQLException {
		
		// get Workouts
		ArrayList<Workout> workout = new ArrayList<Workout>();
		ResultSet rsWorkout = dh.mSqlManager.dbSingleQuery("SELECT * FROM workout WHERE uid = " + profileId + " ;");
		while (rsWorkout.next()) {
			// TODO diciplin
			Workout wo = new Workout(rsWorkout.getInt("date"), rsWorkout.getInt("duration"), rsWorkout.getString("location"), null);
			workout.add(wo);
		}
		return workout;
	}

	public void createuserProfile(UserProfile p) throws SQLException {
		ResultSet rs = dh.mSqlManager.dbSingleQuery("INSERT INTO userprofile ('name', 'birthday', 'gender', height) " +
				" values ("+ p.getName() +", " +
			     p.getBirthday().toString() +", " +
			     p.getGender() + ", " +
			     p.getHeight() + ");");
		
	//	dh.mSqlManager.
	}

	public void saveUserProfile(UserProfile p) {
		
	}

	
	public void saveWorkout(){}
	
	
	/**
	 * only for Testing needed
	 */
	public void filldb() {
		try {
			dh.mSqlManager = new SqlManager(DB_FILE_NAME);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mSqlManager.fillDB();
	}

}
