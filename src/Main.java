

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String secondTopping;
        String extraTopping;
        ArrayList<String> toppings = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int size = 0;
        double price;
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
            secondTopping = input.next();

            if (secondTopping.matches(".*\\d.*")) {
                System.out.println("please input an acceptable topping");

            } else if (toppings.get(0).equals(secondTopping)) {
                System.out.println("you cannot have the same topping twice");
            } else {
                toppings.add(secondTopping);
                break;
            }
        }
        while (true) {
            System.out.println("would you like any extra toppings? extra toppings cost £1.25 each");
            extraTopping = input.next();
            if (extraTopping.equals("no")) {
                break;
            } else if (extraTopping.matches(".*\\d.*")) {
                System.out.println("please input an acceptable topping");
            } else if (extraTopping.matches(toppings.get(toppings.size() - 1))) {
                System.out.println("you cannot pick the same topping twice");
            } else {
                toppings.add(extraTopping);
            }
        }
        if (size == 1) {
            System.out.println("your pizza is a small ");
            price = 7.99;
        } else if (size == 2) {
            System.out.println("your pizza is a medium ");
            price = 10.99;
        } else {
            System.out.println("your pizza is a large ");
            price = 13.99;
        }
        price = (price + (1.25 * (toppings.size() - 2)));
        System.out.println("with toppings: "+ toppings.toString());
        System.out.print("total price is £" + price);
    }
}

