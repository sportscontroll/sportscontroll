package de.dhbw.sportcontroll.ui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import de.dhbw.sportcontroll.dataobjects.UserProfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

/**
 * GUI ConfigProfile Change Name, Gender, size, birthdate, 
 * @author Katja.Kaiser
 * 
 */
public class ConfigProfil extends JPanel {
	private JButton B_OK;
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

				RB_gender_w = new JRadioButton();
				this.add(L_Age, new AnchorConstraint(175, 831, 235, 751, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Age.setPreferredSize(new java.awt.Dimension(32, 18));
				this.add(RB_gender_w, new AnchorConstraint(524, 524, 601, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				RB_gender_w.setText("weiblich");
				RB_gender_w.setPreferredSize(new java.awt.Dimension(77, 20));
				getOB_Gender().add(RB_gender_w);
			}
			{
				RB_gender_m = new JRadioButton();
				this.add(RB_gender_m, new AnchorConstraint(444, 524, 520, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				RB_gender_m.setText("männlich");
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
				this.add(B_OK, new AnchorConstraint(878, 958, 965, 686, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_OK.setText("OK");
				B_OK.setPreferredSize(new java.awt.Dimension(109, 26));
				//B_OK.setAction(getOKAction());
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

				
				
				//L_Age = new JLabel();
				//L_Age.setText("Alter:");
				//L_Age.setPreferredSize(new java.awt.Dimension(88, 18));
					
				
				
				L_Gender = new JLabel();
				this.add(L_Gender, new AnchorConstraint(451, 293, 511, 76, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(L_Age, new AnchorConstraint(95, 923, 155, 703, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_Gender.setText("Geschlecht:");
				L_Gender.setPreferredSize(new java.awt.Dimension(87, 18));
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

	
	/**
	 * @return the tF_Name
	 */
	public JTextField getTF_Name() {
		return TF_Name;
	}

	/**
	 * @return the rB_gender_w
	 */
	public JRadioButton getRB_gender_w() {
		return RB_gender_w;
	}

	/**
	 * @return the rB_gender_m
	 */
	public JRadioButton getRB_gender_m() {
		return RB_gender_m;
	}

	/**
	 * @return the tF_Size
	 */
	public JTextField getTF_Size() {
		return TF_Size;
	}

	/**
	 * @return the tF_Birthdate
	 */
	public JTextField getTF_Birthdate() {
		return TF_Birthdate;
	}

	public void AddSaveProfileListener(ActionListener al){
		B_OK.addActionListener(al);
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

	public void setData(UserProfile p) {
		
		
		TF_Name.setText(p.getName());
		if(p.getGender() == "female"){
			RB_gender_m.setSelected(true);
			RB_gender_w.setSelected(false);			
		}
		else {
			RB_gender_m.setSelected(false);
			RB_gender_w.setSelected(true);
		}
		ButtonModel model = RB_gender_m.getModel();
		OB_Gender.setSelected(model, true);
		TF_Size.setText(String.valueOf(p.getHeight()));
		TF_Birthdate.setText(p.getBirthday().getDateGreLiEnd());
		this.repaint();
		
	}
	
	

}
