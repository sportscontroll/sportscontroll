/**
 * 
 */
package de.dhbw.sportcontroll.controller;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import de.dhbw.sportcontroll.dataobjects.Date;
import de.dhbw.sportcontroll.dataobjects.UserProfile;
import de.dhbw.sportcontroll.db.DataHandler;
import de.dhbw.sportcontroll.exceptions.SQLConnectionException;
import de.dhbw.sportcontroll.exceptions.SQLDriverNotFoundException;
import de.dhbw.sportcontroll.exceptions.SQLQueryException;
import de.dhbw.sportcontroll.ui.MainFrame;
import de.dhbw.sportcontroll.ui.NewEntry;
import de.dhbw.sportcontroll.ui.WorkoutTable;

/**
 * 
 * @author Daniel
 *
 */
public class ActionController {
	private MainFrame mView;
	private DataHandler dh;
	
	private UserProfile currentUser;
	
	public ActionController( MainFrame view){		
		
		mView = view;
		
		try {
			dh = DataHandler.getInstance();
		} catch (SQLDriverNotFoundException | SQLConnectionException e) {
			view.showError("fehler in der DatenBank! ");
			e.printStackTrace();
		}
		
		
		mView.showDateinMainFrame((new Date(System.currentTimeMillis()).getDateGreLiEnd()));
		
		//add actionlisteners
		
		mView.addCloseListener(new CloseListener());
		mView.addNewEntryListener(new NewEntryListener());
		mView.addWorkoutTableActionListener(new WorkoutTableListener());
		
	}
	
	
	
	
	/**
	 * CloseListener for CloseButtons 
	 * @author Daniel
	 * {@link ActionListener}
	 *
	 */
	class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	//FIXME proper save and close actions
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
	
	class WorkoutTableListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Show WorkoutTabl e" + e.getActionCommand());
			WorkoutTable wt = new WorkoutTable();
			wt.setVisible(true);
			wt.setOpaque(true);
			mView.addToMainPanel(wt);
			mView.showPanel();
			
			
		}
	}

}
