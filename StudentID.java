import java.util.Random;

public class StudentID {
    public String generateRandomID() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000)); //4 digit sutdentID 0000-9999
    }
}
