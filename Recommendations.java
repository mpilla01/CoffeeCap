import java.util.ArrayList;

public class Recommendations {
    private final int CAFFEINE_LIMIT = 400;
    private int caffeineLeft;
    public User person;
    private ArrayList<Coffee> firstRec;
    private ArrayList<Coffee> secondRec;

    public Recommendations(User person) {
        this.person = person;
        this.caffeineLeft = CAFFEINE_LIMIT - person.getCaffeineIntake();
        if (this.caffeineLeft > 0) {
            firstRec = createFirstRec();
            secondRec = createSecondRec();
        } else {
            System.out.println("Drink wisely!");
        }
    }

    private ArrayList<Coffee> createFirstRec() { //TODO: do something when nothing meets the requirements
        ArrayList<Coffee> meetReqsFav = new ArrayList<Coffee>();
        ArrayList<Coffee> meetReqsReg = new ArrayList<Coffee>();
        ArrayList<Coffee> meetReqs = new ArrayList<Coffee>();

        if(!Coffee.getDrinksList().contains(null)) {
            for(int i = 0; i < Coffee.getDrinksList().size(); i++) {
                Coffee c = Coffee.getDrinksList().get(i);
                if (c.getCaffeine() <= (caffeineLeft/2.0) && person.getFavorites().contains(c)) {
                    meetReqsFav.add(c);
                }
                else if(c.getCaffeine() <= (caffeineLeft/2.0)) {
                    meetReqsReg.add(c);
                }
            }
        }
        meetReqs.addAll(meetReqsFav);
        meetReqs.addAll(meetReqsReg);
        return meetReqs;
    }

    private ArrayList<Coffee> createSecondRec() { //TODO: do something when nothing meets the requirements
        ArrayList<Coffee> meetReqsFav = new ArrayList<Coffee>();
        ArrayList<Coffee> meetReqsReg = new ArrayList<Coffee>();
        ArrayList<Coffee> meetReqs = new ArrayList<Coffee>();

        if(!Coffee.getDrinksList().contains(null)) {
            for(int i = 0; i < Coffee.getDrinksList().size(); i++) {
                Coffee c = Coffee.getDrinksList().get(i);
                if (!(firstRec.contains(c)) && (c.getCaffeine() <= (caffeineLeft) && person.getFavorites().contains(c))) {
                    meetReqsFav.add(c);
                } else if(!(firstRec.contains(c)) && c.getCaffeine() <= (caffeineLeft)) {
                    meetReqsReg.add(c);
                }
            }
        }
        meetReqs.addAll(meetReqsFav);
        meetReqs.addAll(meetReqsReg);
        return meetReqs;
    }

    //getters 
    public ArrayList<Coffee> getFirstRec() {
        return firstRec;
    }

    public ArrayList<Coffee> getSecondRec() {
        return secondRec;
    }

    public int getCaffeineLeft() {
        return caffeineLeft;
    }

    //array printer
    public void printArray(ArrayList<Coffee> cArr, int levelNum) {
        int i = 0;
        for (Coffee c : cArr) {
            i++;
            System.out.println(levelNum + "." + i + " ~~ " + c.getType() + " with caffeine content of " + c.getCaffeine() + "mg.");
        }
    }

    //select drink
    public void selectDrink(Coffee c) {
        if (Coffee.getDrinksList().contains(c)) {
            addCaffeine(c);
            person.setConsumedList(c);
        }
        else {
            Coffee.addDrink(c);
            addCaffeine(c);
            person.setConsumedList(c);
        }
        caffeineLeft -= c.getCaffeine();
        if (firstRec.contains(c)) {
            person.addPoints(100);
        }
        else if(secondRec.contains(c)) {
            person.addPoints(50);
        }
    }

    public void addCaffeine(Coffee type) {
        person.setCaffeineIntake(person.getCaffeineIntake() + type.getCaffeine());
    }
}
