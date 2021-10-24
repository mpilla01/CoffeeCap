import java.util.Scanner;

public class UI {
    public User person;
    public Recommendations recs;
    public Coffee drinkChoice;

    Scanner input = new Scanner(System.in);
    public UI() {
        System.out.println("Good morning!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        person = new User(name, 0);
        System.out.println("Hello, " + person.getName() + "!");
    }

    public void displayRecs() {
        recs = new Recommendations(person);
        if (recs.getFirstRec() == null && recs.getSecondRec() == null) {
            System.out.println("There are no recommended drinks left!");
            System.out.println("Input a new drink #0");
            System.out.println();
        } else if (recs.getFirstRec() == null) {
            System.out.println("Here is a list of recommended drinks: ");
            System.out.println();
            System.out.println("Second level (50 pts): ");
            recs.printArray(recs.getSecondRec(), 2);
            System.out.println();
            System.out.println("Input a new drink #0");
            System.out.println();
        } else if (recs.getSecondRec() == null) {
            System.out.println("Here is a list of recommended drinks: ");
            System.out.println();
            System.out.println("First level (100 pts): ");
            recs.printArray(recs.getFirstRec(), 1);
            System.out.println();
            System.out.println("Input a new drink #0");
            System.out.println();
        } else {
            System.out.println("Here is a list of recommended drinks: ");
            System.out.println();
            System.out.println("First level (100 pts): ");
            recs.printArray(recs.getFirstRec(), 1);
            System.out.println();
            System.out.println("Second level (50 pts): ");
            recs.printArray(recs.getSecondRec(), 2);
            System.out.println();
            System.out.println("0  ~~ Input a new drink");
            System.out.println();
        }
    }

    public void inputValid(String choice) {
        int index = Integer.parseInt(choice.substring(2)) - 1;
        if (choice.substring(0,1).equals("1")) {
            if (index < recs.getFirstRec().size()) {
                drinkChoice = recs.getFirstRec().get(index);
                recs.selectDrink(drinkChoice);
            }
            else {
                System.out.println("Please input a valid drink choice (i.e. 1.1): "); 
                choice = input.next();
                inputValid(choice);
            }
        }
        if (choice.substring(0,1).equals("2")) {
            if (index < recs.getSecondRec().size()) {
                drinkChoice = recs.getSecondRec().get(index);
                recs.selectDrink(drinkChoice);
            }
            else {
                System.out.println("Please input a valid drink choice (i.e. 2.1): "); 
                choice = input.next();
                inputValid(choice);
            }
        }
    }

    public void askFavorite(Coffee c) {
        System.out.println("Would you like to favorite this drink? (Y/N): ");
        String ans = input.next();
        if (ans.equalsIgnoreCase("Y")) {
            if(!person.getFavorites().contains(c)) {  
                person.setFavorites(c);
            }
        }
        else if (!(ans.equalsIgnoreCase("N"))) {
            System.out.println("Please input a valid choice (i.e. Y): ");
            askFavorite(c);
        }
    }

    public void inputChoice() {
        System.out.print("Please select the number associated with your coffee from your recommended lists: ");
        boolean validChoice = input.hasNextDouble();
        while (!validChoice && input.nextDouble() != 0) {
            System.out.println("Please enter your choice in a valid format (i.e. 1.2 for first level, second drink or 0 if drink not found)");
        }
        String choice = input.next();
        if (choice.equals("0")) {
            System.out.println("Type of coffee: ");
            while(!input.hasNext()){System.out.print("Please enter the coffee type in the correct format (i.e. iced coffee): ");}
            String type = input.next();
            input.nextLine();

            System.out.println("Caffeine amount (mg): ");
            while(!input.hasNextInt()){System.out.println("Please enter the caffeine amount in the correct format (i.e. 80): ");}
            int cAmount = input.nextInt();
            input.nextLine();

            System.out.println("Coffee drink size (oz): ");
            while(!input.hasNextInt()){System.out.println("Please enter the coffee drink size in the correct format (i.e. 16): ");}
            int size = input.nextInt();
            input.nextLine();

            drinkChoice = new Coffee(type, cAmount, size);
            recs.selectDrink(drinkChoice);
        }
        else {
            inputValid(choice);
        }

        System.out.println();
        askFavorite(drinkChoice);
        System.out.println("Thank you for inputting your choice! Your caffeine limit left is: " + recs.getCaffeineLeft());
        System.out.println("Your current points are: " + person.getPoints());
        System.out.println("Please press 0 to exit CoffeeCap!");
        System.out.println("Please press any other key to continue using CoffeeCap!");
        String cont = input.next();
        if(!cont.equals("0")) {
            displayRecs();
            inputChoice();
        }
        else {
            System.out.println();
            System.out.println("----------------------Thank you for using CoffeeCap!------------------------");
            return;
        }
    }
}
