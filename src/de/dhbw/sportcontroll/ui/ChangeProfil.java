package de.dhbw.sportcontroll.ui;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
//import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
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
public class ChangeProfil extends javax.swing.JDialog {
	private JButton OK;
	private JButton B_Cancel;
	private JScrollPane SP_Userlist;
	private JList List_Profil;
	private JLabel L_User;
	private AbstractAction OKAction;
	private AbstractAction closeAction;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ChangeProfil inst = new ChangeProfil(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public ChangeProfil(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setTitle("Profile Wechseln");
			{
				L_User = new JLabel();
				getContentPane().add(getJScrollPane1(), new AnchorConstraint(166, 479, 509, 121, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(L_User, new AnchorConstraint(47, 969, 93, 32, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				L_User.setText("Profil ausw�hlen:");
				L_User.setPreferredSize(new java.awt.Dimension(359, 12));
				L_User.setRequestFocusEnabled(false);
			}
			{
				OK = new JButton();
				getContentPane().add(OK, new AnchorConstraint(860, 719, 956, 479, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				OK.setText("OK");
				OK.setAction(getOKAction());
				OK.setPreferredSize(new java.awt.Dimension(92, 25));
			}
			{
				B_Cancel = new JButton();
				getContentPane().add(B_Cancel, new AnchorConstraint(860, 972, 956, 732, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				B_Cancel.setText("Abbrechen");
				B_Cancel.setAction(getCloseAction());
				B_Cancel.setPreferredSize(new java.awt.Dimension(92, 25));
			}
			
			this.setSize(399, 300);
		
		} catch (Exception e) {
		//Errorcode
			JOptionPane.showMessageDialog(null,
                    "Error 999",
                    "ChangeProfil.java konnte nicht gefunden/gestartet werden",                                       
                    JOptionPane.WARNING_MESSAGE);
			
			e.printStackTrace();
		}
	}
	private AbstractAction getOKAction() {
		if(OKAction == null) {
			OKAction = new AbstractAction("OK", null) {
				public void actionPerformed(ActionEvent evt) {
					//Code for Select and Load USER
					
					setVisible(false);
				}
			};
		}
		return OKAction;
	}
	
	private AbstractAction getCloseAction() {
		if(closeAction == null) {
			closeAction = new AbstractAction("Schlie�en", null) {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			};
		}
		return closeAction;
	}
	
	public JList getList_Profil() {
		if(List_Profil == null) {
			ListModel List_ProfilModel = 
					new DefaultComboBoxModel(
							new String[] { "Nutzer 1", "Nutzer 2","Nutzer 3","Nutzer 4", "Nutzer 5","Nutzer 6", "Nutzer 2","Nutzer 3","Nutzer 4", "Nutzer 5","Nutzer 1", "Nutzer 2","Nutzer 3","Nutzer 4", "Nutzer 5" });
			List_Profil = new JList();
			List_Profil.setModel(List_ProfilModel);
			List_Profil.setPreferredSize(new java.awt.Dimension(120, 90));
			List_Profil.setLayoutOrientation(JList.VERTICAL_WRAP);
			List_Profil.setVisibleRowCount(20); // Max User 20 
		}
		return List_Profil;
	}
	
	private JScrollPane getJScrollPane1() {
		if(SP_Userlist == null) {
			SP_Userlist = new JScrollPane();
			SP_Userlist.setPreferredSize(new java.awt.Dimension(137, 90));
			SP_Userlist.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			SP_Userlist.setViewportView(getList_Profil());
		}
		return SP_Userlist;
	}

}
