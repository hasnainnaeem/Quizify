/*
This class imports all the mcqs from a file using MCQ class object
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ImportMCQ {

    private String subject;
    private int chapter;
    private int year;
    private int totalMCQS;

    List<Object> temp;
    File f;
    FileReader reader;
    BufferedReader bufferedReader;


    public ImportMCQ(String subject, int chapter, int year){
        this.subject = subject;
        this.chapter = chapter;
        this.year = year;
    }

    /* Getters and Setters Start */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getTotalMCQS() {
        return totalMCQS;
    }

    public void setTotalMCQS(int totalMCQS) {
        this.totalMCQS = totalMCQS;
    }

    /* Getters and Setters End */

    public void openFile(){
        try {
            f = new File("C:\\Users\\Administrator\\IdeaProjects\\Quizify\\src\\Files"+"\\"+subject+"\\"+year+"\\"+chapter+".txt");
            reader = new FileReader(f);
            bufferedReader = new BufferedReader(reader);
        }
        catch(IOException e) {
            System.err.println("MCQs file is not present in mentioned path.");
            e.printStackTrace();
        }
         temp = new ArrayList<Object>();
    }

    public List<Object> readMCQ(){
        String line = null;
        int i = 0;
        int j = 0;
        try {
            while ((line = bufferedReader.readLine()) != null) {

                if(i==5) //Adding mcq answer which is character
                    temp.add(line.charAt(0));
                if(i!=5) //Adding other lines about MCQ which are strings
                    temp.add(line);
                j++;
            }
            totalMCQS = j/7; // Because there are 7 lines in one MCQ
        }
        catch (IOException e){
            System.err.println("Could not read lines from the mentioned file.");
            e.printStackTrace();
        }
        return temp;
    }

    public void closeFile(){
        try {
            bufferedReader.close();
            reader.close();
        }
        catch(IOException e){
            System.err.println("Could not close MCQ file.");
            e.printStackTrace();
        }
    }
}
