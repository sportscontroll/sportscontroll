package de.dhbw.sportcontroll.ui;

import java.awt.Dimension;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
public class NewPanel extends javax.swing.JPanel {
	private JLabel L_Test;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame MainFram = new JFrame();
		MainFram.getContentPane().add(new NewPanel());
		MainFram.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		MainFram.pack();
		MainFram.setVisible(true);
	}
	
	public NewPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
			this.setAutoscrolls(true);
			this.setBackground(new java.awt.Color(255,128,0));
			{
				L_Test = new JLabel();
				this.add(L_Test);
				L_Test.setText("TAAAAAAAAAAATA");
				L_Test.setBackground(new java.awt.Color(255,128,0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
