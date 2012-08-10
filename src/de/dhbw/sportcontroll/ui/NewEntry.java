package de.dhbw.sportcontroll.ui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import de.dhbw.sportcontroll.dataobjects.Date;
import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.db.DataHandler;
import de.dhbw.sportcontroll.exceptions.SQLConnectionException;
import de.dhbw.sportcontroll.exceptions.SQLDriverNotFoundException;
import de.dhbw.sportcontroll.main.Test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

/**
 * This Frame is for the new entry's workout, weight, sport discipline
 * @author Katja.Kaiser
 */

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NewEntry extends javax.swing.JDialog {
	private JTabbedPane TP_New;
	private JPanel P_NewEntry;
	private JButton B_Cancel;
	private JLabel L_Duration;
	private JLabel jLabel2;
	private JTextField TF_DateW;
	private JCheckBox CB_DistanceSport;
	private JTextField TB_Distance;
	private JLabel L_Distance;
	private JTextField TB_CaloryConsumption;
	private JLabel L_Weather;
	private JLabel L_MET;
	private JScrollPane SP_Note;
	private AbstractAction DisciplineAction;
	private JButton B_SaveNewWei;
	private JButton B_SaveNewDis;
	private JButton B_SaveNewWork;
	private JTextArea TA_Note;
	private JLabel L_Note;
	private JComboBox CB_Weather;
	private JComboBox CB_Feeling;
	private JLabel L_Feeling;
	private JLabel L_HeartRate;
	private JTextField TF_HeartRate;
	private JLabel L_caloryConsumption;
	private JTextField TB_Sportart;
	private JLabel jLabel1;
	private JTextField TF_Date;
	private JLabel L_Date;
	private JTextField TF_Duration;
	private JComboBox CB_Discipline;
	private JLabel L_Discipline;
	private JTextField TF_Location;
	private JLabel L_Location;
	private JTextField TB_Weight;
	private JLabel L_Weight;
	private JPanel P_NewWeight;
	private JPanel P_NewDiscipline;
	private AbstractAction OKAction;
	private AbstractAction closeAction;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				NewEntry inst = new NewEntry(frame);
				inst.setVisible(true);
		
			}
		});
	}
	
	public NewEntry(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setTitle("Neu");
			{
				TP_New = new JTabbedPane();
				getContentPane().add(TP_New, new AnchorConstraint(1, 1001, 906, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TP_New.setPreferredSize(new java.awt.Dimension(384, 237));
				{
					P_NewEntry = new JPanel();
					TP_New.addTab("Eintrag", null, P_NewEntry, null);
					P_NewEntry.setPreferredSize(new java.awt.Dimension(517, 488));
					P_NewEntry.add(getL_Discipline());
					P_NewEntry.add(getCB_Discipline());
					P_NewEntry.add(getL_Duration());
					P_NewEntry.add(getTF_Duration());
					P_NewEntry.add(getL_Date());
					P_NewEntry.add(getTF_Date());
					P_NewEntry.add(getL_Distance());
					P_NewEntry.add(getTB_Distance());
					P_NewEntry.add(getL_Location());
					P_NewEntry.add(getTF_Location());
					P_NewEntry.add(getL_HeartRate());
					P_NewEntry.add(getTF_HeartRate());
					P_NewEntry.add(getL_Feeling());
					P_NewEntry.add(getCB_Feeling());
					P_NewEntry.add(getL_Weather());
					P_NewEntry.add(getCB_Weather());
					P_NewEntry.add(getL_Note());
					P_NewEntry.add(getSP_Note());
					P_NewEntry.add(getB_SaveNewWork());
					{
						B_Cancel = new JButton();
						P_NewEntry.add(B_Cancel);
						B_Cancel.setText("Abbrechen");
						B_Cancel.setAction(getCloseAction());
						B_Cancel.setPreferredSize(new java.awt.Dimension(160, 50));
					}
				}
				{
					P_NewDiscipline = new JPanel();
					TP_New.addTab("Sportart", null, P_NewDiscipline, null);
					P_NewDiscipline.setPreferredSize(new java.awt.Dimension(379, 188));
					P_NewDiscipline.add(getJLabel1());
					P_NewDiscipline.add(getTB_Sportart());
					P_NewDiscipline.add(getL_caloryConsumption());
					P_NewDiscipline.add(getTB_CaloryConsumption());
					P_NewDiscipline.add(getCB_DistanceSport());
					P_NewDiscipline.add(getL_MET());
					P_NewDiscipline.add(getB_SaveNewDis());
				}
				{
					P_NewWeight = new JPanel();
					TP_New.addTab("Gewicht", null, P_NewWeight, null);
					P_NewWeight.add(getJLabel2());
					P_NewWeight.add(getJTextField1());
					P_NewWeight.add(getL_Weight());
					P_NewWeight.add(getTB_Weight());
					P_NewWeight.add(getB_SaveNewWei());
				}
			}
			this.setSize(538, 554);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private AbstractAction getOKAction() {
		if(OKAction == null) {
			OKAction = new AbstractAction("OK", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					
					//read-out weight, date, 
					String edate = TF_Date.getText();
					String edatew= TF_DateW.getText();
					String eduration= TF_Duration.getText();
					String eHeartRate= TF_HeartRate.getText();
					String eLocation= TF_Location.getText();
				//  Boolean bX = CB_DistanceSport(true);
					String ediscipline =CB_Discipline.getToolTipText();
					String efeeling = CB_Feeling.getToolTipText();
					String ecaloryCon= TB_CaloryConsumption.getText();
					String enote =TA_Note.getText() ; 
					String eweather = CB_Weather.getToolTipText();
					String eweight = TB_Weight.getText(); 
					
					setVisible(false);
					
				}
			};
		}
		return OKAction;
	}
	
	private AbstractAction getCloseAction() {
		if(closeAction == null) {
			closeAction = new AbstractAction("Schließen", null) {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			};
		}
		return closeAction;
	}
	
	private JLabel getL_Location() {
		if(L_Location == null) {
			L_Location = new JLabel();
			L_Location.setText("Ort:");
			L_Location.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return L_Location;
	}
	
	private JTextField getTF_Location() {
		if(TF_Location == null) {
			TF_Location = new JTextField();
			TF_Location.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return TF_Location;
	}

	private JLabel getL_Discipline() {
		if(L_Discipline == null) {
			L_Discipline = new JLabel();
			L_Discipline.setText("Sportart:");
			L_Discipline.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return L_Discipline;
	}
	//ComboBox erhält Ihnalte aus DB :)
	
	private JComboBox getCB_Discipline() throws SQLException, SQLDriverNotFoundException, SQLConnectionException {
		if(CB_Discipline == null) {
			ComboBoxModel CB_DisciplineModel = 
					new DefaultComboBoxModel(
							new String[] { "Auswahl" });							
			CB_Discipline = new JComboBox();
			CB_Discipline.setModel(CB_DisciplineModel);
			CB_Discipline.setPreferredSize(new java.awt.Dimension(187, 30));
			CB_Discipline.setAction(getDisciplineAction());

			ArrayList<SportDiscipline> sdList = DataHandler.getInstance().loadAllSportDisciplines();
			
			for (SportDiscipline sd : sdList) {
				
			     CB_Discipline.addItem(sd.getName());			 
			}			 
					
		}
		return CB_Discipline;
			 
		
	}
	
	private JLabel getL_Duration() {
		if(L_Duration == null) {
			L_Duration = new JLabel();
			L_Duration.setText("Dauer:");
			L_Duration.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return L_Duration;
	}
	
	private JTextField getTF_Duration() {
		if(TF_Duration == null) {
			TF_Duration = new JTextField();
			TF_Duration.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return TF_Duration;
	}
	
	private JLabel getL_Date() {
		if(L_Date == null) {
			L_Date = new JLabel();
			L_Date.setText("Datum:");
			L_Date.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return L_Date;
	}
	/**
	 * TODO Date swap 
	 * 
	 */
	private JTextField getTF_Date() {
		if(TF_Date == null) {
			TF_Date = new JTextField();
			TF_Date.setText(new Date(System.currentTimeMillis()).getDateGreLiEnd());			
			TF_Date.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return TF_Date;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Sportart:");
			jLabel1.setPreferredSize(new java.awt.Dimension(169, 50));
		}
		return jLabel1;
	}
	
	private JTextField getTB_Sportart() {
		if(TB_Sportart == null) {
			TB_Sportart = new JTextField();
			TB_Sportart.setPreferredSize(new java.awt.Dimension(169, 50));
		}
		return TB_Sportart;
	}
	
	private JLabel getL_caloryConsumption() {
		if(L_caloryConsumption == null) {
			L_caloryConsumption = new JLabel();
			L_caloryConsumption.setText("Kalorienwert / MET");
			L_caloryConsumption.setPreferredSize(new java.awt.Dimension(169, 50));
		}
		return L_caloryConsumption;
	}
	
	private JTextField getTB_CaloryConsumption() {
		if(TB_CaloryConsumption == null) {
			TB_CaloryConsumption = new JTextField();
			TB_CaloryConsumption.setPreferredSize(new java.awt.Dimension(169, 50));
		}
		return TB_CaloryConsumption;
	}
	
	private JLabel getL_Distance() {
		if(L_Distance == null) {
			L_Distance = new JLabel();
			L_Distance.setText("Distanz:");
			L_Distance.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return L_Distance;
	}
	
	private JTextField getTB_Distance() {
		if(TB_Distance == null) {
			TB_Distance = new JTextField();
			TB_Distance.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return TB_Distance;
	}

	private JCheckBox getCB_DistanceSport() {
		if(CB_DistanceSport == null) {
			CB_DistanceSport = new JCheckBox();
			CB_DistanceSport.setText("Streckensport");
			CB_DistanceSport.setPreferredSize(new java.awt.Dimension(180, 50));
		}
		return CB_DistanceSport;
	}
	
	private JTextField getJTextField1() {
		if(TF_DateW == null) {
			TF_DateW = new JTextField();
			TF_DateW.setText(new Date(System.currentTimeMillis()).getDateGreLiEnd());
			TF_DateW.setPreferredSize(new java.awt.Dimension(193, 59));
		}
		return TF_DateW;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Datum:");
			jLabel2.setPreferredSize(new java.awt.Dimension(193, 59));
		}
		return jLabel2;
	}
	
	private JLabel getL_Weight() {
		if(L_Weight == null) {
			L_Weight = new JLabel();
			L_Weight.setText("Gewicht:");
			L_Weight.setPreferredSize(new java.awt.Dimension(193, 59));
		}
		return L_Weight;
	}
	
	private JTextField getTB_Weight() {
		if(TB_Weight == null) {
			TB_Weight = new JTextField();
			TB_Weight.setPreferredSize(new java.awt.Dimension(193, 59));
		}
		return TB_Weight;
	}
	
	private JTextField getTF_HeartRate() {
		if(TF_HeartRate == null) {
			TF_HeartRate = new JTextField();
			TF_HeartRate.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return TF_HeartRate;
	}
	
	private JLabel getL_HeartRate() {
		if(L_HeartRate == null) {
			L_HeartRate = new JLabel();
			L_HeartRate.setText("Herzfrequenz:");
			L_HeartRate.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return L_HeartRate;
	}
	
	private JLabel getL_Feeling() {
		if(L_Feeling == null) {
			L_Feeling = new JLabel();
			L_Feeling.setText("Zustand:");
			L_Feeling.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return L_Feeling;
	}
	
	private JComboBox getCB_Feeling() {
		if(CB_Feeling == null) {
			ComboBoxModel CB_FeelingModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
			CB_Feeling = new JComboBox();
			CB_Feeling.setModel(CB_FeelingModel);
			CB_Feeling.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return CB_Feeling;
	}
	
	private JLabel getL_Weather() {
		if(L_Weather == null) {
			L_Weather = new JLabel();
			L_Weather.setText("Wetter:");
			L_Weather.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return L_Weather;
	}
	
	private JComboBox getCB_Weather() {
		if(CB_Weather == null) {
			ComboBoxModel CB_WeatherModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
			CB_Weather = new JComboBox();
			CB_Weather.setModel(CB_WeatherModel);
			CB_Weather.setPreferredSize(new java.awt.Dimension(187, 30));
		}
		return CB_Weather;
	}
	
	private JLabel getL_Note() {
		if(L_Note == null) {
			L_Note = new JLabel();
			L_Note.setText("Bemerkungen:");
			L_Note.setPreferredSize(new java.awt.Dimension(380, 19));
		}
		return L_Note;
	}
	
	private JTextArea getTA_Note() {
		if(TA_Note == null) {
			TA_Note = new JTextArea();
			TA_Note.setText("...");
			TA_Note.setPreferredSize(new java.awt.Dimension(439, 51));
		}
		return TA_Note;
	}
	
	private JButton getB_SaveNewWork() {
		if(B_SaveNewWork == null) {
			B_SaveNewWork = new JButton();
			B_SaveNewWork.setText("Speichern");
			B_SaveNewWork.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/save.gif")));
			B_SaveNewWork.setPreferredSize(new java.awt.Dimension(160, 50));
			}
		return B_SaveNewWork;
	}
	
	private JButton getB_SaveNewDis() {
		if(B_SaveNewDis == null) {
			B_SaveNewDis = new JButton();
			B_SaveNewDis.setText("Speichern");
			B_SaveNewDis.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/save.gif")));
			B_SaveNewDis.setPreferredSize(new java.awt.Dimension(160, 50));
		}
		return B_SaveNewDis;
	}
	
	private JButton getB_SaveNewWei() {
		if(B_SaveNewWei == null) {
			B_SaveNewWei = new JButton();
			B_SaveNewWei.setText("Speichern");
			B_SaveNewWei.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/save.gif")));
			B_SaveNewWei.setPreferredSize(new java.awt.Dimension(160, 50));
		}
		return B_SaveNewWei;
	}		
	
	private AbstractAction getDisciplineAction() {
		if(DisciplineAction == null) {
			DisciplineAction = new AbstractAction("Aktion", null) {
				public void actionPerformed(ActionEvent evt) {
					String str = (String)CB_Discipline.getSelectedItem();
				 	 System.out.println(str);
				 	 //TODO output in Übergabe
				}
			};
		}
		return DisciplineAction;
	}
	
	private JScrollPane getSP_Note() {
		if(SP_Note == null) {
			SP_Note = new JScrollPane();
			SP_Note.setPreferredSize(new java.awt.Dimension(439, 51));
			SP_Note.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			SP_Note.setViewportView(getTA_Note());
		}
		return SP_Note;
	}
	
	private JLabel getL_MET() {
		if(L_MET == null) {
			L_MET = new JLabel();
			L_MET.setText("<html><h3>Was ist MET?</h3><br>" +
					"<body> MET steht für Metabolisches Äquivalent. Definiert als die <br>" +
					"Sauerstoffaufnahme beim Sitzen. Diese Sauerstoffaufnahme beträgt" +
					"etwa 3.5 ml/kg/min. Da der Kalorienverbrauch direkt von der" +
					"Sauerstoffaufnahme abhängig ist kann man ein MET auch als " +
					"Kalorienverbrauchsformel angeben: <br> <h4>1 kcal/kg/Stunde</h4> <br>" +
					"</body></html>");
			L_MET.setPreferredSize(new java.awt.Dimension(388, 190));
			L_MET.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			L_MET.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/info.gif")));
		}
		return L_MET;
	}

}
