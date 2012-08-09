package de.dhbw.sportcontroll.ui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class ConfigProfil extends JPanel {
	private JButton B_OK;
	private JButton B_Cancel;
	private JLabel L_Gender;
	private JLabel L_Age;
	private JLabel L_Size;
	private JLabel L_Birthdate;
	private JLabel L_Name;
	private JTextField TF_Name;
	private ButtonGroup OB_Gender;
	private JRadioButton RB_gender_w;
	private JRadioButton RB_gender_m;
	private AbstractAction closeAction;
	private AbstractAction OKAction;
	private JTextField TF_Size;
	private JTextField TF_Birthdate;
	
	
//	/**
//	* Auto-generated main method to display this JFrame
//	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				ConfigProfil inst = new ConfigProfil();
//				inst.setLocation(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public ConfigProfil() {
		super(new AnchorLayout());
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			
			
			{
				
				
				L_Age = new JLabel();
				L_Age.setText("$age$");
					
				RB_gender_w = new JRadioButton();
				this.add(L_Age, new AnchorConstraint(158, 816, 219, 735, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(RB_gender_w, new AnchorConstraint(524, 524, 601, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				RB_gender_w.setText("Weiblich");
				RB_gender_w.setPreferredSize(new java.awt.Dimension(77, 20));
				getOB_Gender().add(RB_gender_w);
			}
			{
				RB_gender_m = new JRadioButton();
				this.add(RB_gender_m, new AnchorConstraint(444, 524, 520, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				RB_gender_m.setText("mönnlich");
				RB_gender_m.setPreferredSize(new java.awt.Dimension(77, 20));
				getOB_Gender().add(RB_gender_m);
			}
			{
				L_Name = new JLabel();
				this.add(L_Name, new AnchorConstraint(78, 292, 139, 74, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Name.setText("Name:");
				L_Name.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				TF_Name = new JTextField();
				this.add(TF_Name, new AnchorConstraint(66, 673, 154, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Name.setText("$Name$");
				TF_Name.setPreferredSize(new java.awt.Dimension(134, 23));
			}
			{
				B_OK = new JButton();
				this.add(B_OK, new AnchorConstraint(891, 654, 979, 381, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_OK.setText("OK");
				B_OK.setPreferredSize(new java.awt.Dimension(105, 23));
				B_OK.setAction(getOKAction());
			}
			{
				B_Cancel = new JButton();
				this.add(B_Cancel, new AnchorConstraint(891, 941, 979, 667, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_Cancel.setText("Abbrechen");
				B_Cancel.setPreferredSize(new java.awt.Dimension(105, 23));
				B_Cancel.setAction(getCloseAction());
			}
			{
				TF_Birthdate = new JTextField();
				this.add(TF_Birthdate, new AnchorConstraint(181, 673, 269, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Birthdate.setText("$birthdate$");
				TF_Birthdate.setPreferredSize(new java.awt.Dimension(134, 23));
			}
			{
				TF_Size = new JTextField();
				this.add(TF_Size, new AnchorConstraint(311, 673, 398, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Size.setPreferredSize(new java.awt.Dimension(134, 23));
				TF_Size.setText("$size$");
			}
			{
				L_Birthdate = new JLabel();
				this.add(L_Birthdate, new AnchorConstraint(192, 292, 253, 74, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Birthdate.setText("Geburtsdatum:");
				L_Birthdate.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				L_Size = new JLabel();
				this.add(L_Size, new AnchorConstraint(322, 292, 383, 74, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Size.setText("Körpergröße:");
				L_Size.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{

				
				
				L_Age = new JLabel();
				L_Age.setText("Alter:");
				L_Age.setPreferredSize(new java.awt.Dimension(84, 16));
					
				
				
				L_Gender = new JLabel();
				this.add(L_Gender, new AnchorConstraint(440, 292, 501, 74, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(L_Age, new AnchorConstraint(78, 923, 139, 704, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Gender.setText("Geschlecht:");
				L_Gender.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			
			setSize(400, 300);
		} catch (Exception e) {
//	Errorcode
			JOptionPane.showMessageDialog(null,
                    "Error 999",
                    "ConfigProfil.java konnte nicht gefunden/gestartet werden",                                       
                    JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
// begin Actions
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
			closeAction = new AbstractAction("Schließen", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return closeAction;
	}
	
	

	private ButtonGroup getOB_Gender() {
		if(OB_Gender == null) {
			OB_Gender = new ButtonGroup();
			

		}
		return OB_Gender;
	}
	
	

}
