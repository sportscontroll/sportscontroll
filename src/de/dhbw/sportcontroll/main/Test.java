package de.dhbw.sportcontroll.main;
/*
 * This is a test class
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.GregorianCalendar;


import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.db.DataHandler;
import de.dhbw.sportcontroll.db.DataHandler.*;

public class Test {

	
	    public static String GregorianCalendarDate() {
	        GregorianCalendar now = new GregorianCalendar();
	        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);   // 08.08.12
//	        df = DateFormat.getDateInstance(DateFormat.MEDIUM);             // 08.08.2012
//	        df = DateFormat.getDateInstance(DateFormat.LONG);               // 08. August 2012
//	        df = DateFormat.getTimeInstance(DateFormat.SHORT);              // 08:21
//	        df = DateFormat.getTimeInstance(DateFormat.MEDIUM);             // 08:21:12
//	        df = DateFormat.getTimeInstance(DateFormat.LONG);               // 08:21:12 MESZ
	        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG); // 08.08.12 08:35:00 MESZ
//	        System.out.println(df.format(now.getTime()));
	        
	        /*
	         * Change DataFormat to String for Output
	         */
	        String sdf = df.format(new Date());
	        return sdf;
	    
	        	
	        }
	    
	    public static String[][] GETWorkout(){
	        
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
	    	
	    	return wo;
	    }
	    
	    public static String [] GETColumnName()
	    {
	    	/**
	    	 * Get the Columnname for Workouttable
	    	 * TODO Search Workouttable for Profil
	    	 * return CulumnName as String Array
	    	 */
	    	
	    	String[] cn= {	"ID",
			                "Sportart",
			                "Dauer",
			                "Datum",
			                "Strecke",
			                "Ort"
			             };
			return cn;
	    }
	    public static String GetUsername(){
	    /**
	     * @return Username as String
	     * TODO GET USERNAME
	     */
	    	String username="Username";
	    
	    	return username;
	    }
	    
	    public static String [] GetDisciplines(){	
	    /**
	     * @return
	     * TODO GetDiscipline 
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
	

	

