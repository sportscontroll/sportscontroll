package de.dhbw.sportcontroll.ui;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutTable extends JPanel {
    private boolean DEBUG = false;

    public WorkoutTable() {
        super(new GridLayout(1,0));

        JTable table = new JTable(new TableModel());
        table.setPreferredScrollableViewportSize(new Dimension(800,500));
        table.setFillsViewportHeight(true);
        

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    class TableModel extends AbstractTableModel {
        private String[] columnNames = {"ID",
                                        "Sportart",
                                        "Dauer",
                                        "Datum",
                                        "Strecke",
                                        "Ort"};
        private Object[][] data = {
            {1,"Schwimmen","30", "20.07.12","10","Lörrach"},
            {2,"Laufen","20", "21.07.12","10","Lörrach"},
            {3,"Schwimmen","60", "30.07.12","10","Lörrach"},
            {4,"Radfahren","85", "01.08.12","10","Lörrach"},
            {1,"Schwimmen","30", "20.07.12","10","Lörrach"},
            {2,"Laufen","20", "21.07.12","10","Lörrach"},
            {3,"Schwimmen","60", "30.07.12","10","Lörrach"},
            {4,"Radfahren","85", "01.08.12","10","Lörrach"},
            {1,"Schwimmen","30", "20.07.12","10","Lörrach"},
            {2,"Laufen","20", "21.07.12","10","Lörrach"},
            {3,"Schwimmen","60", "30.07.12","10","Lörrach"},
            {4,"Radfahren","85", "01.08.12","10","Lörrach"}
    };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 1) {
                return false;
            } else {
                return true;
            }
        }

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

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
