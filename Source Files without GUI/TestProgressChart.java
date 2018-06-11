
import java.awt.Color;
import java.io.*;

import static java.lang.Integer.parseInt;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class TestProgressChart {

    private int totalMCQS, correctMCQS, incorrectMCQS, unattemptedMCQS;

    public TestProgressChart(int totalMCQS, int correctMCQS, int incorrectMCQS, int unattemptedMCQS) {
        this.totalMCQS = totalMCQS;
        this.correctMCQS = correctMCQS;
        this.incorrectMCQS = incorrectMCQS;
        this.unattemptedMCQS = unattemptedMCQS;
    }

    private static PieDataset createPieDataSet(String dataFileName) throws IOException {
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        BufferedReader bReader = new BufferedReader(new FileReader(dataFileName));
        String s;
        while ((s = bReader.readLine()) != null) {
            String datavalue[] = s.split("\t");
            String category = datavalue[0];
            String value = datavalue[1];
            pieDataset.setValue(category, parseInt(value));
        }
        bReader.close();
        return pieDataset;
    }

    private JFreeChart createPieChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart3D(
                "Test Progress:\n"+"___________\n\n"+"Total MCQs: "+totalMCQS+"\nCorrect MCQs: "+correctMCQS+"\nIncorrect MCQs: "
                        +incorrectMCQS+"\nUnattempted MCQs: "+unattemptedMCQS, dataset, true, true, true);

        PiePlot3D p = (PiePlot3D) chart.getPlot();
        p.setForegroundAlpha(0.5f);
        p.setBackgroundAlpha(0.2f);

        chart.setBackgroundPaint(Color.white);
        chart.setAntiAlias(true);
        chart.setBorderVisible(false);
        chart.setTextAntiAlias(true);

        return chart;

    }

    public void saveChart(JFreeChart chart, String fileLocation) {
        String fileName = fileLocation;
        try {
            ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Problem occurred creating chart.");
        }
    }

    public void run() throws IOException {
        saveDataToFile();
        TestProgressChart chartCreator = new TestProgressChart(totalMCQS, correctMCQS, incorrectMCQS, unattemptedMCQS);
        String dataFileLocation = "C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\SoftwareFiles\\TestDetails.txt";
        PieDataset pieDataset = chartCreator.createPieDataSet(dataFileLocation);
        JFreeChart chart = chartCreator.createPieChart(pieDataset);
        String fileLocation = "Test Progress.jpg";
        chartCreator.saveChart(chart, fileLocation);

        //live demo
        ChartFrame frame = new ChartFrame("TaleemDost - Test Progress", chart);
        frame.setVisible(true);
        frame.setSize(700, 500);

        //JInternalFrame jif = new JInternalFrame("Chart");

    }

    public void saveDataToFile(){
        FileWriter writer;
        BufferedWriter bufferedW;
        File f = new File("C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\SoftwareFiles\\TestDetails.txt");
        try {
             writer = new FileWriter(f);
             bufferedW = new BufferedWriter(writer);
             bufferedW.write("attempted\t"+totalMCQS+"\nunattempted\t"+unattemptedMCQS+"\ncorrect\t"+correctMCQS+"\nincorrect\t"+incorrectMCQS);
             bufferedW.flush();
             bufferedW.close();
             writer.close();
        }
        catch (IOException e){
            System.err.println("Could not display progress marks. Kindly contact us if issue persists.");
        }
    }
}
