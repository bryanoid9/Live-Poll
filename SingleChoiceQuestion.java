import java.util.List;
//class for single choice questions
public class SingleChoiceQuestion extends Question {
    public SingleChoiceQuestion(String questionText, List<String> choices) {
        super(questionText, choices);
    }

    @Override
    public boolean isValidAnswer(String answer) {
        return choices.contains(answer);
    }
}
