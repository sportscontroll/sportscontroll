/**
 * 
 */
package de.dhbw.sportcontroll.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import de.dhbw.sportcontroll.ui.MainFrame;
import de.dhbw.sportcontroll.dataobjects.Date;

/** In this Class are all Methods to Check the User input
 *  and to convert in other format
 * @author Katja.Kaiser
 *
 */
public class Checker {
	
		
		
	public static double checkWeight(String sweight)
	{
		/**
		 * @author Katja.Kaiser
		 *  Check weight input: Entry between Min and Max, without letters, and more than nothing :D
		 *  @param weight as String
		 *  @return weight as double 
		 */
		
		final int MIN = 20;
		final int MAX = 299;
		double dweight = 0;
		
		if(sweight == null || sweight.trim().length() == 0)	{
			JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Gewicht in das Gewichtsfeld ein", "Gewichtseingabe fehlt", JOptionPane.ERROR_MESSAGE);
		}
		else
			try {
				   dweight = Double.parseDouble(sweight);
				   
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ihr Gewicht nur mit Zahlen ein! \n Vewenden sie einen Punkt statt Komma!!!", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				}	
					// Check the range
					   if (dweight < MIN)
							JOptionPane.showMessageDialog(null, "Das eingegebene Gewicht muss größer als 20 Kilogramm sein!", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
					   else if (dweight > MAX)
						    JOptionPane.showMessageDialog(null, "Das eingegebene Gewicht muss kleiner als 300 Kilogram sein!", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
					   else if (dweight < MIN && dweight >MAX)
							return  dweight;
				
		return dweight;
		}
		
	public static double checkSize(String ssize)
	{
		/**
		 * @author Katja.Kaiser
		 *  Check size input: Entry not emty between a Min and Max, and without letters
		 *  @param size as String
		 *  @return size as double 
		 */
		
		final int MIN = 20;
		final int MAX = 299;
		double dsize = 0;
		
		
				
		if(ssize == null || ssize.trim().length() == 0)
			JOptionPane.showMessageDialog(null, "Bitte, geben Sie eine Größe in Zentimetern ein:", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
		else
			try {
				   dsize = Double.parseDouble(ssize);
				   
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie Ihre Größe nur mit Zahlen ein! \n Vewenden sie einen Punkt statt Komma!!!", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				}	
		if (dsize < MIN)
				JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Größe, größer als 100 Zentimeter ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				
		else if (dsize > MAX)
				JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Größe, kleiner als 300 Zentimeter ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);

		else if (dsize < MIN || dsize >MAX)
				return  dsize = 0;
		return dsize;
	}
	public static double checkDuration(String sduration)
	/**
	 * @author Katja.Kaiser
	 *  Check duration input: Entry not emty bigger than 0 and without letters.
	 *  @param Duration as String
	 *  @return Duration as double 
	 */
	{
		double dduration = 0;
		if(sduration == null || sduration.trim().length() == 0)	{
			JOptionPane.showMessageDialog(null, "Bitte, geben Sie eine Dauer in das Eingabefeld ein", "Dauerseingabe fehlt", JOptionPane.ERROR_MESSAGE);
		}
		else
			try {
				   dduration = Double.parseDouble(sduration);
				   
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ihre Dauer nur mit Zahlen ein! \n Vewenden sie einen Punkt statt Komma!!!", "Dauerseingabe falsch", JOptionPane.ERROR_MESSAGE);
				}	
		
		if (dduration < 0)
			JOptionPane.showMessageDialog(null, "Bitte, geben Sie eine Dauer größer als 0 ein.", "Dauer falsch", JOptionPane.ERROR_MESSAGE);
		return dduration;
	}
	public static boolean checkGender (boolean genderw , boolean genderm)
	{
		/**
		 * @author Katja.Kaiser
		 *  Check gender input: Controll that exactly one selectet 
		 *  @param genderw, genderm
		 *  @return bgender
		 */
		// CheckGender not implement
		boolean bgender = false;
		
		if (genderw == false && genderm == false)
			JOptionPane.showMessageDialog(null, "Wählen sie das Geschlecht aus:", "Geschlecht", JOptionPane.ERROR_MESSAGE);
		if (genderw == true)
			return false;
		if (genderm == true)
			return genderm;
		
		return bgender;				
	}
	
	public static double checkEnergyfactor (String sMet)
	{
		/**
		 * @author Katja.Kaiser
		 *  Check Energyfactor: Entry between Min and Max, without letters and more than nothing
		 *  @param emet as double
		 *  @return imet as double 
		 */
		
		final int MIN = 1;
		final int MAX = 30;
		double dMet = 0;
		
		
		
		if(sMet == null || sMet.trim().length() == 0)
			JOptionPane.showMessageDialog(null, "Bitte, geben Sie einen MET ein: MET Wert unbekannt vielleicht werden sie hier fündig http://www.startblog-f.de/2008/12/23/tabelle-kalorienverbrauch-laufen/", "Energyfaktor MET nicht eingegeben", JOptionPane.ERROR_MESSAGE);
		else
			try {
				   dMet = Double.parseDouble(sMet);
				   
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie den MET nur mit Zahlen ein! \n Vewenden sie einen Punkt statt Komma!!!", "MET/ Energyfaktoreingabe falsch", JOptionPane.ERROR_MESSAGE);
				}	
		if (dMet < MIN)
				JOptionPane.showMessageDialog(null, "Der MET sollte größer als 0 sein", "Energyfaktor MET zu klein", JOptionPane.ERROR_MESSAGE);
				
		else if (dMet > MAX)
				JOptionPane.showMessageDialog(null, "Der MET sollte kleiner als 30 sein", "Energyfaktor MET zu groß", JOptionPane.ERROR_MESSAGE);

		else if (dMet < MIN && dMet >MAX)
				return  dMet;
		
		return dMet;			
	}

	public static String checkLocation(String elocation){
		/**
		 * @author Katja.Kaiser
		 *  Check Location input: Entry between min(2) and max(20) chars
		 *  @param elocation as String
		 *  @return slocation as String
		 */
		
	 final	int Max = 20;
	 final  int Min = 2;

		String slocation= "LEER";
		String Standard = "Lörrach";
		
				if (elocation.length()> Max){
					JOptionPane.showMessageDialog(null, "Der Ortsname darf nur " + Max + " Zeichen beinhalten", "Ortsnahme zu lange", JOptionPane.ERROR_MESSAGE);	
				}
				else if (elocation.length()< Min){
					JOptionPane.showMessageDialog(null, "Der Ortsname muss " + Min + " Zeichen beinhalten", "Ortsnahme zu lange", JOptionPane.ERROR_MESSAGE);	
				}
				else if(elocation.equals("") ) {
					JOptionPane.showMessageDialog(null, "Geben Sie einen Ortsnamen ein", "Ortsnahme fehlt", JOptionPane.ERROR_MESSAGE);	
					}
		 slocation = elocation;
		return slocation;
		
	}
	public static double checkHeartRate (String sheardRate){
		/**
		 * @author Katja.Kaiser
		 *  Check HeartRate input: Entry between Min and Max, without letters.
		 *  ??? HeartRate mandatory field??? TODO
		 *  @param HeardRate as String
		 *  @return HeardRate as double 
		 */
		double iheardRate = 0;
		final int MIN = 20;
		final int MAX = 220;
		
		// Wenn HeartRate erforderlich
		if(sheardRate == null || sheardRate.trim().length() == 0)
			JOptionPane.showMessageDialog(null, "Bitte, geben Sie ihren Puls ein!", "Pulseingabe fehlt", JOptionPane.ERROR_MESSAGE);
		else
			try {
				 iheardRate = Integer.parseInt(sheardRate);
				   
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ihre Herzfrequenz/Puls nur mit Ganzen Zahlen ein!", "Pulsseingabe falsch", JOptionPane.ERROR_MESSAGE);
				}	
		
		if (iheardRate < MIN)
			JOptionPane.showMessageDialog(null, "Ihr Puls sollte zwischen "+MIN + " und "+ MAX +" liegen. Bitte geben sie einen passenden Wert ein!", "Pulsseingabe falsch", JOptionPane.ERROR_MESSAGE);
			
	   else if (iheardRate > MAX)
		JOptionPane.showMessageDialog(null, "Ihr Puls sollte zwischen "+MIN + "  und "+ MAX +" liegen. Bitte geben sie einen passenden Wert ein!", "Pulsseingabe falsch", JOptionPane.ERROR_MESSAGE);
				
		return iheardRate;
	}

	public static String checkNote (String enote){
		/**
		 * @author Katja.Kaiser
		 *  Check Note input: Entry between Min and Max chars
		 *  No mandatory field  TODO
		 *  @param Note as String
		 *  @return Note as String
		 */	
		
			 final	int Max = 120;
			 final  int Min = 2;

				String snote= "LEER";
				String standard = "...";
				
						if (enote.length()> Max){
							int toolong = enote.length() - Max;
							JOptionPane.showMessageDialog(null, "Ihr Kommentar ist Beschränkt auf " + Max + " Zeichen. Ihr Kommentar hat"+ toolong +" Zeichen", "Kommentar zu lange", JOptionPane.ERROR_MESSAGE);	
						}
						
						else if(enote.equals(standard) ) {
							snote = "";
						}
				 snote = enote;
				return snote;
		
	}
	
	public static Date checkDate (String edate) throws ParseException{
		/**
		 * @author Katja.Kaiser
		 *  Check Date input: Entry not after Today and older than 6 Month, the entry without letters.
		 *  Must accept / and . 
		 *  @param Date as String
		 *  @return Date as DATE? 
		 */
		
	 
		int MAXdif = 20;
	
		String[] date = edate.split("\\.");
		 
		int eDay = Integer.parseInt(date[0]);
		int eMonth = Integer.parseInt(date[1]);
		int eYear = Integer.parseInt(date[2]);
		
		Date cal = new Date();
		//cal.setTime(new Date()); //Today
		int year = cal.get(Calendar.YEAR); 
		int month = cal.get(Calendar.MONTH); 
		int day = cal.get(Calendar.DAY_OF_MONTH); 
		
		if(eYear==year){
			if(eMonth==month){
				if((day-eDay)==MAXdif){
					//TODO Ausabe in Datum
					//Date dadate =New Date(eDay, eMonth, eYear);
				    try{
	                    SimpleDateFormat sdfToDate = new SimpleDateFormat( "dd.MM.yyyy" );
	                    Date dadate = new Date(sdfToDate.parse(edate).getTime());
	                    
	                }catch(ParseException ex2){
	                    System.out.println("Fehler");
	                   
	                }
				}
				
			}
		}
		//else JOptionPane.showMessageDialog(null, "Sie können kein Gewicht eintragen das länger als" + MAXdif + " Tage zurückliegt. Oder in der Zukunftliegt! Überprüfen Sie Ihre Datums eingabe!", "Eintrag falsches Datum", JOptionPane.ERROR_MESSAGE);	
		 
		try{
             SimpleDateFormat sdfToDate = new SimpleDateFormat( "dd.MM.yyyy" );
             Date dadate = new Date(sdfToDate.parse(edate).getTime());
             
         }catch(ParseException ex2){
             System.out.println("Fehler");
         }
		SimpleDateFormat sdfToDate = new SimpleDateFormat( "dd.MM.yyyy" );
		 Date dadate = new Date(sdfToDate.parse(edate).getTime());
        
	 return dadate;
	}
		
	
		
	
	public static String checkDiscipline (String ediscipline){
		/**
		 * @author Katja.Kaiser
		 * @input Sportdiscipline as String
		 * @return Discipline as String
		 * 
		 */
		String sdiscipline;
		
		
		int Max = 20;
		int Min = 2;
		
				if (ediscipline.length()> Max){
					JOptionPane.showMessageDialog(null, "Die Sportart darf nur " + Max + " Zeichen beinhalten", "Name der Sportart zu lange", JOptionPane.ERROR_MESSAGE);	
				}
				else if (ediscipline.length()< Min){
					JOptionPane.showMessageDialog(null, "Die Sportart muss " + Min + " Zeichen beinhalten", "Name der Sportart zu lange", JOptionPane.ERROR_MESSAGE);	
				}
				else if(ediscipline.equals("") ) {
					JOptionPane.showMessageDialog(null, "Geben Sie eine Sportart ein", "Name der Sportart fehlt", JOptionPane.ERROR_MESSAGE);	
					}
		 sdiscipline = ediscipline;
		

		return sdiscipline;
		
	
	}



	public static Double checkDistance(String edistance) {
		/**
		 * @author Katja.Kaiser
		 *  Check size input: Entry not emty between a Min and Max, and without letters
		 *  @param size as String
		 *  @return size as double 
		 */
		
		
		final int MAX = 299;
		double ddistance = 0;
		
		
				
		if(edistance == null || edistance.trim().length() == 0)
			JOptionPane.showMessageDialog(null, "Bitte, geben Sie die Distanz/Strecke in Metern ein! Oder 0", "Distanz falsch", JOptionPane.ERROR_MESSAGE);
		else
			try {
				   ddistance = Double.parseDouble(edistance);
				   
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ihre Distanz/Strecke nur mit Zahlen ein! \n Vewenden sie einen Punkt statt Komma!!!", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				}	
	
		if (ddistance > MAX)
				JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Distanz/Strecke , kleiner als 300 Meter ein", "Distanz falsch", JOptionPane.ERROR_MESSAGE);

		return ddistance;
	
	
	}

}





