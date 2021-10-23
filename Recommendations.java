import java.util.ArrayList;

public class Recommendations {
    private final int CAFFEINE_LIMIT = 400;
    public int caffeineLeft;
    public User person;
    private ArrayList<Coffee> firstRec;
    private ArrayList<Coffee> secondRec;

    public Recommendations(User person) {
        this.person = person;
        this.caffeineLeft = CAFFEINE_LIMIT - person.getCaffeineIntake();
        firstRec = createFirstRec();
        secondRec = createSecondRec();
    }

    public ArrayList<Coffee> createFirstRec() { //TODO: do something when nothing meets the requirements
        ArrayList<Coffee> meetReqs = new ArrayList<Coffee>();

        for(int i = 0; i < Coffee.getDrinksList().size(); i++) {
            Coffee c = Coffee.getDrinksList().get(i);
            if (c.getCaffeine() <= (caffeineLeft/2.0)) {
                meetReqs.add(c);
            }
        }
        return meetReqs;
    }

    public ArrayList<Coffee> createSecondRec() { //TODO: do something when nothing meets the requirements
        ArrayList<Coffee> meetReqs = new ArrayList<Coffee>();

        for(int i = 0; i < Coffee.getDrinksList().size(); i++) {
            Coffee c = Coffee.getDrinksList().get(i);
            if (!firstRec.contains(c) && c.getCaffeine() <= (caffeineLeft)) {
                meetReqs.add(c);
            }
        }
        return meetReqs;
    }





}
