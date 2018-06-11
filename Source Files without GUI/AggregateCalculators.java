import java.util.Scanner;

public class AggregateCalculators
{
    Scanner read = new Scanner(System.in);
    private double Marks;
    private double TotalMarks;
    private double EntryTest;
    private double TotalET;
    private int Discipline;

    public void setEntryTest()
    {
        while(true)
        {
            try
            {
                System.out.println("Please Enter the marks you obtained in your Entry test: ");
                EntryTest = read.nextDouble();

                System.out.println("Please Enter the total marks of the test: ");
                TotalET = read.nextDouble();

                if ((EntryTest > TotalET) || (EntryTest < 0) || (TotalET < 0))
                    throw new Exception();
                else
                    break;
            }
            catch (Exception ex)
            {
                System.out.println("\nInvalid Input.... Try Again!!!\n");
            }
        }

    }

    public void setDiscipline()
    {
        while(true)
        {
            try
            {
                System.out.println("Please choose your Discipline/Educational Background");
                System.out.println("1. Matric - FSc\n2. O level - A level\n3. O level - FSc\n4. Matric - A level :");
                Discipline = read.nextInt();

                if ( (Discipline < 1) || (Discipline > 4))
                    throw new Exception();
                else
                    break;
            }
            catch (Exception ex)
            {
                System.out.println("\nInvalid Input.... Try Again!!!\n");
            }
        }

    }

    public void getMark()
    {
        while (true)
        {
            try
            {
                System.out.println("Please enter the marks you obtained in your FSc/A level Equivalence: ");
                Marks = read.nextDouble();

                System.out.println("Please enter the Total Marks in your FSc/A level Equivalence: ");
                TotalMarks = read.nextDouble();

                if ((Marks > TotalMarks) || (Marks < 0) || (TotalMarks < 0))
                    throw new Exception();
                else
                    break;
            }
            catch (Exception ex)
            {
                System.out.println("\nInvalid Input.... Try Again!!!\n");
            }
        }

    }

    public void getMarks()
    {
        while (true)
        {
            try
            {
                System.out.println("Please enter the marks you obtained in your Matric/O level Equivalence: ");
                Marks = read.nextDouble();

                System.out.println("Please enter the Total Marks in your Matric/O level Equivalence: ");
                TotalMarks = read.nextDouble();

                if ((Marks > TotalMarks) || (Marks < 0) || (TotalMarks < 0))
                    throw new Exception();
                else
                    break;
            }
            catch (Exception ex)
            {
                System.out.println("\nInvalid Input.... Try Again!!!\n");
            }
        }
    }

    public double AggregateUET()
    {
        double Agg = 0;

        setEntryTest();
        setDiscipline();
        switch (Discipline)
        {
            case 1:
            case 3:
                getMark();
                Agg = (Marks * 70/TotalMarks) + (EntryTest * 30/TotalET);
                break;

            case 2:
            case 4:
                getMarks();
                Agg = (Marks * 70/TotalMarks) + (EntryTest * 30/TotalET);
                break;
            default:
                System.out.println("Invalid Choice");
        }
        return Agg;
    }

    public double AggregateNUST()
    {
        double Agg = 0;

        setEntryTest();
        setDiscipline();
        getMarks();

        switch (Discipline)
        {
            case 1:
            case 3:

                Agg = (Marks * 10/TotalMarks);

                getMark();
                Agg = Agg + (Marks * 15/TotalMarks) +(EntryTest * 75/TotalET);
                break;

            case 2:
            case 4:

                int A;
                System.out.println("Is your A level result announced? (1. Yes / 2. No)");
                A = read.nextInt();

                switch (A)
                {
                    case 1:
                        Agg = (Marks * 10/TotalMarks);

                        getMark();
                        Agg = Agg + (Marks * 15/TotalMarks) +(EntryTest * 75/TotalET);
                        break;

                    case 2:
                        Agg = (Marks * 25/TotalMarks) + (EntryTest * 75/TotalET);
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            default:
                System.out.println("Invalid Choice");
        }

        return Agg;
    }

    public double AggregateFAST()
    {
        double Agg = 0;

        setEntryTest();
        setDiscipline();

        switch (Discipline)
        {
            case 1:
            case 3:
                getMark();
                Agg = (Marks * 50/TotalMarks) + (EntryTest * 50/TotalET);
                break;

            case 2:
            case 4:
                int A;
                System.out.println("Is your A level result announced? (1. Yes / 2. No)");
                A = read.nextInt();

                switch (A)
                {
                    case 1:

                        getMark();
                        Agg = Agg + (Marks * 50/TotalMarks) +(EntryTest * 50/TotalET);
                        break;

                    case 2:
                        getMarks();
                        Agg = ((Marks * 0.9) * 50/TotalMarks) + (EntryTest * 50/TotalET);
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
        }
        return Agg;
    }

    public double AggregateCOMSATS()
    {
        double Agg;

        setEntryTest();


        getMark();
        Agg = (Marks * 40/TotalMarks) + (EntryTest * 50/TotalET);

        getMarks();
        Agg = Agg + (Marks * 10/TotalMarks);

        System.out.println("\n!!Please deduct 2 points for every gap year taken as per COMSATS policy!!\n");
        return Agg;
    }

    public void run() {
        AggregateCalculators calculator = new AggregateCalculators(); //Object to call methods of this class

        System.out.println("Select University:");
        String universities = "1. UET\n2. Nust\n3. Fast\n4. Comsats";
        System.out.println(universities);

        int choice = read.nextInt();
        boolean flag = true;
        while (flag) {
            switch (choice) {
                case 1:
                    System.out.println("\nYour Aggregate: "+calculator.AggregateUET());
                    flag = false;
                    break;
                case 2:
                    System.out.println("\nYour Aggregate: "+calculator.AggregateNUST());
                    flag = false;
                    break;
                case 3:
                    System.out.println("\nYour Aggregate: "+calculator.AggregateFAST());
                    flag = false;
                    break;
                case 4:
                    System.out.println("\nYour Aggregate: "+calculator.AggregateCOMSATS());
                    break;
                default:
                    System.out.println("Wrong University Selection. Please Try Again.");
                    flag = true;
            }
        }
    }
}