import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ChapterWiseTest extends Test {

    ChapterWiseTest(String subject, int chapter, int year) {
        super(subject.toLowerCase(), chapter, year);
    }

    @Override
    public void takeTest() {
        ImportMCQ mcqs = new ImportMCQ(getSubject(), getChapter(), getYear());
        mcqs.openFile();
        List<Object> listOfMcqs = mcqs.readMCQ();
        setTotalMCQS(mcqs.getTotalMCQS());
        mcqs.closeFile(); //All mcqs are imported

        String welcomeMessage = "This is a test of chapter # " + getChapter() +
                " of " + getSubject().substring(0, 1).toUpperCase() + getSubject().substring(1);  //Capitalized first letter of word
        System.out.println(welcomeMessage + "\n");

        int i = 0;
        int j = 0;
        int length = listOfMcqs.size();

        while (length-- != 0) {

            if ((i >= 0 && i <= 3)) {
                System.out.println((String) listOfMcqs.get(i + j));
                i++;
                continue;
            }

            if ((i == 4)) {
                System.out.println((String) listOfMcqs.get(i + j));
                i++;

                boolean flag = true;
                do {

                    if (flag == true)
                        System.out.println("Enter your choice:");
                    if (flag == false)
                        System.err.println("Wrong MCQ selection! Enter from a,b,c,d :");

                    choice = sc.next().trim().toLowerCase();

                    if (!possibleChoices.contains(choice))
                        flag = false;
                    else
                        flag = true;

                } while (!flag);
                continue;
            }

            if (i == 5) {
                System.out.println("\nCorrect Option: " + (String) listOfMcqs.get(i + j));
                if (choice.equals((String) listOfMcqs.get(i + j)))
                    setCorrectMCQS(getCorrectMCQS()+1);
                else
                    setIncorrectMCQS(getIncorrectMCQS()+1);
                i++;
                continue;
            }

            if (i == 6) {
                System.out.println("\nExplanation: " + (String) listOfMcqs.get(i + j));
                System.out.println("__________________\n");
                i = 0;
                j = j + 7;
                continue;
            }

        }
    }
    public void writePercentageForHistory(){
        super.writePercentageForHistory("chapterwise",getSubject());
    }
}
