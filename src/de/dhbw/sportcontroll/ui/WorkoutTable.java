package de.dhbw.sportcontroll.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


import de.dhbw.sportcontroll.dataobjects.Workout;
import de.dhbw.sportcontroll.main.Test;

public class WorkoutTable extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8773616597956968154L;

	/**
	 * Show the workouts in table form.
	 * Funktion: Sort, change Rows
	 * @author Katja
	 * @return Workout as table
	 */
    private boolean DEBUG = false;
    
    private TableModel tableModel;
    private JTable table;

    public WorkoutTable() {
        super(new GridLayout(1,0));

        this.tableModel = new TableModel ();
        table = new JTable(new TableModel());
        
        table.setPreferredScrollableViewportSize(new Dimension(800,500));
        table.setFillsViewportHeight(true);
        // TableRowSorter sort table
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
        table.setRowSorter( sorter );
        sorter.setModel( tableModel);
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

		private String[] columnNames = Test.GETColumnName();
        
        private Object [][] data = Test.GETWorkout();
        	
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
            return data.length;
        }

        public String getColumnName(int col) {
        	/*
        	 * @return columnNames
        	 * 
             */
   
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
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
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
        
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("WorkoutTabelle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocation(2,110);
        //Create and set up the content pane.
        JComponent newContentPane = new WorkoutTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

		

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    
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
