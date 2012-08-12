/**
 * 
 */
package de.dhbw.sportcontroll.controller;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.EventListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.dhbw.sportcontroll.dataobjects.Date;
import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.dataobjects.UserProfile;
import de.dhbw.sportcontroll.dataobjects.UserWeight;
import de.dhbw.sportcontroll.dataobjects.Workout;
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
	private Workout selectedWorkout;
	
	NewEntry newEntryFrame;
	
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
		
		//add some DummyData
		addDummyData();
				
		
		if(currentUser.getWorkouts() == null)
			try {
				currentUser.setWorkouts(dh.loadUserWorkouts(currentUser.getId()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
		System.out.println("Workouts = " +currentUser.getWorkouts().size());
		
		
		//load View
		mView = view;
		mView.initGUI(currentUser.getWorkouts());
	
		
		//add actionlisteners		
		mView.addCloseListener(new CloseListener());
		mView.addNewEntryListener(new NewEntryListener());
		mView.addButtonWorkoutTableActionListener(new ButtonWorkoutTableListener());
		mView.addButtonConfigProfileActionListener(new ButtonProfileListener());
		mView.addButtonCalculatorActionListener(new ButtonCalculatorListener());
		mView.addSaveListener(new SaveActionListener());
		mView.addTableMouseAdapter(new TableMouseAdapter());
		
		mView.addSaveProfileListener(new SaveProfileButtonListener());
		
		//add Date to buttom of MainFrame
		mView.showDateinMainFrame((new Date(System.currentTimeMillis()).getDateGreLiEnd()));
		mView.addDataToTable(currentUser.getWorkouts());
		
		
		//set view visible
		view.setVisible(true);
		
	}
	
	
	private void addDummyData(){
		currentUser.setHeight(182);
		currentUser.setGender("male");
		currentUser.setName("Daniel");
		currentUser.setBirthday(new Date(1987, 8, 1));
		currentUser.addUserWeight(new UserWeight(new Date(2012,  8, 11), 76));
		
		
		SportDiscipline sd1 = new SportDiscipline(0, "Schwimmen", Math.PI);
		SportDiscipline sd2 = new SportDiscipline(0, "Radfahren", 2 *Math.PI);
		SportDiscipline sd3 = new SportDiscipline(0, "Laufen", 3*Math.PI);
		SportDiscipline sd4 = new SportDiscipline(0, "BettSport", 20*Math.PI);
		
		try {
			dh.SaveSportDiscipline(sd1);
			dh.SaveSportDiscipline(sd2);
			dh.SaveSportDiscipline(sd3);
			dh.SaveSportDiscipline(sd4);
		} catch (SQLException | SQLQueryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Workout w1 = new Workout(0, currentUser.getId(), 1,  new Date(), 60*30, 180, "da hoim", "voll gut1");
		Workout w2 = new Workout(0, currentUser.getId(), 2,  new Date(), 60*45, 170, "da hoim", "voll gut2");
		Workout w3 = new Workout(0, currentUser.getId(), 3,  new Date(), 60*60, 150, "da hoim", "voll gut3");
		try {
			dh.saveWorkout(w1);
			dh.saveWorkout(w2);
			dh.saveWorkout(w3);
			
		} catch (SQLException | SQLQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	class SaveProfileButtonListener implements ActionListener {		

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Hallo");
			ConfigProfil cp = mView.getProfilePanel();
			System.out.println("Hallo");
			currentUser.setName(cp.getTF_Name().getText());
						
			try {
				currentUser.setBirthday(Checker.checkDate(cp.getTF_Birthdate().getText()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(cp.getRB_gender_m().isEnabled()){
				currentUser.setGender("male");
			}
			else {
				currentUser.setGender("female");
			}
			//String genderFemale = cp.getRB_gender_w().getName();
			
			currentUser.setHeight(Integer.parseInt(cp.getTF_Size().getText()));
			//currentUser.setUserWeightHistorie(null);
			try {
				dh.saveUserProfile(currentUser);
			} catch (SQLException | SQLQueryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
			newEntryFrame.addSaveEntryActionListener(new SaveNewEntryActionListener(newEntryFrame));
			
			newEntryFrame.setVisible(true);	
		}			
	}
	
	class ButtonWorkoutTableListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Show WorkoutTabl e" + e.getActionCommand());
			mView.showPanelWorkoutTable(currentUser.getWorkouts());		
		}
	}
	
	class ButtonProfileListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Show Profile e" + e.getActionCommand());			
			mView.showPanelProfile(currentUser);			
		}
	}
	
	
	class ButtonCalculatorListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			System.out.println("shwo calc");
			mView.showPanelClaculator();			
		}
		
	}
	
	class SaveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			System.out.println("Save Data");
			try {
				dh.saveUserProfile(currentUser);
			} catch (SQLException | SQLQueryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
	}
	
	class ButtonDeleteWorkoutActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			newEntryFrame.setVisible(false);
			newEntryFrame = null;
			try {
				dh.deleteWorkout(selectedWorkout);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(currentUser.getWorkouts().size());
			
			try {
				currentUser.setWorkouts(dh.loadUserWorkouts(currentUser.getId()));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			mView.refreshTableData(currentUser.getWorkouts());
			
		}
		
	}
	
	/**
	 * TableMouseAdapter is used to determine wicht row is clicked to load and edit the selected 
	 * Workout
	 * @author schoko
	 *
	 */	
	class TableMouseAdapter extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
		      if (e.getClickCount() == 2) {
		    	  
		         JTable target = (JTable)e.getSource();
		         int row = target.getSelectedRow();
		         int column = target.getSelectedColumn();
		         
		         int value = (Integer)target.getValueAt(row, 0);
		         System.out.println("row " + row + " value="+value);
		         try {
					 selectedWorkout = dh.loadUserWorkout(value);
				} catch (SQLException e1) {
					mView.showError("Can't open This Workout, ERROR");
					e1.printStackTrace();
				}
		        System.out.println("openDialog");
		        
		        newEntryFrame = new NewEntry(mView, selectedWorkout);
		        newEntryFrame.addSaveEntryActionListener(new SaveNewEntryActionListener(newEntryFrame));
		        newEntryFrame.addButtonDeleteWorkoutActionList(new ButtonDeleteWorkoutActionListener());
				newEntryFrame.setVisible(true);	

		        }
		   }
		 				
	}
	
	
	public class  SaveNewEntryActionListener implements ActionListener{
		NewEntry newEntryFrame;
		public SaveNewEntryActionListener(NewEntry newEntryFrame) {
			this.newEntryFrame = newEntryFrame;
		}
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			int newIdx = 0;

			if (newEntryFrame != null) {
				selectedWorkout = newEntryFrame.getNewWorkoutEntry();

				try {
					System.out.println("save");

					newIdx = DataHandler.getInstance().saveWorkout(
							selectedWorkout);
					currentUser.setWorkouts(dh.loadUserWorkouts(currentUser
							.getId()));

					selectedWorkout = null;
				} catch (SQLException | SQLQueryException
						| SQLDriverNotFoundException | SQLConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mView.refreshTableData(currentUser.getWorkouts());
			}
		}

	}

	public class CloseListener implements WindowListener, ActionListener {
	    		
		private void handleCloseAction(){
			System.out.println("ich wurde geschlossen");
			try {
				dh.saveUserProfile(currentUser);
			} catch (SQLException | SQLQueryException e1) {
				mView.showError("Fehler beim Speichern! das ist nicht gut!");
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	    	finally{
	    		mView.setVisible(false);
	    		try {
					dh.cleanUp();
				} catch (SQLConnectionException e) {
					e.printStackTrace();
				}
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
