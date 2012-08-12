package de.dhbw.sportcontroll.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import de.dhbw.sportcontroll.dataobjects.*;
import de.dhbw.sportcontroll.exceptions.SQLConnectionException;
import de.dhbw.sportcontroll.exceptions.SQLQueryException;
import de.dhbw.sportcontroll.exceptions.SQLDriverNotFoundException;

public class DBTest {

	/**
	 * 
	 * 
	 * only for Testing the DB and DH
	 * 
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws SQLQueryException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException, SQLQueryException {
		// TODO Auto-generated method stub
		
		DataHandler dh = null;
		try {
			dh = DataHandler.getInstance();
		} catch (SQLDriverNotFoundException | SQLConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dh.fillDB();
		int id = 200;
		ArrayList<UserProfile> profiles = null;
		try {
			profiles = dh.fetchAllProfiles();
		} catch (SQLConnectionException | SQLQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("found " + profiles.size() + " profiles");
		
		for (UserProfile up : profiles) {
			System.out.println("ID: " + up.getId() + "\t name " + up.getName());
			id = up.getId();			
		}
		
		UserProfile up = dh.loadUserProfile(id);
		
		up.printProfile();
		
		
		UserProfile newProfile = new UserProfile(1, "Daniel", new Date(1987, 8 ,1), "male", 182);
		try {
			dh.saveUserProfile(newProfile);
		} catch (SQLQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Workout w1 = new Workout(newProfile.getId(), 1, new Date(System.currentTimeMillis()), (60 * 30), 180, "Duerrenbuehl", "war schon besser");
		w1.setId(5);
		try {
			w1.printWorkout();
			dh.saveWorkout(w1);
		} catch (SQLQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\n SPORT DISCIPLINES ");
		SportDiscipline sd1 = new SportDiscipline(0, "BF3-Zocken", 0.2);
		int sdId = 0;
		
		sdId = dh.SaveSportDiscipline(sd1);
		
		sd1.setEnergyfactor(42.23);
		dh.SaveSportDiscipline(sd1);
	
		SportDiscipline sd2 = dh.loadSportDiscipline(1);
		System.out.println("Sport " + sd2.getName());
		
		ArrayList<SportDiscipline> sdList = dh.loadAllSportDisciplines();
		
		for (SportDiscipline sd : sdList) {
			System.out.println("sdid = " + sd.getId() + "; name = " + sd.getName() + "; energyFactor = " + sd.getEnergyfactor());
		}
		
		System.out.println("\n\n");
		
		GregorianCalendar cal = new GregorianCalendar(1953, 3, 12, 12, 22, 0);
		Long t = cal.getTimeInMillis();
		
		System.out.println("\n\n time " + t);
		
//new java.util.Date(1953, 6, 12, 12, 22, 0);
	//	long dateTest 
		
	}

}
