

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> toppings = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int size = 0;

        System.out.println("what size pizza do you want? (small: 1,medium: 2,large: 3)");
        while (!(size <= 3 && size >= 1)) {
            try {
                size = input.nextInt();
                if (size <= 3 && size >= 1) {
                    break;

                } else {
                    System.out.println("your number is not between 1 and 3 , please try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a number between 1-3 to select your size");
                input.next();

            }
        }

        System.out.println("please select your first free topping");
        while (true) {
            if (!(input.hasNextInt())) {
                toppings.add(input.next());
                break;

            } else {
                System.out.println("please input an acceptable topping");
                input.next();
            }
        }
        System.out.println("please select your second free topping");
        while (true) {
            if (input.next() == toppings.get(0)) {
                System.out.println("you cannot have the same topping twice");
            } else if (!(input.hasNextInt())) {
                toppings.add(input.next());
                break;
            } else {
                System.out.println("please input an acceptable topping");
            }
        }
    }
}

