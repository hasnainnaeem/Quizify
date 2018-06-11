import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FullTest {

    private final String subject;
    private final int noOfMCQS;
    FullBookTest book1, book2;

    private int totalMCQS, correctMCQS, incorrectMCQS;

    public FullTest(String subject, int noOfMCQS){
        this.subject = subject;
        this.noOfMCQS = noOfMCQS;

        book1 = new FullBookTest(subject,1,noOfMCQS);
        book2 = new FullBookTest(subject,2,noOfMCQS);
    }

    /*Getters and setters Start*/

    public String getSubject() {
        return subject;
    }

    public int getNoOfMCQS() {
        return noOfMCQS;
    }

    public int getTotalMCQS() {
        return totalMCQS;
    }

    public void setTotalMCQS(int totalMCQS) {
        this.totalMCQS = totalMCQS;
    }

    public int getCorrectMCQS() {
        return correctMCQS;
    }

    public void setCorrectMCQS(int correctMCQS) {
        this.correctMCQS = correctMCQS;
    }

    public int getIncorrectMCQS() {
        return incorrectMCQS;
    }

    public void setIncorrectMCQS(int incorrectMCQS) {
        this.incorrectMCQS = incorrectMCQS;
    }

    /*Getters and setters End */

    public void takeTest(){
        System.out.println("This is full test of "+subject+". This test is divided into 2 sections, first section from book 1 and second section from book 2.\n");
        book1.takeTest();
        book2.takeTest();
        totalMCQS = book1.getTotalMCQS()+book2.getTotalMCQS();
        correctMCQS = book1.getCorrectMCQS()+book2.getCorrectMCQS();
        incorrectMCQS = book1.getIncorrectMCQS()+book2.getCorrectMCQS();
    }

    public void writePercentageForHistory(String subject){
        try {
            File f = new File("C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\SoftwareFiles\\TestData\\full.txt");
            File f2 = new File("C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\SoftwareFiles\\TestData\\"+subject+"\\full.txt");

            FileWriter writer = new FileWriter(f,true);
            FileWriter writer2 = new FileWriter(f2,true);

            BufferedWriter bufferedW = new BufferedWriter(writer);
            BufferedWriter bufferedW2 = new BufferedWriter(writer2);

            bufferedW.write(((double)getCorrectMCQS()/(double)getTotalMCQS())+"\t");
            bufferedW2.write(((double)getCorrectMCQS()/(double)getTotalMCQS())+"\t");

            bufferedW.flush();
            bufferedW.close();
            writer.close();
            bufferedW2.flush();
            bufferedW2.close();
            writer2.close();
        }
        catch(IOException e){
            System.err.println("Could not store test percentage in file.");
        }
    }
}
