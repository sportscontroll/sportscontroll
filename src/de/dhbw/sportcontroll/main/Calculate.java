package de.dhbw.sportcontroll.main;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import de.dhbw.sportcontroll.dataobjects.SportDiscipline;

public class Calculate {

			public static double BodyMassIndex( String sweight, String ssize )
			{
				// Inizial
				double BMIvalue = 0;
				double dsize= 0;
				double dweight= 0;
				
				//Change String into double for calc
				if(sweight == null || sweight.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein richtiges Gewicht ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				 else 
					dweight = Double.parseDouble(sweight);
				
				if(ssize == null || ssize.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie eine richtige Größe ein", "Größeneingabe falsch", JOptionPane.ERROR_MESSAGE);
				 else 
					dsize = Double.parseDouble(ssize)/100;
				
				
				
					if (dweight < 20)
						JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Gewicht größer als 20 Kilogram ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
						
					if (dweight >300)
						JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein Gewicht kleiner als 300 Kilogram ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
					
					if(dsize<1.00)
							JOptionPane.showMessageDialog(null, "  Bitte, geben Sie die Größe in Zentimetern an. Die Größe muss zwischen 100 und 300 liegen! Umgerechenet in Meteraktuell ist sie bei"+ dsize +" eingabe war:  " + ssize, "Größeneingabe falsch", JOptionPane.ERROR_MESSAGE);
						
					else if (dweight>19 && dweight<300 && dsize>1.00 && dsize<3.00)	{					
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
				
				if(sweight == null || sweight.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein richtiges Gewicht ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				 else 
					dweight = Double.parseDouble(sweight);
				
				if(ssize == null || ssize.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie eine richtige Größe ein", "Größeneingabe falsch", JOptionPane.ERROR_MESSAGE);
				 else 
					dsize = Double.parseDouble(ssize)/100;
				
				
					
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
			
			public static double calconsumption (String sduration, String sDiscipline, String sweight)
			{
				// 1 MET entspricht Kalorienverbrauch von 1 kcal je Kilogramm Körpergewicht pro Stunde
				
				// Inizial
				double dweight= 0;
				double dduration= 0;
				
				if(sduration == null || sduration.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein richtiges Gewicht ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				 else 
					dduration = Double.parseDouble(sduration);
				
				if(sweight == null || sweight.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Bitte, geben Sie ein richtiges Gewicht ein", "Gewichtseingabe falsch", JOptionPane.ERROR_MESSAGE);
				 else 
					dweight = Double.parseDouble(sweight);
				
				//Met = //Search sDiscipline gebe MET ZURÜCK
				// test met = 2
				double met = 2 ;
		//		double met= SportDiscipline.getEnergyfactor(sDiscipline);
				
				double calocon = met*dweight*dduration ;
				JOptionPane.showMessageDialog(null, calocon , "Kalorie", JOptionPane.ERROR_MESSAGE);
				
				return calocon;
			}
				
			public static int CalcAge(String sbirthdate){
			
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
	


