package de.dhbw.sportcontroll.ui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class Calc extends javax.swing.JFrame {
	
	private JLabel L_Gender;
	private JLabel L_Output;
	private JLabel L_Age;
	private JLabel L_bezAge;	
	private JLabel L_Weight;
	private JLabel L_Birthdate;
	private JLabel L_Size;
	private JButton B_Kal;
	private JButton B_BasicKal;
	private JButton B_BMI;
	private JTextField TF_Birthdate;
	private JTextField TF_Size;
	private JTextField TF_Weight;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Calc inst = new Calc();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Calc() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setTitle("Rechner");
			{
				L_Output = new JLabel();
				getContentPane().add(L_Output, new AnchorConstraint(734, 889, 937, 66, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Output.setText("$out$");
				L_Output.setPreferredSize(new java.awt.Dimension(316, 53));
			}
			{
				L_Age = new JLabel();
				getContentPane().add(L_Age, new AnchorConstraint(169, 899, 230, 680, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Age.setText("$age$");
				L_Age.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				L_bezAge = new JLabel();
				getContentPane().add(L_bezAge, new AnchorConstraint(85, 899, 146, 680, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_bezAge.setText("Alter");
				L_bezAge.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				TF_Weight = new JTextField();
				getContentPane().add(TF_Weight, new AnchorConstraint(74, 498, 162, 316, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Weight.setPreferredSize(new java.awt.Dimension(70, 23));
			}
			{
				L_Weight = new JLabel();
				getContentPane().add(L_Weight, new AnchorConstraint(85, 285, 146, 66, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Weight.setText("Gewicht");
				L_Weight.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				B_Kal = new JButton();
				getContentPane().add(B_Kal, new AnchorConstraint(604, 989, 692, 677, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_Kal.setText("Kalorien");
				B_Kal.setPreferredSize(new java.awt.Dimension(140, 23));
			}
			{
				B_BasicKal = new JButton();
				getContentPane().add(B_BasicKal, new AnchorConstraint(604, 678, 692, 365, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_BasicKal.setText("Grundumsatz");
				B_BasicKal.setPreferredSize(new java.awt.Dimension(120, 23));
			}
			{
				B_BMI = new JButton();
				getContentPane().add(B_BMI, new AnchorConstraint(604, 367, 692, 54, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_BMI.setText("BMI");
				B_BMI.setPreferredSize(new java.awt.Dimension(140, 23));
			}
			{
				L_Gender = new JLabel();
				getContentPane().add(L_Gender, new AnchorConstraint(467, 284, 528, 65, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Gender.setText("Geschlecht:");
				L_Gender.setPreferredSize(new java.awt.Dimension(98, 16));
			}
			{
				TF_Size = new JTextField();
				getContentPane().add(TF_Size, new AnchorConstraint(333, 665, 421, 316, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Size.setText("196");
				TF_Size.setPreferredSize(new java.awt.Dimension(134,23));
			}
			{
				L_Size = new JLabel();
				getContentPane().add(L_Size, new AnchorConstraint(349, 284, 410, 65, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Size.setText("Körpergröße:");
				L_Size.setPreferredSize(new java.awt.Dimension(98, 16));
			}
			{
				L_Birthdate = new JLabel();
				getContentPane().add(L_Birthdate, new AnchorConstraint(211, 285, 272, 66, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Birthdate.setText("Geburtsdatum:");
				L_Birthdate.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				TF_Birthdate = new JTextField();
				getContentPane().add(TF_Birthdate, new AnchorConstraint(200, 665, 288, 316, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Birthdate.setText("20.12.1985");
				TF_Birthdate.setPreferredSize(new java.awt.Dimension(134,23));
			}
			pack();
			this.setSize(464, 300);
		} catch (Exception e) {
		    
			JOptionPane.showMessageDialog(null,
                    "Error",
                    "Calc.java konnte nicht gefunden/gestartet werden",                                       
                    JOptionPane.WARNING_MESSAGE);
			
			e.printStackTrace();
		}
	}

}
