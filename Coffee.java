import java.util.ArrayList;

public class Coffee {
    private String type;
    private int caffeine;
    private int size;
    private static ArrayList<Coffee> DRINKS = new ArrayList<Coffee>();//TODO: add drinks to array

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
        if (other != null && other instanceof Coffee) {
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
    public boolean checkDrink(Coffee c) {
        for (int i = 0; i < DRINKS.size(); i++) {
            if(c.equals(DRINKS.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void addDrink(Coffee c) {
        if (!checkDrink(c)) {
            DRINKS.add(c);
        }
    }





}
