package de.dhbw.sportcontroll.ui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


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
	private JTextField jTextField1;
	private JCheckBox CB_DistanceSport;
	private JTextField TB_Distance;
	private JLabel L_Distance;
	private JTextField TB_CaloryConsumption;
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
	private JButton OK;
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
					P_NewEntry.setPreferredSize(new java.awt.Dimension(379, 236));
					P_NewEntry.add(getL_Location());
					P_NewEntry.add(getTF_Location());
					P_NewEntry.add(getCB_Discipline());
					P_NewEntry.add(getL_Discipline());
					P_NewEntry.add(getL_Duration());
					P_NewEntry.add(getTF_Duration());
					P_NewEntry.add(getL_Date());
					P_NewEntry.add(getTF_Date());
					P_NewEntry.add(getL_Distance());
					P_NewEntry.add(getTB_Distance());
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
				}
				{
					P_NewWeight = new JPanel();
					TP_New.addTab("Gewicht", null, P_NewWeight, null);
					P_NewWeight.add(getJLabel2());
					P_NewWeight.add(getJTextField1());
					P_NewWeight.add(getL_Weight());
					P_NewWeight.add(getTB_Weight());
				}
			}
			{
				OK = new JButton();
				getContentPane().add(OK, new AnchorConstraint(906, 720, 1001, 480, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				OK.setText("OK");
				OK.setAction(getOKAction());
				OK.setPreferredSize(new java.awt.Dimension(92,25));
			}
			{
				B_Cancel = new JButton();
				getContentPane().add(B_Cancel, new AnchorConstraint(906, 972, 1001, 733, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_Cancel.setText("Abbrechen");
				B_Cancel.setAction(getCloseAction());
				B_Cancel.setPreferredSize(new java.awt.Dimension(92,25));
			}
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private AbstractAction getOKAction() {
		if(OKAction == null) {
			OKAction = new AbstractAction("OK", null) {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			};
		}
		return OKAction;
	}
	
	private AbstractAction getCloseAction() {
		if(closeAction == null) {
			closeAction = new AbstractAction("Schlieﬂen", null) {
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
			L_Location.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return L_Location;
	}
	
	private JTextField getTF_Location() {
		if(TF_Location == null) {
			TF_Location = new JTextField();
			TF_Location.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return TF_Location;
	}

	private JLabel getL_Discipline() {
		if(L_Discipline == null) {
			L_Discipline = new JLabel();
			L_Discipline.setText("Sportart:");
			L_Discipline.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return L_Discipline;
	}
	private JComboBox getCB_Discipline() {
		if(CB_Discipline == null) {
			ComboBoxModel CB_DisciplineModel = 
					new DefaultComboBoxModel(
							new String[] { "TestSchwimmen", "TestRadfahren","TestLaufen" });
			CB_Discipline = new JComboBox();
			CB_Discipline.setModel(CB_DisciplineModel);
			CB_Discipline.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return CB_Discipline;
	}
	
	private JLabel getL_Duration() {
		if(L_Duration == null) {
			L_Duration = new JLabel();
			L_Duration.setText("Dauer");
			L_Duration.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return L_Duration;
	}
	
	private JTextField getTF_Duration() {
		if(TF_Duration == null) {
			TF_Duration = new JTextField();
			TF_Duration.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return TF_Duration;
	}
	
	private JLabel getL_Date() {
		if(L_Date == null) {
			L_Date = new JLabel();
			L_Date.setText("Datum");
			L_Date.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return L_Date;
	}
	
	private JTextField getTF_Date() {
		if(TF_Date == null) {
			TF_Date = new JTextField();
			TF_Date.setText("$TODAY$");
			TF_Date.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return TF_Date;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Sportart:");
			jLabel1.setPreferredSize(new java.awt.Dimension(152,35));
		}
		return jLabel1;
	}
	
	private JTextField getTB_Sportart() {
		if(TB_Sportart == null) {
			TB_Sportart = new JTextField();
			TB_Sportart.setPreferredSize(new java.awt.Dimension(152, 35));
		}
		return TB_Sportart;
	}
	
	private JLabel getL_caloryConsumption() {
		if(L_caloryConsumption == null) {
			L_caloryConsumption = new JLabel();
			L_caloryConsumption.setText("Kalorienwert");
			L_caloryConsumption.setPreferredSize(new java.awt.Dimension(152, 35));
		}
		return L_caloryConsumption;
	}
	
	private JTextField getTB_CaloryConsumption() {
		if(TB_CaloryConsumption == null) {
			TB_CaloryConsumption = new JTextField();
			TB_CaloryConsumption.setPreferredSize(new java.awt.Dimension(152, 35));
		}
		return TB_CaloryConsumption;
	}
	
	private JLabel getL_Distance() {
		if(L_Distance == null) {
			L_Distance = new JLabel();
			L_Distance.setText("Distanz");
			L_Distance.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return L_Distance;
	}
	
	private JTextField getTB_Distance() {
		if(TB_Distance == null) {
			TB_Distance = new JTextField();
			TB_Distance.setPreferredSize(new java.awt.Dimension(152, 31));
		}
		return TB_Distance;
	}

	private JCheckBox getCB_DistanceSport() {
		if(CB_DistanceSport == null) {
			CB_DistanceSport = new JCheckBox();
			CB_DistanceSport.setText("Streckensport");
			CB_DistanceSport.setPreferredSize(new java.awt.Dimension(152, 35));
		}
		return CB_DistanceSport;
	}
	
	private JTextField getJTextField1() {
		if(jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("$TODAY$");
			jTextField1.setPreferredSize(new java.awt.Dimension(148, 35));
		}
		return jTextField1;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Datum:");
			jLabel2.setPreferredSize(new java.awt.Dimension(148, 35));
		}
		return jLabel2;
	}
	
	private JLabel getL_Weight() {
		if(L_Weight == null) {
			L_Weight = new JLabel();
			L_Weight.setText("Gewicht:");
			L_Weight.setPreferredSize(new java.awt.Dimension(148, 35));
		}
		return L_Weight;
	}
	
	private JTextField getTB_Weight() {
		if(TB_Weight == null) {
			TB_Weight = new JTextField();
			TB_Weight.setPreferredSize(new java.awt.Dimension(148, 35));
		}
		return TB_Weight;
	}

}
