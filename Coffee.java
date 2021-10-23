import java.util.ArrayList;

public class Coffee {
    private String type;
    private int caffeine; // measured in mg
    private int size; // measured in oz
    
    static Coffee c1 = new Coffee("Brewed Coffee", 95, 8);
    static Coffee c2 = new Coffee("Espresso", 64, 1);
    static Coffee c3 = new Coffee("Instant Coffee", 62, 8);
    static Coffee c4 = new Coffee("Brewed Decaf Coffee", 2, 8);
    private static ArrayList<Coffee> DRINKS = new ArrayList<Coffee>(); //TODO: add drinks to array
    DRINKS.add(c1);
    DRINKS.add(c2);
    DRINKS.add(c3);
    DRINKS.add(c4);
    
    //constructor
    public Coffee(String type, int caffeine, int size){
        this.type = type;
        this.caffeine = caffeine;
        this.size = size;
    }

    //getters
    public String getType() {
        return type;
    }

    public int getCaffeine() {
        return caffeine;
    }

    public int getSize() {
        return size;
    }

    public static ArrayList<Coffee> getDrinksList() {
        return DRINKS;
    }


    //setters
    public void setType(String type) {
        this.type = type;
    }

    public void setCaffeine(int caffeine) {
        this.caffeine = caffeine;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Coffee) {
            Coffee cOther = (Coffee) other;
            if (this.type.equals(cOther.type) 
                && this.caffeine == cOther.caffeine
                && this.size == cOther.size) {
                    return true;
            }
        }
        return false;
    }

    
    //arraylist drinks modifiers
    public static boolean checkDrink(Coffee c) {//TODO: take this out if not needed
        for (int i = 0; i < DRINKS.size(); i++) {
            if(c.equals(DRINKS.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static void addDrink(Coffee c) {
        if (!checkDrink(c)) {
            DRINKS.add(c);
        }
    }

}
