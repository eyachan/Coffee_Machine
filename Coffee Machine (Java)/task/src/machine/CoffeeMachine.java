package machine;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    public static int water = 400;
    public static int milk = 540;
    public static int coffeeBeans = 120;
    public static int cup = 9;
    public static int money = 550;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = sc.nextLine();
            switch (action) {
                case "buy" -> {
                    System.out.println("what do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, 4 - back");
                    String choice = sc.nextLine();
                    switch (choice) {
                        case "1" -> resultExpresso();
                        case "2" -> resultLatte();
                        case "3" -> resultCappuccino();
                        case "back" -> {
                            break;
                        }
                    }

                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add: ");
                    int waterToAdd = sc.nextInt();
                    System.out.println("Write how many ml of milk you want to add: ");
                    int milkToAdd = sc.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int beans = sc.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    int cups = sc.nextInt();
                    fillCoffeeMachine(waterToAdd, milkToAdd, beans, cups);
                }
                case "remaining" -> {
                    displayCoffeeMachine();
                }
                case "take" -> {
                    System.out.println("I gave you " + money);
                    money = 0;
                }
                case "exit" -> System.exit(-1);
            }
        }


    }

    public static boolean checkEnough(int waterToUse, int milkToUse, int beansToUse, int cupsToUse) {
        if (water < waterToUse) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < milkToUse) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffeeBeans < beansToUse) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (cup < cupsToUse) {
            System.out.println("Sorry, not enough cup!");
            return false;
        }


        return true;
    }

    public static void resultExpresso() {
        if (checkEnough(250, 0, 16, 1)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            coffeeBeans -= 16;
            money += 4;
            cup--;
        }
    }

    public static void resultLatte() {
        if (checkEnough(350, 75, 20, 1)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            money += 7;
            cup--;
        }
    }

    public static void resultCappuccino() {
        if (checkEnough(200, 100, 12, 1)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            money += 6;
            cup--;
        }
    }

    public static void fillCoffeeMachine(int waterToAdd, int milkToAdd, int coffeeBeansToAdd, int cupToAdd) {
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        cup += cupToAdd;
    }

    public static void displayCoffeeMachine() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cup + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
