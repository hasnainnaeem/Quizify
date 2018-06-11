import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Test {

    private String subject;
    private int chapter;
    private int year;

    private int correctMCQS, incorrectMCQS, totalMCQS;
    ArrayList<String> possibleChoices;
    String choice = null;
    Scanner sc = new Scanner(System.in);

    public Test(String subject, int chapter, int year)  {
        setChapter(chapter);
        setSubject(subject);
        setYear(year);
        possibleChoices = new ArrayList<String>(Arrays.asList("a","b","c","d"));
        choice = "z";
        sc = new Scanner(System.in);
    }

    public Test(String subject, int chapter, int year, ArrayList<String> choices){
        setChapter(chapter);
        setSubject(subject);
        possibleChoices = choices;
        choice = "z";
        sc = new Scanner(System.in);
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

    public int getTotalMCQS() {
        return totalMCQS;
    }

    public void setTotalMCQS(int totalMCQS) {
        this.totalMCQS = totalMCQS;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        subject = subject.toLowerCase().trim();
        ArrayList<String> subjects = new ArrayList<String>(Arrays.asList("physics","chemistry","mathematics","biology","english","computer"));
        if(subjects.contains(subject))
            this.subject = subject;
        else
            throw new IllegalArgumentException("This is not a valid subject!");
    }

    public int getChapter() {
        return chapter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year<1 || year > 2)
            throw new IllegalArgumentException("Year can't be anything else than 1 or 2.");
        this.year = year;
    }

    public void setChapter(int chapter) {
        if(chapter >= -1 )
            this.chapter = chapter;
    }

    public abstract void takeTest();

    public void displayDetails(){
        String details = "Test Details: \n\tTotal MCQs: "+totalMCQS+"\n\tCorrect MCQS: "+correctMCQS+"\n\tIncorrect MCQS: "+incorrectMCQS;
        System.out.println(details);
    }

    public void writePercentageForHistory(String testType, String subject){
        try {
            File f = new File("C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\SoftwareFiles\\TestData\\"+testType+".txt");
            File f2 = new File("C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\SoftwareFiles\\TestData\\"+subject+"\\"+testType+".txt");

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

