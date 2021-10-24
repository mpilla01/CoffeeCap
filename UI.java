import java.util.Scanner;

public class UI {
    public User person;
    public Recommendations recs;

    Scanner input = new Scanner(System.in);
    public UI() {
        System.out.print("Good morning! What is your username? ");
        String name = input.nextLine();
        person = new User(name, 0);
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
            System.out.println("Input a new drink #0");
            System.out.println();
        }
    }

    public void inputValid(double choice) {
        int index = ((int)((choice - (int)(choice)) * 10)) - 1;
        if ((int)choice == 1) {
            while (!(index < recs.getFirstRec().size())) {
                System.out.println("Please input a valid drink choice (i.e. 1.1): "); 
                choice = input.nextDouble();
                inputValid(choice);
            }
            recs.selectDrink(recs.getFirstRec().get(index));
        }
        if ((int)choice == 2) {
            while (!(index < recs.getSecondRec().size())) {
                System.out.println("Please input a valid drink choice (i.e. 2.1): "); 
                choice = input.nextDouble(); 
                inputValid(choice);
            }
            recs.selectDrink(recs.getSecondRec().get(index));
        }
    }

    public void inputChoice() {
        System.out.print("Please select the number associated with your coffee from your recommended lists: ");
        boolean validChoice = input.hasNextDouble();
        while (!validChoice && input.nextDouble() != 0) {
            System.out.println("Please enter your choice in a valid format (i.e. 1.2 for first level, second drink or 0 if drink not found)");
        }
        double choice = input.nextDouble();
        if (choice == 0) {
            System.out.println("Type of coffee: ");
            while(!input.hasNext()){System.out.println("Please enter the coffee type in the correct format (i.e. iced coffee): ");}
            String type = input.nextLine();
            input.nextLine();

            System.out.println("Caffeine amount (mg): ");
            while(!input.hasNextInt()){System.out.println("Please enter the caffeine amount in the correct format (i.e. 80): ");}
            int cAmount = input.nextInt();
            input.nextLine();

            System.out.println("Coffee drink size (oz): ");
            while(!input.hasNextInt()){System.out.println("Please enter the coffee drink size in the correct format (i.e. 16): ");}
            int size = input.nextInt();
            input.nextLine();

            Coffee addition = new Coffee(type, cAmount, size);
            recs.selectDrink(addition);
        }
        else {
            inputValid(choice);
        }

        System.out.println();
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
            return;
        }
    }
}
