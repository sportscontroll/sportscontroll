package de.dhbw.sportcontroll.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

import de.dhbw.sportcontroll.dataobjects.Date;
import de.dhbw.sportcontroll.dataobjects.SportDiscipline;
import de.dhbw.sportcontroll.dataobjects.Workout;
import de.dhbw.sportcontroll.main.Test;

public class WorkoutTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8773616597956968154L;
	
	private static final String[] COLUM_NAMES = {"ID", "Sportart", "Datum"};
	private static final int COLUM_IDX_ID = 0;
	private static final int COLUM_IDX_DISCIPLIN = 1;
	private static final int COLUM_IDX_DATE = 2;
	
	

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
			System.out.println("data size = " + data.size());
			
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
			//	break;

			case COLUM_IDX_DATE:
				return data.elementAt(row).getDate().getDateGreLiEnd();
			//	break;
			case COLUM_IDX_DISCIPLIN:
				return data.elementAt(row).getDisciplin().getName();
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

                if (o != null)
                {
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
				data.elementAt(row).setId((int)value);				
				break;

			case COLUM_IDX_DATE:
				 data.elementAt(row).getDate().setDateString((String)value);
				break;
			case COLUM_IDX_DISCIPLIN:
				 data.elementAt(row).getDisciplin().setName((String) value);
				 break;
			default:
				
        	}
				
			       
        }

       
    }

    /**
    
    
    /**
     * sets all Workouts to the Table
     * @param workouts
     */
	public void setTableData(ArrayList<Workout> workouts) {
		int i = 1;
		for(Workout w : workouts){
			//.tableModel.setValueAt(value, row, col)
		}
		
	}
	
	
	public void addTableMouseAdapter(MouseAdapter ma){
		table.addMouseListener(ma);
	}
	
	
	
	
}
