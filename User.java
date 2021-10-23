public class User {
    private String name;
    private Coffee[] drank;
    private Coffee[] favorites;
    private int points;
    
    public User(String name, Coffee[] drank, Coffee[] favorites, int points) {
        this.name = name;
        this.drank = drank;
        this.favorites = favorites;
        this.points = points;
    }
}