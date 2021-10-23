import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Coffee.addData();
        Scanner input = new Scanner(System.in);
        System.out.print("Good morning! What is your name? ");
        String name = input.nextLine();
        User person = new User(name, 0);  
        Recommendations recs = new Recommendations(person);
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
            if ((int)choice == 1) {
                int index = (int)(choice * 10) - 11;
                recs.selectDrink(recs.getFirstRec().get(index));
            }
            else if ((int)choice == 2) {
                int index = (int)(choice * 10) - 21;
                recs.selectDrink(recs.getSecondRec().get(index));
            }
        }

        System.out.println();
        System.out.println("Thank you for inputting your choice! Your caffeine limit left is: " + recs.getCaffeineLeft());
        System.out.println("Please press 0 to exit CoffeeCap!");
        System.out.println("Please press any other key to continue using CoffeeCap!"); 

        while(!input.nextLine().trim().equals("0")) {
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
            System.out.print("Please select the number associated with your coffee from your recommended lists: ");
            boolean validChoice1 = input.hasNextDouble();
            while (!validChoice1 && input.nextDouble() != 0) {
                System.out.println("Please enter your choice in a valid format (i.e. 1.2 for first level, second drink or 0 if drink not found)");
            }
            double choice1 = input.nextDouble();
            if (choice1 == 0) {
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
                if ((int)choice1 == 1) {
                    int index = (int)(choice1 * 10) - 11;
                    recs.selectDrink(recs.getFirstRec().get(index));
                }
                else if ((int)choice1 == 2) {
                    int index = (int)(choice1 * 10) - 21;
                    recs.selectDrink(recs.getSecondRec().get(index));
                }
            }

            System.out.println();
            System.out.println("Thank you for inputting your choice! Your caffeine limit left is: " + recs.getCaffeineLeft());
            System.out.println("Please press 0 to exit CoffeeCap!");
            System.out.println("Please press any other key to continue using CoffeeCap!"); 
        }

        

        






    }
}