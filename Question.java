import java.util.List;

public abstract class Question implements IVote {
    protected String questionText; //text of question
    protected List<String> choices; //choices given

    public Question(String questionText, List<String> choices) {
        this.questionText = questionText;
        this.choices = choices;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getChoices() {
        return choices;
    }
}
