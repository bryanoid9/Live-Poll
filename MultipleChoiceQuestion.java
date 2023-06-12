import java.util.List;
//class used for multiple choice questions
public class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String questionText, List<String> choices) {
        super(questionText, choices);
    }

    @Override
    public boolean isValidAnswer(String answer) {
        String[] selectedChoices = answer.split(",");
        for (String choice : selectedChoices) {
            if (!choices.contains(choice.trim())) {
                return false;
            }
        }
        return true;
    }
}
