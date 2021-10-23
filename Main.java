import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Coffee.addData();
        UI hello = new UI();
        hello.displayRecs();
        hello.inputChoice();
    }
}