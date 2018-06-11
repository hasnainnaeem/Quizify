
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HalfBookTest extends Test{

    static final Map<String, Integer[]> CHAPTERS;
    static {
        final Map<String, Integer[]> valuesByName = new HashMap<>();
        valuesByName.put("physics1_1", new Integer[]{1,6} ); // This indicates that physics first year's first half test has 6 chapters
        valuesByName.put("physics1_2", new Integer[]{7,11} ); //This indivates that physics 2nd year's second half has 7-11 chapters
        valuesByName.put("physics2_1", new Integer[]{1,5} ); //Similiar working
        valuesByName.put("physics2_2", new Integer[]{6,10} );
        valuesByName.put("chemistry1_1", new Integer[]{1,6} );
        valuesByName.put("chemistry1_2", new Integer[]{7,11});
        valuesByName.put("chemistry2_1", new Integer[]{1,8} );
        valuesByName.put("chemistry2_2", new Integer[]{9,16} );
        valuesByName.put("mathematics1_1", new Integer[]{1,7} );
        valuesByName.put("mathematics1_2", new Integer[]{8,14});
        valuesByName.put("mathematics2_1", new Integer[]{1,4});
        valuesByName.put("mathematics2_2", new Integer[]{5,7});
        valuesByName.put("biology1_1", new Integer[]{1,7});
        valuesByName.put("biologoy1_2", new Integer[]{8,14});
        valuesByName.put("biology2_1", new Integer[]{15,21});
        valuesByName.put("biology2_2", new Integer[]{22,27});
        CHAPTERS = Collections.unmodifiableMap(valuesByName);
    }
    private int whichHalf; // variable to store, is it first half test or 2nd half
    private int mcqsNeededPerChapter;
    public HalfBookTest(String subject, int year, int whichHalf, int mcqsNeededPerChapter){
        super(subject.toLowerCase(), 0,year );
        this.whichHalf = whichHalf;
        this.mcqsNeededPerChapter = mcqsNeededPerChapter;
    }

    @Override
    public void takeTest(){

        Integer[] chaptersRange = (CHAPTERS.get(getSubject()+getYear()+"_"+whichHalf));
        //Array of mcqs from all chapters in half book
        ImportMCQ[] importMCQS = new ImportMCQ[ chaptersRange[1] - chaptersRange[0] + 1]; //fetching no. of chapters for given half book
        List<Object> mcqs[] = new List [ chaptersRange[1] - chaptersRange[0] + 1 ]; //Each array slot has a list of objects which can store string and char details of mcqs

        for(int i = chaptersRange[0], k =0; i <= chaptersRange[1]; i++, k++){
            importMCQS[k] = new ImportMCQ(getSubject(), i, getYear()); //Chapter names start from 1
            importMCQS[k].openFile();
            mcqs[k] = importMCQS[k].readMCQ();
            importMCQS[k].closeFile();
        }

        String welcomeMessage = "Welcome to " + whichHalf +(whichHalf == 1? "st" : "nd")+
                " half test of " + getSubject().substring(0, 1).toUpperCase() + getSubject().substring(1);  //Capitalized first letter of word

        System.out.println(welcomeMessage + "\n");

        ArrayList<Integer> indices;
        setTotalMCQS(mcqsNeededPerChapter * mcqs.length); //Total mcqs = mcqs need per chapter * total chapters

        for(int numberOfChapters =0; numberOfChapters < mcqs.length ; numberOfChapters++){

            indices = indexGenerator( mcqs[numberOfChapters].size(), mcqsNeededPerChapter); //This returns required indexes of first lines of mcqs in files
            int length = indices.size(); //No. of index to mcqs in mcq list

            for(int j = 0 ; j < length ; j++) {

                for (int i = 0, counter = 0; i < 7; i++, counter++) { //We have starting index to each mcq in mcq[] array, printing next 6 lines to print whole mcq

                    if((counter>= 0 && counter <=4)) //Printing question and 4 mcqs
                    System.out.println(mcqs[numberOfChapters].get(indices.get(j)+i));

                    if(counter == 5){ //Printing correct MCQ after taking user's choice and incrementing correct/incorrect mcqs

                        boolean flag = true; //Looping until user enters correct mcq
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

                        if(choice.equals(mcqs[numberOfChapters].get(indices.get(j)+i))) //Checking if mcq entered is correct
                            setCorrectMCQS(getCorrectMCQS()+1);
                        else
                            setIncorrectMCQS(getIncorrectMCQS()+1);

                        System.out.println("\nAnswer : "+mcqs[numberOfChapters].get(indices.get(j)+i)); //printing correct mcq
                    }

                    if(counter == 6) { //Printing explanation
                        System.out.println("Explanation : " + mcqs[numberOfChapters].get(indices.get(j) + i));
                        System.out.println("_______________________\n");
                    }
                }
            }
        }
    }

    public void writePercentageForHistory(){
        super.writePercentageForHistory("halfbook",getSubject());
    }
/*
  This method returns starting indexes of mcqs in Array List on the basis of:
  - No. of mcqs required (ArrayList returned will have same number of indexes, each indicating start starting index of
    mcq in Actual ArrayList of mcqs.)
  - No. of lines in Actual Array List named as "mcq" (which holds all mcqs, total mcqs in Actual ArrayList are totalLines/7 )
 */
    public ArrayList<Integer> indexGenerator(int totalLines, int mcqsNeeded) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < totalLines; i = i + 7) {
            numbers.add(i);
        }

        ArrayList<Integer> indices = new ArrayList<Integer>();
        Random random = new Random();

        if(mcqsNeeded > totalLines/7) //If there are less mcqs in file than mcqsNeeded
          mcqsNeeded = 20;

        for (int i = 0; i < mcqsNeeded; i++) {
            indices.add(numbers.get(random.nextInt(totalLines/7)));
        }

        return indices; //Arraylist returned having atarting indexes of mcqs in "mcq" arraylist.
    }
}
