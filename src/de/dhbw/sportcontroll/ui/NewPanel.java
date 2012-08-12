package de.dhbw.sportcontroll.ui;

import java.awt.Dimension;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;

   /** TestPanel DELETE
	 * @author Katja.Kaiser
	 *
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
