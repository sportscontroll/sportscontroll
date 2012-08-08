package de.dhbw.sportcontroll.main;
/**
 * Calculate provides the calc functions:
 *  - BodyMassIndex
 *  - BasicCalorie
 *  - CalorieConsumption
 * 
 * @author Katja
 * 
 */



import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.exceptions.SQLConnectionException;
import de.dhbw.sportcontroll.exceptions.SQLDriverNotFoundException;

public class Calculate {

			public static double BodyMassIndex( String sweight, String ssize )
			{
				/**
				 * @input weight, size
				 * @return returns BMIvalue
				 * 
				 */
				double BMIvalue = 0;
				double dsize= 0;
				double dweight= 0;
				
				//Change String into double for calc
				dweight = CheckWeight(sweight);
				dsize = CheckSize(ssize)/100;
				
					if (dweight>19 && dweight<300 && dsize>1.00 && dsize<3.00)	{					
							BMIvalue = dweight/(dsize*dsize);
							JOptionPane.showMessageDialog(null, "Der Bmi betr�gt "+BMIvalue+" ! ", "Berechneter BMI", JOptionPane.ERROR_MESSAGE);
					 }
				return BMIvalue;
				//Should BMI show in calc or statistic?
			} 

			public static double BasicCalorie(String sweight, String ssize, String sbirthdate, JRadioButton genderw, JRadioButton genderm )
			{
				// Inizial
			
				double dsize= 0;
				double dweight= 0;
				
				int iage = CalcAge(sbirthdate);
				
				dsize = CheckSize(ssize);
				dweight = CheckWeight(sweight);
					
				//Check Man or Women
				if (genderm.isSelected()==true)
				{
					//term for Man
						double ccvalue = (66.5+13.7* dweight+5*dsize-6.8*iage);
							
						JOptionPane.showMessageDialog(null, ccvalue , "Grundumsatz", JOptionPane.ERROR_MESSAGE);
								
						}
				if (genderw.isSelected() == true)
						{
					//term for Woman
						double ccvalue = (665+9.6* dweight+1.8*dsize-4.7*iage);
						
						
				JOptionPane.showMessageDialog(null, ccvalue , "Grundumsatz", JOptionPane.ERROR_MESSAGE);
						}
				
				JOptionPane.showMessageDialog(null, "RETURN" , "Grundumsatz", JOptionPane.ERROR_MESSAGE);
				return 0;
				}
			
			public static double calconsumption (String sduration, String sDiscipline, String sweight)
			
			{
				/**Calc the calconsumption while train
				 * 1 MET is the calconsumption  1 calorie per kilo weight per hour
				 *
				 * @input duration, discipline, weight, from Calc.java
				 * @input Energyfactor from SportDiscipline via discipline
				 * @return returns the calocon
				 *
				 */
				// 
				// Inizial
				double dweight= 0;
				double dduration= 0;
				
				dweight = CheckWeight(sweight);
				//Met = //Search sDiscipline gebe MET ZUR�CK
				// test met = 2
				double met = 2 ;
			//	double met = SportDiscipline.getEnergyfactor(sDiscipline);
				
				double calocon = met*dweight*dduration ;
				JOptionPane.showMessageDialog(null, calocon , "Kalorie", JOptionPane.ERROR_MESSAGE);
				
				return calocon;
			}
				
			public static int CalcAge(String sbirthdate)
			{
				/** Calc the age
				 * @input birthdate as string
				 * @return return the age as int
				 * 
				 */
					int iage= 0;
				String[] date = sbirthdate.split("\\.");
				 
				int birthDay = Integer.parseInt(date[0]);
				int birthMonth = Integer.parseInt(date[1]);
				int birthYear = Integer.parseInt(date[2]);
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date()); //Today
				int year = cal.get(Calendar.YEAR); 
				int month = cal.get(Calendar.MONTH); 
				int day = cal.get(Calendar.DAY_OF_MONTH); 
				
				iage = year-birthYear;
				
				if (birthDay > day && birthMonth == month)
					iage = iage-1;
				if(birthMonth>month)
					iage = iage-1;
				
				System.out.println("Alter"+iage);
			
				return iage;
			}
			
			public static double CheckWeight(String sweight)
			{
				final int MIN = 20;
				final int MAX = 299;
				double dweight = 0;
						
				if(sweight == null || sweight.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein richtiges Gewicht ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				else 
					dweight = Double.parseDouble(sweight);

				if (dweight < MIN)
						JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Gewicht gr��er als 20 Kilogram ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
						
				if (dweight > MAX)
						JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Gewicht kleiner als 300 Kilogram ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);

				else if (dweight < MIN && dweight >MAX)
						return  dweight;
				return dweight;
			}
			
			public static double CheckSize(String ssize)
			{
				final int MIN = 20;
				final int MAX = 299;
				double dsize = 0;
						
				if(ssize == null || ssize.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie eine richtige Gr��e in Zentimetern ein:", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				else 
					dsize = Double.parseDouble(ssize);

				if (dsize < MIN)
						JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Gr��e, gr��er als 100 Zentimeter ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
						
				if (dsize > MAX)
						JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Gr��e, kleiner als 300 Zentimeter ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);

				else if (dsize < MIN && dsize >MAX)
						return  dsize;
				return dsize;
			}
			public static double CheckDuration(String sduration)
			{
				double dduration = 0;
				if(sduration == null || sduration.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie eine Dauer ein", "Dauer falsch", JOptionPane.ERROR_MESSAGE);
				 else 
					dduration = Double.parseDouble(sduration);
				if (dduration < 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie eine Dauer gr��er als 0 ein.", "Dauer falsch", JOptionPane.ERROR_MESSAGE);
				return dduration;
			}
			public static boolean CheckGender (boolean genderw , boolean genderm)
			{
				// CheckGender not implement
				boolean bgender = false;
				
				if (bgender = false)
					JOptionPane.showMessageDialog(null, "W�hlen sie das Geschlecht aus:", "Geschlecht", JOptionPane.ERROR_MESSAGE);
				
				return bgender;				
			}
			
			public static int CheckEnergyfactor (int emet)
			{
				// CheckEnergyfactor not implement
				int imet= 0;
				
				
				return imet;				
			}
	}
	


