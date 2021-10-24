import java.util.ArrayList;

public class Coffee {
    private String type;
    private int caffeine; // measured in mg
    private int size; // measured in oz
    static Coffee c1 = new Coffee("Brewed Coffee", 95, 8);
    static Coffee c2 = new Coffee("Espresso", 64, 1);
    static Coffee c3 = new Coffee("Instant Coffee", 62, 8);//TODO: change this and brewed coffee's caffeine intake back to its actual values
    static Coffee c4 = new Coffee("Brewed Decaf Coffee", 2, 8);
    static Coffee stb1 = new Coffee("Caffe Americano", 150, 12);
    static Coffee stb2 = new Coffee("Blonde Roast", 270, 12);
    static Coffee stb3 = new Coffee("Cappuccino", 150, 16);
    static Coffee stb4 = new Coffee("Flat White", 130, 12);
    static Coffee stb5 = new Coffee("Caffe Latte", 75, 12);
    static Coffee stb6 = new Coffee("Caramel Macchiato", 75, 12);
    static Coffee stb7 = new Coffee("Caffe Latte", 75, 12);
    static Coffee stb8 = new Coffee("Caffe Mocha", 95, 12);
    static Coffee stb9 = new Coffee("White Chocolate Mocha", 75, 12);

    


    private static ArrayList<Coffee> DRINKS = new ArrayList<Coffee>(); //TODO: add drinks to array

    //constructor
    public Coffee(String type, int caffeine, int size){
        this.type = type;
        this.caffeine = caffeine;
        this.size = size;
    }

    public static void addData() {
        Coffee.addDrink(c1);
        Coffee.addDrink(c2);
        Coffee.addDrink(c3);
        Coffee.addDrink(c4);
        Coffee.addDrink(stb1);
        Coffee.addDrink(stb2);
        Coffee.addDrink(stb3);
        Coffee.addDrink(stb4);
        Coffee.addDrink(stb5);
        Coffee.addDrink(stb6);
        Coffee.addDrink(stb7);
        Coffee.addDrink(stb8);
        Coffee.addDrink(stb9);
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
