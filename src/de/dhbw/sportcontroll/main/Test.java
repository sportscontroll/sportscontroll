package de.dhbw.sportcontroll.main;
/*
 * This is a test class
 */
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.GregorianCalendar;


import de.dhbw.sportcontroll.controller.Checker;
import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.dataobjects.UserWeight;
import de.dhbw.sportcontroll.dataobjects.Workout;
import de.dhbw.sportcontroll.db.DataHandler;
import de.dhbw.sportcontroll.db.DataHandler.*;

public class Test {

	    
	  
	    
	    public static String getUserSize(int UsId)
	    {
	    	String sUserSize= "198";
	    	
	    	return sUserSize;
	    }
	    
	    public static void setNewSportDiscipline (String eDiscipline, String eEnergyFactor)
	    {
	    	
	    	double dEnergyFactor = Checker.checkEnergyfactor(eEnergyFactor);
	    	String sDiscipline =Checker.checkDiscipline(eDiscipline);
	    	SportDiscipline sdNew = new SportDiscipline(0, eDiscipline, dEnergyFactor);
	    	System.out.println("Sportart gespeichert!!!");
	    	
	    	
	    }
	    
	    public static void setNewUserWeight(String eweight, String edate){
	    	//TODO Speichern in Datenbank
	    	//Date Format Date(1987, 8 ,1)
	    	Double dweight = Checker.checkWeight(eweight);
	    	//Date daDate = Checker.CheckDate(edate);
	    	//DataHandler.saveUserWeight(dweight);    	
	    	// DataHandler.saveUserWeight(UserWeight uw);
	    	
	    }
	    public static void setNewEntry(String ediscipline,String eduration, String edate, String edistance,String elocation, String eHeardRate,String eNote){
	    	String sdiscipline = Checker.checkDiscipline(ediscipline);
	    	
	    	Double dduration = Checker.checkDuration(eduration);
	    	//Date daDate = Checker.CheckDate(edate);
	    	Double sdistance = Checker.checkDistance(edistance) ;
	    	String slocation = Checker.checkLocation(elocation);
	    	Double dHeardRate = Checker.checkHeartRate(eHeardRate);
	    	String sNote = Checker.checkNote(eNote);
	    	
	   // 	Workout wnew = new  Workout(0, uid, did, dadate, dduration, dHeartRate, slocation, sNote)
		    	
	    }
	    public static String[][] exampleWorkout(){
	    	/**
	    	 * Create a ExampleWorkout for Test with Charts or table
	    	 */
	        
	    	String[][] wo={
	                {"1","Schwimmen","30", "20.07.12","10","Lörrach"},
	                {"2","Laufen","20", "21.07.12","10","Lörrach"},
	                {"3","Schwimmen","60", "30.07.12","10","Lörrach"},
	                {"4","Radfahren","85", "01.08.12","10","Lörrach"},
	                {"1","Schwimmen","30", "20.07.12","10","Lörrach"},
	                {"2","Laufen","20", "21.07.12","10","Lörrach"},
	                {"3","Schwimmen","60", "30.07.12","10","Lörrach"},
	                {"4","Radfahren","85", "01.08.12","10","Lörrach"},
	                {"1","Schwimmen","30", "20.07.12","10","Lörrach"},
	                {"2","Laufen","20", "21.07.12","10","Lörrach"},
	                {"3","Schwimmen","60", "30.07.12","10","Lörrach"},
	                {"4","Radfahren","85", "01.08.12","10","Lörrach"},
	                
	        };
	    	int anz = 1;
	    	
			return wo;
	    }
		
	    public void setTableData(ArrayList<Workout> workouts) {
	    	/**
	    	 * 
	    	 */
			int i = 1;
			for(Workout w : workouts){
				w.getId();
				System.out.println(w.getId());
				}
	}
	      
	    public static String [] getcolumnName()
	    {
	    	/**
	    	 * Get the Columnname for Workouttable
	    	 * TODO Search Workouttable for Profil
	    	 * return CulumnName as String Array
	    	 */
	    	
	    	String[] cn= {	"Datum",
	    			        "Sportart",
			                "Dauer",
			                "Strecke",
			                "Ort"
			             };
			return cn;
	    }
	    public static String getUsername(){
	    /**
	     * @return Username as String
	     * TODO GET USERNAME
	     */
	    	String username="Username";
	    
	    	return username;
	    }
	    
	    public static String [] exampleDisciplines(){	
	    /**
	     * @return
	     *  
	     */
	    	String[] sdiscipline = {	"Laufen",
	    					"Rennen",
	    					"Radfahren",
	    					"Untergehen",
	                		"Blub",
	                		"Blub"
	             };
	    //	adiscipline = DataHandler.loadAllSportDisciplines();
	    	
	   //  	String[] sdiscipline = adiscipline.toArray(new String[adiscipline.size()]);
	   // 	  CB_discipline.setItems(sdiscipline);
	    	
	    	return sdiscipline;
	    }
}
	

	

