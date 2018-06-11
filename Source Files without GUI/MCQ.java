import java.util.ArrayList;

public class MCQ {

    private String question;
    private ArrayList<String> choices;
    private char answer;
    private String solution;

    public MCQ(){
        this(null, new ArrayList<String>(),'z',null);
    }
    public MCQ(String question, ArrayList<String> choices, char answer, String solution) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
        this.solution = solution;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "MCQ{" +
                "question='" + question + '\'' +
                ", choices=" + choices +
                ", answer=" + answer +
                ", solution='" + solution + '\'' +
                '}';
    }
}
