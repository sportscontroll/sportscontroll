
package de.dhbw.sportcontroll.ui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import de.dhbw.sportcontroll.controller.Calculate;
import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.db.DataHandler;
import de.dhbw.sportcontroll.exceptions.SQLConnectionException;
import de.dhbw.sportcontroll.exceptions.SQLDriverNotFoundException;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
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
/**
 * @author Katja.Kaiser
 * GUI of Calc for BMI, BasicCalorie and Calorie per Discipline
* This code was edited using CloudGarden's Jigloo
* SWT/Swing GUI Builder.
* 
* 
*/
public class Calc extends JPanel {
	
	private JLabel L_Gender;
	private JLabel L_Output;
	private JLabel L_Age;
	private JComboBox CB_Discipline;
	private JLabel L_discipline;
	private JTextField TF_duration;
	private JLabel L_duration;
	private ButtonGroup OB_Gender;
	private JRadioButton RB_gender_w;
	private JRadioButton RB_gender_m;
	private AbstractAction calorieAction;
	private AbstractAction BasicKalAction;
	private AbstractAction CalcBMIAction;
	private JLabel L_Weight;
	private JLabel L_Birthdate;
	private JLabel L_Size;
	private JButton B_Calorie;
	private JButton B_BasicKal;
	private JButton B_BMI;
	private JTextField TF_Birthdate;
	private JTextField TF_Size;
	private JTextField TF_Weight;
	private JLabel L_CalcPic;
	private double iweight;

//	/**
//	* Auto-generated main method to display this JFrame
//	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				Calc inst = new Calc();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public Calc() {
		super(new AnchorLayout());
		initGUI();
	}
	
	private void initGUI() {
		try {
			//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			//getContentPane().setLayout(thisLayout);
			//this.setTitle("Rechner");
			{
			
				L_Output = new JLabel();
				this.add(getL_CalcPic(), new AnchorConstraint(102, 956, 684, 716, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					this.add(getCB_Discipline(), new AnchorConstraint(708, 669, 782, 320, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(getL_discipline(), new AnchorConstraint(715, 289, 778, 69, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					this.add(getTF_duration(), new AnchorConstraint(584, 669, 661, 320, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(getL_duration(), new AnchorConstraint(605, 289, 668, 69, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					this.add(L_Output, new AnchorConstraint(457, 917, 534, 695, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Output.setPreferredSize(new java.awt.Dimension(126, 26));

			}
//			{
//				L_Age = new JLabel();
//				getContentPane().add(L_Age, new AnchorConstraint(169, 899, 230, 680, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
//				L_Age.setPreferredSize(new java.awt.Dimension(84, 16));
//				int iage = Calculate.CalcAge(TF_Birthdate.getText());
//				String sage = Integer.toString( iage);
//				L_Age.setText(sage);
//			}
			{
				TF_Weight = new JTextField();
				getContentPane().add(TF_Weight, new AnchorConstraint(75, 665, 161, 316, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Weight.setPreferredSize(new java.awt.Dimension(192, 26));
				TF_Weight.setText("80");
				//double iweight = Double.parseDouble(TF_Weight.getText());
			}
			{
				L_Weight = new JLabel();
				getContentPane().add(L_Weight, new AnchorConstraint(85, 289, 145, 69, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Weight.setText("Gewicht in kg:");
				L_Weight.setPreferredSize(new java.awt.Dimension(121, 18));
			}
			{
				B_Calorie = new JButton();
				getContentPane().add(B_Calorie, new AnchorConstraint(821, 979, 908, 674, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_Calorie.setText("Kalorien");
				B_Calorie.setPreferredSize(new java.awt.Dimension(168, 26));
				B_Calorie.setAction(getCalorieAction());
			}
			{
				B_BasicKal = new JButton();
				getContentPane().add(B_BasicKal, new AnchorConstraint(821, 674, 908, 362, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_BasicKal.setText("Grundumsatz");
				B_BasicKal.setPreferredSize(new java.awt.Dimension(172, 26));
				B_BasicKal.setAction(getBasicKalAction());
			}
			{
				B_BMI = new JButton();
				getContentPane().add(B_BMI, new AnchorConstraint(821, 363, 908, 48, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_BMI.setText("BMI");
				B_BMI.setPreferredSize(new java.awt.Dimension(174, 26));
				B_BMI.setAction(getCalcBMIAction());
			}
			{
				L_Gender = new JLabel();
				getContentPane().add(L_Gender, new AnchorConstraint(468, 289, 531, 69, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Gender.setText("Geschlecht:");
				L_Gender.setPreferredSize(new java.awt.Dimension(121, 19));
			}
			{
				TF_Size = new JTextField();
				getContentPane().add(TF_Size, new AnchorConstraint(333, 665, 421, 316, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Size.setText("196");
				TF_Size.setPreferredSize(new java.awt.Dimension(134,23));
	//			double isize = Double.parseDouble(TF_Size.getText());
			}
			{
				L_Size = new JLabel();
				getContentPane().add(L_Size, new AnchorConstraint(348, 289, 411, 69, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Size.setText("Körpergröße in cm:");
				L_Size.setPreferredSize(new java.awt.Dimension(121, 19));
			}
			{
				L_Birthdate = new JLabel();
				getContentPane().add(L_Birthdate, new AnchorConstraint(211, 289, 271, 69, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Birthdate.setText("Geburtsdatum:");
				L_Birthdate.setPreferredSize(new java.awt.Dimension(121, 18));
			}
			{
				TF_Birthdate = new JTextField();
				getContentPane().add(TF_Birthdate, new AnchorConstraint(200, 665, 288, 316, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(getRB_gender_m(), new AnchorConstraint(428, 510, 575, 316, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(getRB_gender_w(), new AnchorConstraint(428, 665, 575, 530, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Birthdate.setText("20.12.1985");
				TF_Birthdate.setPreferredSize(new java.awt.Dimension(134,23));

			}
			
			this.setSize(567, 338);
		} catch (Exception e) {
		    
			JOptionPane.showMessageDialog(null,
                    "Error",
                    "Calc.java konnte nicht gefunden/gestartet werden",                                       
                    JOptionPane.WARNING_MESSAGE);
			
			e.printStackTrace();
		}
	}
	
	private JPanel getContentPane() {
		
		return this;
	}

	private AbstractAction getCalcBMIAction() {
		if(CalcBMIAction == null) {
			CalcBMIAction = new AbstractAction("BMI", null) {
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String esize = TF_Size.getText();
					String eweight = TF_Weight.getText();
					Calculate.bodyMassIndex(eweight, esize);		
				    
				}  
				
			};
		}
		return CalcBMIAction;
	}
	
	private AbstractAction getBasicKalAction() {
		if(BasicKalAction == null) {
			BasicKalAction = new AbstractAction("Grundumsatz", null) {
				public void actionPerformed(ActionEvent evt) {
					String esize = TF_Size.getText();
					String eweight = TF_Weight.getText();
					String ebirthdate = TF_Birthdate.getText();	   					
					Calculate.basicCalorie(eweight, esize, ebirthdate, RB_gender_w, RB_gender_m);//, OB_gender_m);
				}
			};
		}
		return BasicKalAction;
	}
	
	private AbstractAction getCalorieAction() {
		if(calorieAction == null) {
			calorieAction = new AbstractAction("Kalorien", null) {
				public void actionPerformed(ActionEvent evt) {
					String eweight = TF_Weight.getText();
					String eduration = TF_duration.getText();
					String ediscipline = (String)CB_Discipline.getSelectedItem();
					Calculate.calconsumption(eduration, ediscipline, eweight);
					
				}
			};
		}
		return calorieAction;
	}
	
	private JRadioButton getRB_gender_m() {
		if(RB_gender_m == null) {
			RB_gender_m = new JRadioButton();
			RB_gender_m.setText("männlich");
			RB_gender_m.setPreferredSize(new java.awt.Dimension(107, 44));
			RB_gender_m.isSelected();
			getOB_Gender().add(RB_gender_m);
		}
		return RB_gender_m;
	}
	
	private JRadioButton getRB_gender_w() {
		if(RB_gender_w == null) {
			RB_gender_w = new JRadioButton();
			RB_gender_w.setText("weiblich");
			RB_gender_w.setPreferredSize(new java.awt.Dimension(74, 44));
			RB_gender_w.isSelected();
			getOB_Gender().add(RB_gender_w);
		}
		return RB_gender_w;
	}
	
	private ButtonGroup getOB_Gender() {
		if(OB_Gender == null) {
			OB_Gender = new ButtonGroup();
		}
		return OB_Gender;
	}
	
	private JLabel getL_duration() {
		if(L_duration == null) {
			L_duration = new JLabel();
			L_duration.setText("Dauer in Stunden:");
			L_duration.setPreferredSize(new java.awt.Dimension(121, 19));
		}
		return L_duration;
	}
	
	private JTextField getTF_duration() {
		if(TF_duration == null) {
			TF_duration = new JTextField();
			TF_duration.setPreferredSize(new java.awt.Dimension(198, 26));
			TF_duration.setText("2");
		}
		return TF_duration;
	}
	
	private JLabel getL_discipline() {
		if(L_discipline == null) {
			L_discipline = new JLabel();
			L_discipline.setText("Sportart:");
			L_discipline.setPreferredSize(new java.awt.Dimension(121, 19));
		}
		return L_discipline;
	}
	
	private JComboBox getCB_Discipline() throws SQLException, SQLDriverNotFoundException, SQLConnectionException {
		if(CB_Discipline == null) {
			ComboBoxModel CB_DisciplineModel = 
					new DefaultComboBoxModel(
							new String[] { "Auswählen" });
			CB_Discipline = new JComboBox();
			CB_Discipline.setModel(CB_DisciplineModel);
			CB_Discipline.setPreferredSize(new java.awt.Dimension(198, 25));
		
			ArrayList<SportDiscipline> sdList = DataHandler.getInstance().loadAllSportDisciplines();
			
			for (SportDiscipline sd : sdList) {
				
			     CB_Discipline.addItem(sd.getName());			 
			}			 
			//ArrayList sDiscipline = DataHandler.loadAllSportDisciplines();
	
		}
		return CB_Discipline;
	}
	
	private JLabel getL_CalcPic() {
	
		if(L_CalcPic == null) {
			L_CalcPic = new JLabel();
			L_CalcPic.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/calculator.gif")));
			L_CalcPic.setPreferredSize(new java.awt.Dimension(136, 197));
		}
		return L_CalcPic;
	}

}
