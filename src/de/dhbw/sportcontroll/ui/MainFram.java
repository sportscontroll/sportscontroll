package de.dhbw.sportcontroll.ui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.ui.RefineryUtilities;



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
public class MainFram extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4483572573535420382L;
	//MenuBar + elements
	private JMenuBar MenuBar;
	private JMenu MI_DataNew;
	private JMenuItem I_ProfileChange;
	private JMenuItem I_ProfilConfig;
	private JMenuItem I_DataClose;
	private JMenuItem I_DataSave;	
	private JMenuItem I_HelpAbout;
	private JMenuItem I_HelpHelp;
	private JMenuItem I_ProfileNew;
	private JMenuItem I_NewDiscipline;
	private JMenuItem I_NewWeight;
	private JMenuItem I_NewEntry;
	private JMenu M_Config;
	private JMenu M_Help;
	private JMenu M_Profil;
	private JMenu M_File;
	//Actions
	private AbstractAction workoutAction1;
	private AbstractAction calcAction1;
	private AbstractAction statisticAction1;
	private AbstractAction NewAction1;
	private AbstractAction AboutAction;
	private AbstractAction HelpAction;
	private AbstractAction profilNewAction;
	private AbstractAction profilChangeAction;
	private AbstractAction profilConfigAction;
	private AbstractAction newDisciplineAction;
	private AbstractAction newWeightAction;
	private AbstractAction newEntryAction;
	private AbstractAction CloseAction;
	private JButton B_TBMWorkout;
	private JButton B_TBMCalc;
	private JButton B_TBMStatistic;
	private JButton B_TBMNew;
	private JToolBar ToolBarMain;
	private JToolBar TB_Footer;
	private JLabel B_TBF_Clock;
	private JPanel Panel1;
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFram inst = new MainFram();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFram() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Picture/Lauf2.gif")).getImage());
			this.setTitle("SportControll");
			this.setExtendedState(MainFram.MAXIMIZED_BOTH);
			this.setSize(600,500);
			{
				ToolBarMain = new JToolBar();
				getContentPane().add(ToolBarMain, BorderLayout.NORTH);
				ToolBarMain.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
				{
					B_TBMNew = new JButton();
					ToolBarMain.add(B_TBMNew);
					B_TBMNew.setPreferredSize(new java.awt.Dimension(12, 27));
					B_TBMNew.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/New.gif")));
					B_TBMNew.setAction(getNewAction1());
				}
				{
					B_TBMStatistic = new JButton();
					ToolBarMain.add(B_TBMStatistic);
					B_TBMStatistic.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/stat.gif")));
					B_TBMStatistic.setAction(getStatisticAction1());
					B_TBMStatistic.setPreferredSize(new java.awt.Dimension(46, 52));
				}
				{
					B_TBMCalc = new JButton();
					ToolBarMain.add(B_TBMCalc);
					B_TBMCalc.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/Rechner.gif")));
					B_TBMCalc.setPreferredSize(new java.awt.Dimension(46, 52));
					B_TBMCalc.setAction(getCalcAction1());
				}
				{
					B_TBMWorkout = new JButton();
					ToolBarMain.add(B_TBMWorkout);
					B_TBMWorkout.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Picture/Lauf2.gif")));
					B_TBMWorkout.setAction(getWorkoutAction1());
				}
			}
			{
				TB_Footer = new JToolBar();
				BorderLayout TB_FooterLayout = new BorderLayout();
				TB_Footer.setLayout(TB_FooterLayout);
				getContentPane().add(TB_Footer, BorderLayout.SOUTH);
				getContentPane().add(getPanel1(), BorderLayout.CENTER);
				TB_Footer.setPreferredSize(new java.awt.Dimension(584, 20));
				{
					/**Feature ShowTime and Date
					 * Need: Date/Time Input
					 */
					
					B_TBF_Clock = new JLabel();
					BorderLayout B_TBF_ClockLayout = new BorderLayout();
					B_TBF_Clock.setLayout(null);
					TB_Footer.add(B_TBF_Clock, BorderLayout.EAST);
					B_TBF_Clock.setText("$DATE$");
					B_TBF_Clock.setPreferredSize(new java.awt.Dimension(191, 16));
				}
			}
			this.setJMenuBar(MenuBar);
			{
				MenuBar = new JMenuBar();
				setJMenuBar(MenuBar);
				{
					M_File = new JMenu();
					MenuBar.add(M_File);
					M_File.setText("Datei");
					{
						MI_DataNew = new JMenu();
						M_File.add(MI_DataNew);
						MI_DataNew.setText("Neu");
						{
							I_NewEntry = new JMenuItem();
							MI_DataNew.add(I_NewEntry);
							I_NewEntry.setText("Eintrag");
							I_NewEntry.setAction(getNewEntryAction());
						}
						{
							I_NewWeight = new JMenuItem();
							MI_DataNew.add(I_NewWeight);
							I_NewWeight.setText("Gewicht");
							I_NewWeight.setAction(getNewWeightAction());
						}
						{
							I_NewDiscipline = new JMenuItem();
							MI_DataNew.add(I_NewDiscipline);
							I_NewDiscipline.setText("Sportart");
							I_NewDiscipline.setAction(getNewDisciplineAction());
						}
					}
					{
						I_DataSave = new JMenuItem();
						M_File.add(I_DataSave);
						I_DataSave.setText("Speichern");
					}
					{
						I_DataClose = new JMenuItem();
						M_File.add(I_DataClose);
						I_DataClose.setText("Schlie�en");
						I_DataClose.setAction(getCloseAction());
					}
				}
				{
					M_Profil = new JMenu();
					MenuBar.add(M_Profil);
					M_Profil.setText("Profil");
					{
						I_ProfilConfig = new JMenuItem();
						M_Profil.add(I_ProfilConfig);
						I_ProfilConfig.setText("Einstellungen");
						I_ProfilConfig.setAction(getProfilConfigAction());
						I_ProfilConfig.setAccelerator(KeyStroke.getKeyStroke("pressed N"));
					}
					{
						I_ProfileChange = new JMenuItem();
						M_Profil.add(I_ProfileChange);
						I_ProfileChange.setText("Profil wechseln");
						I_ProfileChange.setAction(getProfilChangeAction());
					}
					{
						I_ProfileNew = new JMenuItem();
						M_Profil.add(I_ProfileNew);
						I_ProfileNew.setText("Neues Profil");
						I_ProfileNew.setAction(getProfilNewAction());
					}
				}
//				{
//					M_Config = new JMenu();
//					MenuBar.add(M_Config);
//					M_Config.setText("Einstellungen");
//				}
				{
					M_Help = new JMenu();
					MenuBar.add(M_Help);
					M_Help.setText("Hilfe");
					{
						I_HelpHelp = new JMenuItem();
						M_Help.add(I_HelpHelp);
						I_HelpHelp.setText("Hilfe");
						I_HelpHelp.setAction(getHelpAction());
						I_HelpHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
					}
					{
						I_HelpAbout = new JMenuItem();
						M_Help.add(I_HelpAbout);
						I_HelpAbout.setText("�ber");
						I_HelpAbout.setAction(getAboutAction());
						I_HelpAbout.setAccelerator(KeyStroke.getKeyStroke("ctrl shift A"));
						
					}
				}
				
			}
			pack();
			
			
		} catch (Exception e) {
		    //add Error handling code
			e.printStackTrace();
		}
	}
	
	private AbstractAction getCloseAction() {
		if(CloseAction == null) {
			CloseAction = new AbstractAction("Schlie�en", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1653001180308436701L;

				public void actionPerformed(ActionEvent evt) {
				
					System.exit(0);
				}
			};
		}
		return CloseAction;
	}
	
	private AbstractAction getNewEntryAction() {
		if(newEntryAction == null) {
			newEntryAction = new AbstractAction("Eintrag", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -463121038831680973L;

				public void actionPerformed(ActionEvent evt) {
					NewEntry.main(null);
				}
			};
		}
		return newEntryAction;
	}
	
	private AbstractAction getNewWeightAction() {
		if(newWeightAction == null) {
			newWeightAction = new AbstractAction("Gewicht", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 8282796218256968278L;

				public void actionPerformed(ActionEvent evt) {
					NewEntry.main(null);
				}
			};
		}
		return newWeightAction;
	}
	
	private AbstractAction getNewDisciplineAction() {
		if(newDisciplineAction == null) {
			newDisciplineAction = new AbstractAction("Sportart", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1082007504429534923L;

				public void actionPerformed(ActionEvent evt) {
					NewEntry.main(null);
				}
			};
		}
		return newDisciplineAction;
	}
	
	private AbstractAction getProfilConfigAction() {
		if(profilConfigAction == null) {
			profilConfigAction = new AbstractAction("Einstellungen", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 5783351402761490929L;

				public void actionPerformed(ActionEvent evt) {
					ConfigProfil.main(null);
				}
			};
		}
		return profilConfigAction;
	}
	
	private AbstractAction getProfilChangeAction() {
		if(profilChangeAction == null) {
			profilChangeAction = new AbstractAction("Profil wechseln", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -5840114218229847763L;

				public void actionPerformed(ActionEvent evt) {
					ChangeProfil.main(null);
				}
			};
		}
		return profilChangeAction;
	}
	
	private AbstractAction getProfilNewAction() {
		if(profilNewAction == null) {
			profilNewAction = new AbstractAction("Neues Profil", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 4294266842179134176L;

				public void actionPerformed(ActionEvent evt) {
					System.out.print("Das Neue Profil wurde noch nicht erstellt");
					NewProfil.main(null);
				}
			};
		}
		return profilNewAction;
	}
	
	private AbstractAction getHelpAction() {
		if(HelpAction == null) {
			HelpAction = new AbstractAction("Hilfe", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 5429166827964984391L;

				public void actionPerformed(ActionEvent evt) {
					
					try {
		                Desktop.getDesktop().open(new File("doc/Hilfe.pdf"));
		            } catch (IOException e1) {
		            	System.out.print("Datei nicht gefunden");
		                e1.printStackTrace();
		            }}
			};
		}
		return HelpAction;
	}
	
	private AbstractAction getAboutAction() {
		if(AboutAction == null) {
			AboutAction = new AbstractAction("�ber", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 8392308114404065931L;

				public void actionPerformed(ActionEvent evt) {
					About.main(null);
				}
			};
		}
		return AboutAction;
	}
	
	private AbstractAction getNewAction1() {
		if(NewAction1 == null) {
			NewAction1 = new AbstractAction("", new ImageIcon(getClass().getClassLoader().getResource("Picture/New.gif"))) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1710623350377813373L;
				private Container Panel1;

				public void actionPerformed(ActionEvent evt) {
					WorkoutTable.main(null);

				}
			};
		}
		return NewAction1;
	}
	
	private AbstractAction getStatisticAction1() {
		if(statisticAction1 == null) {
			statisticAction1 = new AbstractAction("", new ImageIcon(getClass().getClassLoader().getResource("Picture/stat.gif"))) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 8997818017855334640L;

				public void actionPerformed(ActionEvent evt) {
					//PieChart during sportdicipline
			        PieChart discipline = new PieChart("Durchfr�hrung Sportarten", "Prozentual Sportarten");
			        discipline.pack();			       
			        discipline.setVisible(true);
			        discipline.setLocation(5,110);
			        discipline.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
			        //LineChart kilometer
			        LineChart kilometer = new LineChart("Kilometer");
			        kilometer.pack();
		            RefineryUtilities.centerFrameOnScreen(kilometer);
		            kilometer.setVisible(true);
		            kilometer.setLocation(523,110);
		            kilometer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
		            GraphingData.main(null);
		            

			        
				}
			};
		}
		return statisticAction1;
	}
	
	private JPanel getPanel1() {
		if(Panel1 == null) {
			Panel1 = new JPanel();
		}
		return Panel1;
	}
	
	private AbstractAction getCalcAction1() {
		if(calcAction1 == null) {
			calcAction1 = new AbstractAction("", new ImageIcon(getClass().getClassLoader().getResource("Picture/Rechner.gif"))) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4327610667106708501L;

				public void actionPerformed(ActionEvent evt) {
					Calc.main(null);
				}
			};
		}
		return calcAction1;
	}
	
	private AbstractAction getWorkoutAction1() {
		if(workoutAction1 == null) {
			workoutAction1 = new AbstractAction("", new ImageIcon(getClass().getClassLoader().getResource("Picture/Lauf2.gif"))) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 2514105036702971549L;

				public void actionPerformed(ActionEvent evt) {
					WorkoutTable.main(null);
				}
			};
		}
		return workoutAction1;
	}

}
