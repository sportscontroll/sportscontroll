package de.dhbw.sportcontroll.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * Line Chart with jfree
 * 
 */
public class LineChart extends ApplicationFrame {
// Testdata 
	double[] disci1 = { 10, 20, 30, 35.5 ,15.0, 25.0, 31.0, 35.5, 65.2 };
	double[] disci2= { 10.5, 22, 12.0, 15.5 ,45.0, 35.0, 34.0, 21.5, 45.2 };
	double[] disci3= { 1.5, 23, 15.0, 11.5 ,43.0, 25.0, 14.0, 51.5, 35.2 };
	
	String[] month ={"Jannuar","Feburar","März","April","Mai","Juni"};
	
    /**
     * Creates a new chart
     *
     * @param title  frame title
     */
    public LineChart(final String applicationTitle) {
        super(applicationTitle);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Creates a sample dataset.
     * 
     * @return The dataset.
     */
    private CategoryDataset createDataset() {
        
        // row keys...
        final String series1 = "Laufen";
        final String series2 = "Radfahren";
        final String series3 = "Schwimmen";

        // column keys...
        final String type1 = month[0];
        final String type2 = month[1];
        final String type3 = month[2];
        final String type4 = month[3];
        final String type5 = month[4];
        final String type6 = month[5];
       

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(disci1[0], series1, type1);
        dataset.addValue(disci1[1], series1, type2);
        dataset.addValue(disci1[2], series1, type3);
        dataset.addValue(disci1[3], series1, type4);
        dataset.addValue(disci1[4], series1, type5);
        
        dataset.addValue(disci2[0], series2, type1);
        dataset.addValue(disci2[1], series2, type2);
        dataset.addValue(disci2[2], series2, type3);
        dataset.addValue(disci2[3], series2, type4);
        dataset.addValue(disci2[4], series2, type5);
        dataset.addValue(disci2[5], series2, type6);

        dataset.addValue(disci3[0], series3, type1);
        dataset.addValue(disci3[1], series3, type2);
        dataset.addValue(disci3[2], series3, type3);
        dataset.addValue(disci3[3], series3, type4);
        dataset.addValue(disci3[4], series3, type5);
        dataset.addValue(disci3[5], series3, type6);
        
        return dataset;
                
    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  a dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createLineChart(
            "Gesammtkilometer",        // chart title
            "Monat",                   // domain axis label
            "Kilometer",               // range axis label
            dataset,                   // data
            PlotOrientation.VERTICAL,  // orientation
            true,                      // include legend
            true,                      // tooltips
            false                      // urls
        );
        
        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

     
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
    
        renderer.setSeriesStroke(
            0, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            1, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            2, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {2.0f, 6.0f}, 0.0f
            )
        );
        return chart;
    }
    
    /**
     * 
     * @param args  
     */
   

}

