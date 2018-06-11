
import java.io.*;
import java.util.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.*;
import org.jfree.data.*;

public class AllTestsProgressChart {
    static Scanner scanner;
    static XYSeries series;
    private String testType;
    private String subject;

    //Constructor
    public AllTestsProgressChart(String testType){
        this.testType = testType; //this can only be "chapterwise", "halfbook", "fullbook", "full"
    }

    public AllTestsProgressChart(String testType, String subject){
        this.testType = testType; //this can only be "chapterwise", "halfbook", "fullbook", "full"
        this.subject = subject;
    }
    //This works as main as the main method of this class
    public void run() {
        if(subject == null)
            plotResult();
        else
            plotResult2();
    }

    public void plotResult() {

        try {
            int index = 0;
                File file = new File("C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\SoftwareFiles\\TestData\\"+testType+".txt");
            series = new XYSeries("Statistics");
            scanner = new Scanner(file);
            // Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                series.add(index++, scanner.nextDouble()*100);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XYDataset xyDataset = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createXYLineChart("Your Performance:", "Tests", "Percentage", xyDataset, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame1 = new ChartFrame("TaleemDost | Performance History", chart);
        frame1.setVisible(true);
        frame1.setSize(600, 400);

    }

    public void plotResult2() {

        try {
            int index = 0;
            File file = new File("C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\SoftwareFiles\\TestData\\"+subject+"\\"+testType+".txt");
            series = new XYSeries("Statistics");
            scanner = new Scanner(file);
            // Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                series.add(index++, scanner.nextDouble()*100);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XYDataset xyDataset = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createXYLineChart("Your Performance:", "Tests", "Percentage", xyDataset, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame1 = new ChartFrame("TaleemDost | Performance History", chart);
        frame1.setVisible(true);
        frame1.setSize(600, 400);

    }
}
