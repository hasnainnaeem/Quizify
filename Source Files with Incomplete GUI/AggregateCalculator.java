public class AggregateCalculator
{
    private double Marks;
    private double MarksTotal;
    private double Marks2;
    private double Marks2Total;
    private double EntryTest;
    private double TotalET;
    private int Discipline;


    public double AggregateUET()
    {
        double Agg = 0;

        switch (Discipline)
        {
            case 1:
            case 3:
                Agg = (Marks2 * 70/Marks2Total) + (EntryTest * 30/TotalET);
                break;

            case 2:
            case 4:
                Agg = (Marks2 * 70/Marks2Total) + (EntryTest * 30/TotalET);
                break;
            default:
		return 0;
        }
        return Agg;
    }

    public double AggregateNUST()
    {
        double Agg = 0;

        switch (Discipline)
        {
            case 1:
            case 3:
        	Agg = (Marks2 / Marks2Total) * 15 + (EntryTest / TotalET)  * 75 + (Marks / MarksTotal) * 10;
                break;

            case 2:
            case 4:
        	Agg = (Marks2 / Marks2Total) * 15 + (EntryTest / TotalET)  * 75 + (Marks / MarksTotal) * 10;
                break;
                
            default:
		Agg = 0;
		break;
	}
       	 return Agg;
        }


    

    public double AggregateFAST()
    {
        double Agg = 0;
        switch (Discipline)
        {
	case 1:
	case 3:
        	Agg = (Marks2 / Marks2Total) * 50 + (EntryTest / TotalET)  * 50;
                break;

	case 2:
	case 4:      
        	Agg = (Marks2 / Marks2Total) * 50 + (EntryTest / TotalET)  * 50;
		break;
	default:
		Agg = 0;
                }
        return Agg;
        }

    

    public double AggregateCOMSATS()
    {
        double Agg;

        Agg = (Marks2 / Marks2Total) * 40 + (EntryTest / TotalET)  * 50 + (Marks / MarksTotal) * 10;

        return Agg;
    }


	public AggregateCalculator (int Marks, int MarksTotal, int Marks2, int Marks2Total, int EntryTest, int TotalET, String Discipline) {
		this.Marks = (double) Marks;
		this.MarksTotal = (double) MarksTotal;
		this.Marks2 = (double) Marks2;
		this.Marks2Total = (double) Marks2Total;
		this.EntryTest = (double) EntryTest;
		this.TotalET = (double) TotalET;
		
		switch (Discipline) {
			case "Matric and F.Sc.":
				this.Discipline = 1; break;
			case "O Level and A Level":
				this.Discipline = 2; break;
			case "O Level and F.Sc.":
				this.Discipline = 3; break;
			case "Matric and A Level":
				this.Discipline = 4; break;
			default:
				this.Discipline = 1; break;
		}
	}
}
