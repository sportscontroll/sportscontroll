/**
 * 
 */
package de.dhbw.sportcontroll.controller;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.EventListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import de.dhbw.sportcontroll.dataobjects.Date;
import de.dhbw.sportcontroll.dataobjects.UserProfile;
import de.dhbw.sportcontroll.db.DataHandler;
import de.dhbw.sportcontroll.exceptions.SQLConnectionException;
import de.dhbw.sportcontroll.exceptions.SQLDriverNotFoundException;
import de.dhbw.sportcontroll.exceptions.SQLQueryException;
import de.dhbw.sportcontroll.ui.Calc;
import de.dhbw.sportcontroll.ui.ConfigProfil;
import de.dhbw.sportcontroll.ui.MainFrame;
import de.dhbw.sportcontroll.ui.NewEntry;
import de.dhbw.sportcontroll.ui.WorkoutTable;

/**
 * 
 * @author Daniel
 *
 */



public class ActionController {
	
	public static final int USER_ID = 1;
	
	private MainFrame mView;
	private DataHandler dh;
	
	private UserProfile currentUser;
	
	public ActionController( MainFrame view){		
		
		
		//get connection to DB
		try {
			dh = DataHandler.getInstance();
		} catch (SQLDriverNotFoundException | SQLConnectionException e) {
			view.showError("fehler in der DatenBank! ");
			e.printStackTrace();
		}
		// load DEFAULT User
		try {
			currentUser = dh.loadUserProfile(USER_ID);
		} catch (SQLException e) {
			System.out.println("Error loading user");
			e.printStackTrace();
		}
		
		//load View
		mView = view;
		
		//add actionlisteners		
		mView.addCloseListener(new CloseListener());
		mView.addNewEntryListener(new NewEntryListener());
		mView.addButtonWorkoutTableActionListener(new ButtonWorkoutTableListener());
		mView.addButtonConfigProfileActionListener(new ButtonProfileListener());
		mView.addButtonCalculatorActionListener(new ButtonCalculatorListener());
		
		//add Date to buttom of MainFrame
		mView.showDateinMainFrame((new Date(System.currentTimeMillis()).getDateGreLiEnd()));
		
		
		//set view visible
		view.setVisible(true);
		
	}
	
	
	
	
	
	
	/**
	 * NewEntryListener implements ActionListener for opening the NewEnty Dialog
	 * @author Daniel
	 *
	 */
	class NewEntryListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {	
			System.out.println("neuer eintrag!!");
			NewEntry newEntryFrame = new NewEntry(mView);
			newEntryFrame.setVisible(true);	
		}			
	}
	
	class ButtonWorkoutTableListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Show WorkoutTable" + e.getActionCommand());
			WorkoutTable wt = new WorkoutTable();
			wt.setVisible(true);
			wt.setOpaque(true);
			//mView.addToMainPanel(wt, "workouttable");
			mView.showPanelWorkoutTable();		
		}
	}
	
	class ButtonProfileListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Show Profile e" + e.getActionCommand());			
			mView.showPanelProfile();			
		}
	}
	
	
	class ButtonCalculatorListener implements ActionListener {
		private static final long serialVersionUID = -4327610667106708501L;

		public void actionPerformed(ActionEvent evt) {
			System.out.println("shwo calc");
			mView.showPanelClaculator();			
		}
		
	}
	
	


	
	public class CloseListener implements WindowListener, ActionListener {
	    		
		private void handleCloseAction(){
			System.out.println("ich wurde geschlossen");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				dh.saveUserProfile(currentUser);
			} catch (SQLException | SQLQueryException e1) {
				mView.showError("Fehler beim Speichern! das ist nicht gut!");
				e1.printStackTrace();
			}
	    	finally{
	    		mView.setVisible(false);
	    		System.exit(0);	    		
	    	}
			
		}
		
		public void actionPerformed(ActionEvent e) {
	    	handleCloseAction();
	    }
		@Override
		public void windowActivated(WindowEvent e) {	
		}
		@Override
		public void windowClosed(WindowEvent e) {
			handleCloseAction();			
		}
		@Override
		public void windowClosing(WindowEvent e) {
			handleCloseAction();
			
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
		}
		@Override
		public void windowIconified(WindowEvent e) {			
		}
		@Override
		public void windowOpened(WindowEvent e) {
		}		
	}
}
