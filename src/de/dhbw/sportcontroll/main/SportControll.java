package de.dhbw.sportcontroll.main;

import de.dhbw.sportcontroll.controller.ActionController;
import de.dhbw.sportcontroll.db.DataHandler;
import de.dhbw.sportcontroll.ui.MainFrame;

public class SportControll {

	/**
	 * Hauptklasse
	 *     
	 * @param args Aufrufparameter
	 * @author schoko
	 * @return 
	 * @exception
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Starting sportscontroll");
		
		MainFrame view = new MainFrame();
		ActionController sportsControll = new ActionController(view);
		
				
		
	}
}
