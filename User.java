import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Coffee> consumedList = new ArrayList<Coffee>();
    private ArrayList<Coffee> favorites = new ArrayList<Coffee>();
    private int points;
    private int caffeineIntake;
    
    public User(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public void addToFavorites(Coffee c) {
        if (!(favorites.contains(c))) {
            favorites.add(c);
            System.out.println("Got it! " + c.getType() + " is now in your favorites.");
        }
        else {
            System.out.println(c.getType() + " has already been added to your favorites!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Coffee> getConsumedList() {
        return consumedList;
    }

    public void setConsumedList(Coffee name) {
        consumedList.add(name);
    }

    public ArrayList<Coffee> getFavorites() {
        return favorites;
    }

    public void setFavorites(Coffee name) {
        favorites.add(name);
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void subtractPoints(int points) {
        this.points -= points;
    }

    public int getCaffeineIntake() {
        return caffeineIntake;
    }

    public void setCaffeineIntake(int caffeineIntake) {
        this.caffeineIntake = caffeineIntake;
    }
    
}