import java.util.Random;
import java.util.Arrays;
import java.util.*;
//SimulationDriver used to simulate the polling
public class SimulationDriver {
    public static void main(String[] args) {
        // Single Choice Question
        IVote singleChoiceQuestion = new SingleChoiceQuestion(
            "Which country won the most football World Cups?",
            Arrays.asList("A. Mexico", "B. Portugal", "C. Argentina", "D. Brazil")
        );
        
        // Multiple Choice Question
        IVote multipleChoiceQuestion = new MultipleChoiceQuestion(
            "Which of the following are programming languages?",
            Arrays.asList("A. HTML", "B. Python", "C. Java", "D. C++")
        );

        System.out.println("=== SINGLE CHOICE QUESTION ===");
        runSimulation(singleChoiceQuestion);
        System.out.println("=== MULTIPLE CHOICE QUESTION ===");
        runSimulation(multipleChoiceQuestion);
    }
//method used to simulate the question
    public static void runSimulation(IVote question) {
        // Configure the question for iVote Service
        VotingService votingService = new VotingService(question);

        // Randomly generate a number of students and the answers
        int numStudents = new Random().nextInt(21) + 5;  // Random number between 5 and 25 students
        for (int i = 0; i < numStudents; i++) {
            String studentId = "s" + (i+1);
            Student student = new Student(studentId);
            String answer = student.makeChoice(question);

            // Submit all the student answers to iVote Service
            votingService.submitAnswer(student, answer);
        }

        // Call the Voting Service output function to display the result
        votingService.printResults();
    }
}
