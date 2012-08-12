package de.dhbw.sportcontroll.controller;
/**
 * Calculate provides the calc functions:
 *  - BodyMassIndex
 *  - BasicCalorie
 *  - CalorieConsumption
 * 
 * @author Katja
 * 
 */



import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import sun.security.action.GetBooleanAction;

import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.db.DataHandler;
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
				dweight = Checker.checkWeight(sweight);
				dsize = Checker.checkSize(ssize)/100;
				
					if (dweight>19 && dweight<300 && dsize>1.00 && dsize<3.00)	{					
							BMIvalue = dweight/(dsize*dsize);
							JOptionPane.showMessageDialog(null, "Der Bmi beträgt "+BMIvalue+" ! ", "Berechneter BMI", JOptionPane.ERROR_MESSAGE);
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
				
				dsize = Checker.checkSize(ssize);
				dweight = Checker.checkWeight(sweight);
					
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
				
				return 0;
				}
			
			public static double calconsumption (String sduration, String sdiscipline, String sweight)
			
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
				
				dweight = Checker.checkWeight(sweight);
				double met = 1.9; //= Checker.checkEnergyfactor(sdiscipline);
				dduration =Checker.checkDuration(sduration);
				int id = 1;
		        
//			    SportDiscipline sdList = DataHandler.getInstance().loadSportDiscipline(1);	
//			 
//				double met = SportDiscipline.getEnergyfactor();
//			
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
			
}
	


