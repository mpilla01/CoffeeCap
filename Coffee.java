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

    public ArrayList getDrinksList() {
        return DRINKS;
    }

    //


}
