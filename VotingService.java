import java.util.*;
//class used for the poll
public class VotingService {
    private IVote question;
    private Map<String, Integer> answerToCountMap;
    private Set<String> studentIDs;

    public VotingService(IVote question) {
        this.question = question;
        this.answerToCountMap = new HashMap<>();
        this.studentIDs = new HashSet<>();
        for (String choice : question.getChoices()) { //ensure the keys are unique
            this.answerToCountMap.put(choice, 0);
        }
    }

    public void submitAnswer(Student student, String answer) {
        studentIDs.add(student.getId());
        if (question instanceof MultipleChoiceQuestion) {
            String[] selectedChoices = answer.split(",");
            for (String choice : selectedChoices) {
                incrementChoiceCount(choice);
            }
        } else {
            incrementChoiceCount(answer);
        }
    }

    private void incrementChoiceCount(String choice) {
        if (answerToCountMap.containsKey(choice)) {
            answerToCountMap.put(choice, answerToCountMap.get(choice) + 1);
        }
    }
//prints the results of the poll
    public void printResults() {
        System.out.println(studentIDs.size() + " students took part in the poll");
        for (String answer : question.getChoices()) {
            int count = answerToCountMap.get(answer);
            System.out.println(answer + " : " + count);
        }
    }
}