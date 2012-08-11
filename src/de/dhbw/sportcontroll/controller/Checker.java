/**
 * 
 */
package de.dhbw.sportcontroll.controller;

import javax.swing.JOptionPane;

import de.dhbw.sportcontroll.ui.MainFrame;

/** In this Class are all Methods to Check the User input
 * @author Katja.Kaiser
 *
 */
public class Checker {
	

	public static void main(String[] args) {
		
		Double Bla =CheckWeight("85");
	}
		
		
		
	public static double CheckWeight(String sweight)
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
		
	public static double CheckSize(String ssize)
	{
		/**
		 * @author Katja.Kaiser
		 *  Check size input: Entry not emty between a Min and Max, and without letters
		 *  @param weight as String
		 *  @return weight as double 
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
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ihr Gewicht nur mit Zahlen ein! \n Vewenden sie einen Punkt statt Komma!!!", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				}	
		if (dsize < MIN)
				JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Größe, größer als 100 Zentimeter ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				
		else if (dsize > MAX)
				JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Größe, kleiner als 300 Zentimeter ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);

		else if (dsize < MIN && dsize >MAX)
				return  dsize;
		return dsize;
	}
	public static double CheckDuration(String sduration)
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
	public static boolean CheckGender (boolean genderw , boolean genderm)
	{
		/**
		 * @author Katja.Kaiser
		 *  Check gender input: Controll that exactly one selectet 
		 *  @param genderw, genderm
		 *  @return bgender
		 */
		// CheckGender not implement
		boolean bgender = false;
		
		if (bgender = false)
			JOptionPane.showMessageDialog(null, "Wählen sie das Geschlecht aus:", "Geschlecht", JOptionPane.ERROR_MESSAGE);
		
		return bgender;				
	}
	
	public static double CheckEnergyfactor (int emet)
	{
		/**
		 * @author Katja.Kaiser
		 *  Check Energyfactor: Entry between Min and Max, without letters and more than nothing
		 *  @param emet as double
		 *  @return imet as double 
		 */
		// CheckEnergyfactor not implement
		
		double imet= 0;
		
		
		return imet;				
	}

	public static String CheckLocation(String elocation){
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
				else if (elocation.length()> Min){
					JOptionPane.showMessageDialog(null, "Der Ortsname muss " + Min + " Zeichen beinhalten", "Ortsnahme zu lange", JOptionPane.ERROR_MESSAGE);	
				}
				else if(elocation.equals("") ) {
					JOptionPane.showMessageDialog(null, "Geben Sie einen Ortsnamen ein", "Ortsnahme fehlt", JOptionPane.ERROR_MESSAGE);	
					}
		 slocation = elocation;
		return slocation;
		
	}
	public int CheckHeartRate (String sheardRate){
		/**
		 * @author Katja.Kaiser
		 *  Check HeartRate input: Entry between Min and Max, without letters.
		 *  ??? HeartRate mandatory field??? TODO
		 *  @param HeardRate as String
		 *  @return HeardRate as double 
		 */
		int iheardRate = 0;
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
	
//	public double CheckDuration (String sduration){
//		Double dduration = 0.0;
//		
//		
//		if(sduration == null || sduration.trim().length() == 0)	{
//			JOptionPane.showMessageDialog(null, "Bitte, geben Sie die zurückgelegte Strecke ein Eigabefeld ein", "Streckeneingabe fehlt", JOptionPane.ERROR_MESSAGE);
//		}
//		else
//			try {
//				dduration = Double.parseDouble(sduration);
//				   
//				}
//				catch (NumberFormatException nfe) {
//					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ihre zurückgelegte Strecke nur mit Zahlen ein! \n Vewenden Sie einen Punkt statt Komma!!!", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
//				}	
//						
//		return dduration;
//	}
	public String CheckNote (String enote){
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
	
	public String CheckDate (String edate){
		/**
		 * @author Katja.Kaiser
		 *  Check Date input: Entry not after Today and older than 6 Month, the entry without letters.
		 *  Must accept / and . 
		 *  @param Date as String
		 *  @return Date as DATE? 
		 */
		
		String sdate= "LEER";
		return sdate;
		
		
		
	}
	
}





