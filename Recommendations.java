import java.util.ArrayList;

public class Recommendations {
    private final int CAFFEINE_LIMIT = 400;
    public int caffeineLeft;
    public User person;

    public Recommendations(User person) {
        this.person = person;
        this.caffeineLeft = CAFFEINE_LIMIT - person.getCaffeineIntake();
    }



}
