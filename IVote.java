import java.util.List;
//interface of a voting questiomn
public interface IVote {
    String getQuestionText(); //gets the etxt of the question
    List<String> getChoices(); //gets the choices for quesgion
    boolean isValidAnswer(String answer);
}
