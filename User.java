import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Coffee> consumedList = new ArrayList<Coffee>();
    private ArrayList<Coffee> favorites = new ArrayList<Coffee>();
    private int points;
    private int caffeineIntake;
    
    public User(String name, ArrayList<Coffee> consumedList, ArrayList<Coffee> favorites, int points) {
        this.name = name;
        this.consumedList = consumedList;
        this.favorites = favorites;
        this.points = points;
        
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

    public void selectDrink(Coffee c) {
        if (Coffee.getDrinksList().contains(c)) {
            addCaffeine(c);
        }
        else {
            Coffee.addDrink(c);
            addCaffeine(c);
        }
    }

    public void addCaffeine(Coffee name) {
        caffeineIntake += name.getCaffeine();
    }
}