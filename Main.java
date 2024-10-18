package your.package.name; // Replace with your package name

import java.util.List;
import java.util.function.Function;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A template for plotting mathematical functions using Java and JFreeChart.
 */
public class FunctionPlotter {
    // Static frame and panel to hold multiple charts
    private static JFrame frame = null;
    private static JPanel panel = null;

    // Define the range for the x-axis
    private static double xmin = 0;
    private static double xmax = 10; // Adjust as needed
    private static double xIncrement = 0.1; // Step size for x values

    public static void main(String[] args){
        // Example function: y = sin(x)
        Function<Double, Double> sineFunction = x -> Math.sin(x);
        plotFunction(sineFunction, "Sine Function");

        // Example function: y = cos(x)
        Function<Double, Double> cosineFunction = x -> Math.cos(x);
        plotFunction(cosineFunction, "Cosine Function");

        // Example function: y = x^2
        Function<Double, Double> quadraticFunction = x -> Math.pow(x, 2);
        plotFunction(quadraticFunction, "Quadratic Function");
    }

    /**
     * Plots a mathematical function within the specified x-range.
     *
     * @param function   The mathematical function to plot.
     * @param seriesName The name of the function (used in the chart).
     */
    public static void plotFunction(Function<Double, Double> function, String seriesName){
        List<Double> yValues = new ArrayList<>();
        List<Double> xValues = new ArrayList<>();
        double x = xmin;

        while(x <= xmax){
            double yValue = function.apply(x);
            xValues.add(x);
            yValues.add(yValue);
            x += xIncrement;
        }
        plotChart("X-Axis", "Y-Axis", xValues, yValues, seriesName);
    }

    /**
     * Creates and displays a chart with the provided x and y values.
     *
     * @param xAxisLabel Label for the x-axis.
     * @param yAxisLabel Label for the y-axis.
     * @param xValues    List of x-values.
     * @param yValues    List of y-values.
     * @param seriesName Name of the data series.
     */
    public static void plotChart(String xAxisLabel, String yAxisLabel, List<Double> xValues, List<Double> yValues, String seriesName){
        // Create a series to hold the data
        XYSeries series = new XYSeries(seriesName);
        for(int i = 0; i < xValues.size(); i++){
            series.add(xValues.get(i), yValues.get(i));
        }

        // Add the series to a dataset
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Create the chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                seriesName,                 // Chart title
                xAxisLabel,                 // X-axis label
                yAxisLabel,                 // Y-axis label
                dataset,                    // Data
                PlotOrientation.VERTICAL,
                true,                       // Include legend
                true,
                false
        );

        // Create the ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        // Initialize the frame and panel if they are null
        if (frame == null) {
            frame = new JFrame("Function Plotter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Horizontal layout
            frame.add(panel);
            frame.setSize(800, 600); // Set initial size
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        // Add the chart panel to the main panel
        panel.add(chartPanel);
        panel.revalidate();
        panel.repaint();
    }
}
