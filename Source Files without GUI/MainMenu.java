/*
Objects of all modules are creacted here. Almost all the data displayed on console is controlled from here.
 */
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    ChapterWiseTest chapterWiseTest;
    HalfBookTest halfBookTest;
    FullBookTest fullBookTest;
    FullTest fulltest;

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        String message = "Welcome to this free application for entrance test preparation. Select from below options to conitnue.";
        System.out.println(message);

        /* Options variables start*/
        final String option1 = "Practice Tests";

            final String suboption1_1 = "Chapterwise Test";
            final String suboption1_2 = "Half Book Test";
            final String suboption1_3 = "Full Book Test";
            final String suboption1_4 = "Full Subject Test";

        final String option2 = "Monitor Performance";
        final String option3 = "Aggregate Calculator";
        /* Options variables end*/

        /*Display messages for main menu start*/
        String options = "1. "+option1+"\n2. "+option2+"\n3. "+option3;
        System.out.println(options);
        String suboptions1 = "1. "+suboption1_1+"\n2. "+suboption1_2+"\n3. "+suboption1_3+"\n4. "+suboption1_4;
        /*Display messages for main menu end*/

        /* input variables for tests start*/
        String subject = null;
        int chapter = 0;
        int year = 0; //Variable to store information weither test is from first year or second year
        /* input variables for tests end*/

        //Variables for switch statements
        String selectedOption = null;
        String selectedSubOption = null;
        String subjectSwitchVar = null;
        //Input of Main Option (NOT WORKING CODE, JUST FOR TESTING INPUT)
        //Write same input as strings written in above option strings
        selectedOption = sc.nextLine().toLowerCase().trim();

        switch (selectedOption){

            case "1": //Practice tests

                System.out.println(suboptions1);

                //Input of SubOption (Not working code, just for testing)
                //Write same input as strings written in above option strings
                selectedSubOption = sc.nextLine().trim().toLowerCase();

                switch(selectedSubOption){
                    case "1": //Chapter wise
                        year= inputBookNo();
                        subject = inputSubject();

                        switch(subject){
                        case "physics": // Physics
                            System.out.println("Choose Chapter:");
                            if(year == 1)
                                for(int chapterNo = 1; chapterNo <= 11 ; chapterNo++) //Part 1 has 11 chapters
                                    System.out.println("\t"+chapterNo+". Chapter # "+chapterNo);
                            if(year == 2)
                                for(int chapterNo = 1; chapterNo <= 10 ; chapterNo++) //Part 2 has 10 chapters
                                    System.out.println("\t"+chapterNo+". Chapter # "+chapterNo);
                            break;
                        case "chemistry": //Chemistry
                            System.out.println("Choose Chapter:");
                            if(year == 1)
                                for(int chapterNo = 1; chapterNo <= 11 ; chapterNo++)
                                    System.out.println("\t"+chapterNo+". Chapter # "+chapterNo);
                            if(year == 2)
                                for(int chapterNo = 1; chapterNo <= 16 ; chapterNo++)
                                    System.out.println("\t"+chapterNo+". Chapter # "+chapterNo);
                            break;
                        case "mathematics": //Mathematics
                            System.out.println("Choose Chapter:");
                            if(year == 1)
                                for(int chapterNo = 1; chapterNo <= 14 ; chapterNo++)
                                    System.out.println("\t"+chapterNo+". Chapter # "+chapterNo);
                            if(year == 2)
                                for(int chapterNo = 1; chapterNo <= 7 ; chapterNo++)
                                    System.out.println("\t"+chapterNo+". Chapter # "+chapterNo);
                            break;
                        case "biology": //Biology
                            System.out.println("Choose Chapter:");
                            if(year == 1)
                                for(int chapterNo = 1; chapterNo <= 14 ; chapterNo++)
                                    System.out.println("\t"+chapterNo+". Chapter # "+chapterNo);
                            if(year == 2)
                                for(int chapterNo = 1; chapterNo <= 13 ; chapterNo++)
                                    System.out.println("\t"+chapterNo+". Chapter # "+chapterNo);
                            break;
                            default:
                                System.err.println("Wrong menu item selection!");
                                sc.next();
                                System.exit(1);
                        }
                        chapter = sc.nextInt();
                        takeChapterWiseTest(subject,chapter, year); //Method to take chapter wise test
                        break;

                    case "2": //Half book
                        year = inputBookNo();
                        subject = inputSubject();
                        chapter = inputWhichHalf();
                        takeHalfBookTest(subject, year, chapter);
                        break;

                    case "3":
                        subject = inputSubject();
                        year = inputBookNo();
                        takeFullBookTest(subject, year);
                        break;

                    case "4":
                        subject = inputSubject();
                        takeFullTest(subject,2);
                        break;

                    default:
                        System.err.println("Wrong sub option selection in tests option");
                }

                break;
            case "2":
                int option = 0;
                boolean flag = false;
                do {
                    try {
                        System.out.println("Select an option:");
                        System.out.println("1. Show Subjectwise Performance\n2. Show Combined Performance");
                        option = Integer.parseInt(sc.nextLine().trim());
                        if (option == 1 || option == 2)
                            flag = false;
                    }
                    catch(Exception e ) {
                        flag = true;
                    }
                }while(flag);

                switch(option){

                    case 1:

                        subject = inputSubject();
                        int choice;

                        switch (subject){

                            case "physics":

                                System.out.println("1. Chapterwise Tests Progress\n2. Half Book Tests Progress\n3. Full Book Tests Progress\n" +
                                        "4. Full Tests Progress");
                                choice = sc.nextInt();
                                switch(choice){
                                    case 1:
                                        showPerformanceChart("chapterwise","physics");
                                        break;
                                    case 2:
                                        showPerformanceChart("halfbook","physics");
                                        break;
                                    case 3:
                                        showPerformanceChart("fullbook","physics");
                                        break;
                                    case 4:
                                        showPerformanceChart("full","physics");
                                        break;
                                }
                                break;

                            case "chemistry":

                                System.out.println("1. Chapterwise Tests Progress\n2. Half Book Tests Progress\n3. Full Book Tests Progress\n" +
                                        "4. Full Tests Progress");
                                choice = sc.nextInt();

                                switch(choice){
                                    case 1:
                                        showPerformanceChart("chapterwise","chemistry");
                                        break;
                                    case 2:
                                        showPerformanceChart("halfbook","chemistry");
                                        break;
                                    case 3:
                                        showPerformanceChart("fullbook","chemistry");
                                        break;
                                    case 4:
                                        showPerformanceChart("full","chemistry");
                                        break;
                                }
                                break;

                            case "mathematics":

                                System.out.println("1. Chapterwise Tests Progress\n2. Half Book Tests Progress\n3. Full Book Tests Progress\n" +
                                        "4. Full Tests Progress");
                                choice = sc.nextInt();

                                switch(choice){
                                    case 1:
                                        showPerformanceChart("chapterwise","mathematics");
                                        break;
                                    case 2:
                                        showPerformanceChart("halfbook","mathematics");
                                        break;
                                    case 3:
                                        showPerformanceChart("fullbook","mathematics");
                                        break;
                                    case 4:
                                        showPerformanceChart("full","mathematics");
                                        break;
                                }
                                break;

                            case "biology":

                                System.out.println("1. Chapterwise Tests Progress\n2. Half Book Tests Progress\n3. Full Book Tests Progress\n" +
                                        "4. Full Tests Progress");
                                choice = sc.nextInt();

                                switch(choice){
                                    case 1:
                                        showPerformanceChart("chapterwise","biology");
                                        break;
                                    case 2:
                                        showPerformanceChart("halfbook","biology");
                                        break;
                                    case 3:
                                        showPerformanceChart("fullbook","biology");
                                        break;
                                    case 4:
                                        showPerformanceChart("full","biology");
                                        break;
                                }
                                break;
                        }
                        break;
                    case 2: //Performance Item 2 | Combined performance

                        System.out.println("1. Chapterwise Tests Progress\n2. Half Book Tests Progress\n3. Full Book Tests Progress\n" +
                                "4. Full Tests Progress");
                        choice = sc.nextInt();

                        switch(choice){
                            case 1:
                                showPerformanceChart("chapterwise");
                                break;
                            case 2:
                                showPerformanceChart("halfbook");
                                break;
                            case 3:
                                showPerformanceChart("fullbook");
                                break;
                            case 4:
                                showPerformanceChart("full");
                                break;
                        }
                        break;
                }
                    break;
            case "3": //Main menu item 3
                AggregateCalculators calculators = new AggregateCalculators();
                calculators.run();
                break;
            default:
                System.err.println("Wrong menu item selection!");
        }
    }

    public void takeChapterWiseTest(String subject, int chapter, int year) {
        chapterWiseTest = new ChapterWiseTest(subject, chapter, year);
        chapterWiseTest.takeTest();
        System.out.println("Test Ended.");
        chapterWiseTest.writePercentageForHistory();
        //Displaying marks on a chart
        TestProgressChart chartProgress = new TestProgressChart(chapterWiseTest.getTotalMCQS(),chapterWiseTest.getCorrectMCQS(), chapterWiseTest.getIncorrectMCQS(),0);
        try {
            chartProgress.run();
        }
        catch(IOException e){
            System.err.println("Error: Could not display progress details!\nKindly Try Again.");
        }
    }


    public void takeHalfBookTest(String subject, int year, int whichHalf) {
        halfBookTest = new HalfBookTest(subject , year, whichHalf, 3);  //Change Mcqs per chapter in half book test from here
        halfBookTest.takeTest();
        System.out.println("Test Ended.");
        halfBookTest.writePercentageForHistory();
        TestProgressChart chartProgress = new TestProgressChart(halfBookTest.getTotalMCQS(),halfBookTest.getCorrectMCQS(), halfBookTest.getIncorrectMCQS(),0);

        try {
            chartProgress.run();
        }
        catch(IOException e){
            System.err.println("Error: Could not display progress details!\nKindly Try Again.");
        }
    }

    public void takeFullBookTest(String subject, int year) {
        fullBookTest = new FullBookTest(subject , year, 3); //Change Mcqs per chapter in full book test from here
        fullBookTest.takeTest();
        System.out.println("Test Ended.");
        fullBookTest.writePercentageForHistory();
        TestProgressChart chartProgress = new TestProgressChart(fullBookTest.getTotalMCQS(),fullBookTest.getCorrectMCQS(), fullBookTest.getIncorrectMCQS(),0);
        try {
            chartProgress.run();
        }
        catch(IOException e){
            System.err.println("Error: Could not display progress details!\nKindly Try Again.");
        }
    }

    public void takeFullTest(String subject, int numberOfMCQS) {
        fulltest = new FullTest(subject , numberOfMCQS);
        fulltest.takeTest();
        System.out.println("Test Ended.");
        fulltest.writePercentageForHistory(fulltest.getSubject());
        TestProgressChart chartProgress = new TestProgressChart(fulltest.getTotalMCQS(),fulltest.getCorrectMCQS(), fulltest.getIncorrectMCQS(),0);
        try {
            chartProgress.run();
        }
        catch(IOException e){
            System.err.println("Error: Could not display performance details!\nKindly Try Again.");
        }
    }


    public String inputSubject(){
        String subject = null;
        String subjectSwitchVar;
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do {
            try{
                System.out.println("Select Subject Number:"); //Add subjects list here and remove scanner
                System.out.println("1. Physics\n2. Chemistry\n3. Mathematics\n4. Biology");
                subjectSwitchVar = sc.nextLine().trim();
                if (Integer.parseInt(subjectSwitchVar) > 0 && Integer.parseInt(subjectSwitchVar) <= 4) {
                    if (subjectSwitchVar.equals("1"))
                        subject = "physics";
                    if (subjectSwitchVar.equals("2"))
                        subject = "chemistry";
                    if (subjectSwitchVar.equals("3"))
                        subject = "mathematics";
                    if (subjectSwitchVar.equals("4"))
                        subject = "biology";
                    flag = false;
                }
                else
                    flag = true;}
            catch(Exception e) {
                flag = true;
            }
        } while(flag);

        return subject;
    }

    public int inputBookNo(){
        boolean flag = false;
        int year = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Choose Book:");
                System.out.println("1. Part One\n2. Part Two");
                year = Integer.parseInt(sc.nextLine().trim());
                if (year == 1 || year == 2)
                    flag = false;
            }
            catch(Exception e){
                flag = true;
            }
        }while(flag);
        return year;
    }

    public int inputWhichHalf(){
        int whichHalf = 0;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Choose Half Book:");
                System.out.println("1. First Half\n2. Second Half");
                whichHalf = Integer.parseInt(sc.nextLine().trim());
                if (whichHalf == 1 || whichHalf == 2)
                    flag = false;
            }
            catch(Exception e ) {
                flag = true;
            }
        }while(flag);

        return whichHalf;
    }

    public void showPerformanceChart(String testType){
        AllTestsProgressChart progressChart1 = new AllTestsProgressChart(testType);
        progressChart1.run();
    }

    public void showPerformanceChart(String testType, String subject){
        AllTestsProgressChart progressChart1 = new AllTestsProgressChart(testType, subject);
        progressChart1.run();
    }
}

