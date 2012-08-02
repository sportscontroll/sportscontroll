package de.dhbw.sportcontroll.ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class About extends javax.swing.JDialog {
	private JLabel L_Program;
	private JLabel L_Developer;
	private JLabel L_Version;
	private JLabel L_AboutPic;
	private AbstractAction AboutOKAction1;
	private JButton B_AboutOK;

	/**
	* JDialog for About  required in MainFram
	*  
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				About inst = new About(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public About(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
			}
			getContentPane().setLayout(null);
			this.setTitle("Über");
			{
				L_Version = new JLabel();
				getContentPane().add(L_Version, "North");
				L_Version.setText("Version 1.0");
				L_Version.setBounds(296, 0, 88, 25);
			}
			{
				L_Developer = new JLabel();
				getContentPane().add(L_Developer, "South");
				L_Developer.setText("Daniel Friedrich und Katja Kaiser");
				L_Developer.setBounds(144, 88, 195, 26);
			}
			{
				L_Program = new JLabel();
				getContentPane().add(L_Program, "East");
				L_Program.setText("SportControll wurde entwickelt von:");
				L_Program.setBounds(135, 12, 222, 67);
			}
			{
				B_AboutOK = new JButton();
				getContentPane().add(B_AboutOK);
				getContentPane().add(getL_AboutPic());
				B_AboutOK.setText("OK");
				B_AboutOK.setBounds(235, 132, 61, 23);
				B_AboutOK.setAction(getAboutOKAction1());
			}
			this.setSize(400, 204);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//close action
	private AbstractAction getAboutOKAction1() {
		if(AboutOKAction1 == null) {
			AboutOKAction1 = new AbstractAction("OK", null) {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			};
		}
		return AboutOKAction1;
	}
// 	Program picture
	private JLabel getL_AboutPic() {
		if(L_AboutPic == null) {
			L_AboutPic = new JLabel();
			L_AboutPic.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/AboutPic.gif")));
			L_AboutPic.setBounds(12, 1, 137, 154);
		}
		return L_AboutPic;
	}

}
