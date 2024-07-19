import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> variants;
    private int correctAnswer;

    public Question(String question, ArrayList<String> variants, int correctAnswer) {
        this.question = question;
        this.variants = variants;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<String> variants) {
        this.variants = variants;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
