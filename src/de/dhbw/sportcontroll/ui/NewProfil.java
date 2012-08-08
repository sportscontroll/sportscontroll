package de.dhbw.sportcontroll.ui;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

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
public class NewProfil extends javax.swing.JFrame {
	private JButton B_OK;
	private JButton B_Cancel;
	private AbstractAction OKAction;
	private ButtonGroup Gender;
	private JRadioButton RB_gender_w;
	private JRadioButton RB_gender_m;
	private JLabel L_Gender;
	private ButtonGroup OB_Gender;
	private JLabel L_Age;
	private ButtonGroup buttonGroup1;
	private AbstractAction closeAction;
	private JLabel L_Size;
	private JTextField TF_Size;
	private JLabel L_Birthday;
	private JTextField jTextField1;
	private JLabel L_Name;
	private JTextField TF_Name;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ConfigProfil inst = new ConfigProfil();
				//inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewProfil() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Neues Profil anlegen");
			
			
			{
				RB_gender_w = new JRadioButton();
				getContentPane().add(getJLabel4x(), new AnchorConstraint(158, 816, 219, 735, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(RB_gender_w, new AnchorConstraint(524, 524, 601, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				RB_gender_w.setText("Weiblich");
				RB_gender_w.setPreferredSize(new java.awt.Dimension(77, 20));
				getOB_Gender().add(RB_gender_w);
			}
			{
				RB_gender_m = new JRadioButton();
				getContentPane().add(RB_gender_m, new AnchorConstraint(444, 524, 520, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				RB_gender_m.setText("männlich");
				RB_gender_m.setPreferredSize(new java.awt.Dimension(77, 20));
				getOB_Gender().add(RB_gender_m);
			}
			{
				L_Name = new JLabel();
				getContentPane().add(L_Name, new AnchorConstraint(78, 292, 139, 74, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Name.setText("Name:");
				L_Name.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				TF_Name = new JTextField();
				getContentPane().add(TF_Name, new AnchorConstraint(66, 673, 154, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Name.setText("$Name$");
				TF_Name.setPreferredSize(new java.awt.Dimension(134, 23));
			}
			{
				B_OK = new JButton();
				getContentPane().add(B_OK, new AnchorConstraint(891, 654, 979, 381, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_OK.setText("OK");
				B_OK.setPreferredSize(new java.awt.Dimension(105, 23));
				B_OK.setAction(getOKAction());
			}
			{
				B_Cancel = new JButton();
				getContentPane().add(B_Cancel, new AnchorConstraint(891, 941, 979, 667, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_Cancel.setText("Abbrechen");
				B_Cancel.setPreferredSize(new java.awt.Dimension(105, 23));
				B_Cancel.setAction(getCloseAction());
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, new AnchorConstraint(181, 673, 269, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField1.setText("$birthday$");
				jTextField1.setPreferredSize(new java.awt.Dimension(134, 23));
			}
			{
				L_Birthday = new JLabel();
				getContentPane().add(L_Birthday, new AnchorConstraint(188, 292, 250, 74, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Birthday.setText("Geburtsdatum:");
				L_Birthday.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				TF_Size = new JTextField();
				getContentPane().add(TF_Size, new AnchorConstraint(311, 673, 398, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				TF_Size.setPreferredSize(new java.awt.Dimension(134, 23));
				TF_Size.setText("$size$");
			}
			{
				L_Size = new JLabel();
				getContentPane().add(L_Size, new AnchorConstraint(322, 292, 383, 74, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Size.setText("Körpergröße:");
				L_Size.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			{
				L_Gender = new JLabel();
				getContentPane().add(L_Gender, new AnchorConstraint(440, 292, 501, 74, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(getJLabel4(), new AnchorConstraint(78, 923, 139, 704, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Gender.setText("Geschlecht:");
				L_Gender.setPreferredSize(new java.awt.Dimension(84, 16));
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
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
			closeAction = new AbstractAction("Schließen", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return closeAction;
	}
	
	private JLabel getJLabel4() {
		if(L_Age == null) {
			L_Age = new JLabel();
			L_Age.setText("Alter:");
			L_Age.setPreferredSize(new java.awt.Dimension(84, 16));
		}
		return L_Age;
	}

	private ButtonGroup getOB_Gender() {
		if(OB_Gender == null) {
			OB_Gender = new ButtonGroup();
			

		}
		return OB_Gender;
	}
	
	private JLabel getJLabel4x() {
		if(L_Age == null) {
			L_Age = new JLabel();
			L_Age.setText("$age$");
		}
		return L_Age;
	}

}
