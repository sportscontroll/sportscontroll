package de.dhbw.sportcontroll.db;

import java.sql.SQLException;
import java.util.ArrayList;

import de.dhbw.sportcontroll.dataobjects.UserProfile;

public class DBTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		DataHandler dh = DataHandler.getInstance();
		
		//dh.filldb();
		int id = 200;
		ArrayList<UserProfile> profiles = dh.fetchAllProfiles();
		System.out.println("found " + profiles.size() + " profiles");
		
		for (UserProfile up : profiles) {
			System.out.println("ID: " + up.getId() + "\t name " + up.getName());
			id = up.getId();			
		}
		
		UserProfile up = dh.loadUserProfile(id);
		
		up.printProfile();
		
		
	}

}
