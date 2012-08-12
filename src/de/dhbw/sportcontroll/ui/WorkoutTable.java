package de.dhbw.sportcontroll.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

import de.dhbw.sportcontroll.dataobjects.Date;
import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.dataobjects.Workout;
import de.dhbw.sportcontroll.db.DataHandler;
import de.dhbw.sportcontroll.exceptions.SQLConnectionException;
import de.dhbw.sportcontroll.exceptions.SQLDriverNotFoundException;
import de.dhbw.sportcontroll.main.Test;

public class WorkoutTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8773616597956968154L;
	
	private static final String[] COLUM_NAMES = {"ID", "Sportart", "Datum", "Dauer", "Herzfrequenz", "Ort", "Kalorien", "Notiz"};
	private static final int COLUM_IDX_ID = 0;
	private static final int COLUM_IDX_DISCIPLIN = 1;
	private static final int COLUM_IDX_DATE = 2;
	private static final int COLUM_IDX_DURATION = 3;
	private static final int COLUM_IDX_HEART = 4;
	private static final int COLUM_IDX_LOC = 5;
	private static final int COLUM_IDX_CALO = 6;
	private static final int COLUM_IDX_NOTE = 7;
	
	

	/**
	 * Show the workouts in table form.
	 * Funktion: Sort, change Rows
	 * @author Katja
	 * @return Workout as table
	 */
    private boolean DEBUG = false;
    
    private TableModel tableModel;
    private JTable table;

    public WorkoutTable(ArrayList<Workout> wList) {
        super(new GridLayout(1,0));

        this.tableModel = new TableModel (wList);
        table = new JTable(tableModel);
        
        table.setPreferredScrollableViewportSize(new Dimension(800,500));
        table.setFillsViewportHeight(true);
        
        // TableRowSorter sort table
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
        //table.setRowSorter( sorter );
       // sorter.setModel( tableModel);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
        add(scrollPane);

        table.getTableHeader().setReorderingAllowed(false);

         
        
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
    }

    class TableModel extends AbstractTableModel {
        /**
		 * 
		 */
    	
    	
    	
		private static final long serialVersionUID = 3479829496492026281L;

		private String[]  columnNames= COLUM_NAMES;
		
		Vector<Workout> data;
        
       // private Object [][] data = Test.GETWorkout();
		
		public TableModel(ArrayList<Workout> wList) {
			this.data = new Vector<Workout>();
			
			for(Workout w : wList){
				this.data.add(w);				
			}
			fireTableChanged(null);
			
			
		}
		
        	
        public int getColumnCount() {
        	/*
        	 * @return length of columnNames 
        	 */
            return columnNames.length;
        }

        public int getRowCount() {
        	/*
        	 * @return length of data (Count Row) 
        	 */
            return data.size();
        }

        public String getColumnName(int col) {
        	/*
        	 * @return columnNames
        	 * 
             */
   
            return columnNames[col];
        }

        public void addRow(Workout w){
        	
        }
        public Object getValueAt(int row, int col) {
        	switch (col) {
			case COLUM_IDX_ID:
				return data.elementAt(row).getId();	
			case COLUM_IDX_DATE:
				return data.elementAt(row).getDate().getDateGreLiEnd();
			case COLUM_IDX_DISCIPLIN:
				if(data.elementAt(row).getDisciplin() == null)
					try {
						return DataHandler.getInstance().loadSportDiscipline(data.elementAt(row).getDid());
					} catch (SQLException | SQLDriverNotFoundException
							| SQLConnectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else
					return data.elementAt(row).getDisciplin().getName();				
			case COLUM_IDX_CALO:
				return data.elementAt(row).getConsumedCalories();
			case COLUM_IDX_DURATION:
				return data.elementAt(row).getDuration();
			case COLUM_IDX_HEART:
				return data.elementAt(row).getHeartRate();
			case COLUM_IDX_LOC:
				return data.elementAt(row).getLocation();
			case COLUM_IDX_NOTE:
				return data.elementAt(row).getComment();
			default:
				return null;
			//	break;
			}
        
        }

//        public Class getColumnClass(int c) {
//        	System.out.println("ColumClass " + c);
//        	switch (c) {
//			case COLUM_IDX_ID:
//				return Integer.class;				
//			//	break;
//
//			case COLUM_IDX_DATE:
//				return String.class;
//			//	break;
//			case COLUM_IDX_DISCIPLIN:
//				return String.class;
//			default:
//				return null;
//			//	break;
//			}
//            		
//        }
        
        public Class getColumnClass(int column)
        {
            for (int row = 0; row < getRowCount(); row++)
            {
                Object o = getValueAt(row, column);
                if (o != null)  {
                    return o.getClass();
                }
            }
            return Object.class;
        }

//		Function to edit table
//        public boolean isCellEditable(int row, int col) {
//           
//            if (col < 1) {
//                return false;
//            } else {
//                return true;
//            }
//        }

        public void setValueAt(Object value, int row, int col) {
           
        	switch (col) {
			case COLUM_IDX_ID:
				System.out.println("setting col ID " + value);
				data.elementAt(row).setId((int)value);				
				break;
			case COLUM_IDX_DATE:
				 data.elementAt(row).getDate().setDateString((String)value);
				break;
			case COLUM_IDX_DISCIPLIN:
				 data.elementAt(row).getDisciplin().setName((String) value);
				 break;
			case COLUM_IDX_CALO:
				 data.elementAt(row).setConsumedCalories((int) value);
				break;
			case COLUM_IDX_DURATION:
				 data.elementAt(row).setDuration((int)value);
				break;
			case COLUM_IDX_HEART:
				 data.elementAt(row).setHeartRate((int) value);
				break;
			case COLUM_IDX_LOC:
				 data.elementAt(row).setLocation((String)value);
				break;
			case COLUM_IDX_NOTE:
				 data.elementAt(row).setComment((String)value);
				break;
			default:
				
        	}
        	fireTableChanged(null);
				
			       
        }
        
        public void resetTableData(ArrayList<Workout> wList){
	        this.data = new Vector<Workout>();
			
			for(Workout w : wList){
				this.data.add(w);				
			}
			fireTableChanged(null);
        }
       
    }

    /**
    
    
    /**
     * sets all Workouts to the Table
     * @param workouts
     */
	public void refreshTableData(ArrayList<Workout> workouts) {
		tableModel.resetTableData(workouts);
		fireTableChange();
	}
	
	
	public void addTableMouseAdapter(MouseAdapter ma){
		table.addMouseListener(ma);
	}


	public void fireTableChange() {
		System.out.println("repaint");
		tableModel.fireTableChanged(new TableModelEvent(tableModel));
		tableModel.fireTableDataChanged();
		table.repaint();
		this.repaint();
	}
	
	
	
	
}
