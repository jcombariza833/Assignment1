import IteratorPattern.MenuIterator;
import menu.Menu;
import menu.MenuController;
import menu.MenuItem;
import ui.UIController;

import java.util.*;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuController menuController = new MenuController();
        boolean running = true;

        while (running){
            UIController.initialMenu();
            int menuOption = validateIntInput(scanner,1,9);

            switch (menuOption) {
                case 1:
                    menuController.displayAllMenuItems();
                    break;
                case 2:
                    menuController.displayAllAppetizers();
                    break;
                case 3:
                    menuController.displayAllMainDishes();
                    break;
                case 4:
                    menuController.displayAllDesserts();
                    break;
                case 5:
                    menuController.displayAllHealthyItems();
                    break;
                case 6:
                    System.out.print("Please set a prices: ");
                    float price = validateFloatInput(scanner);
                    menuController.displayAllMainDishesUnderPrice(price);
                    break;
                case 7:
                    System.out.print("Enter the new item name: ");
                    String name = scanner.next();

                    UIController.menuCategoryMenu();
                    int category = validateIntInput(scanner,1,3);

                    UIController.menuHeartHealthyMenu();
                    int healthyIn = validateIntInput(scanner,1,2);
                    boolean isHealthy = healthyIn == 1;

                    System.out.print("Enter the new item price: ");
                    float newPrice = validateFloatInput(scanner);

                    menuController.addNewMenuItem(name, category, isHealthy, newPrice);
                    break;
                case 8:
                    System.out.print("Enter the item name: ");
                    String itemName = scanner.next();
                    menuController.deleteMenuItem(itemName);
                    break;
                case 9:
                    running = false;
                    break;
            }
        }
    }

    private static int validateIntInput(Scanner input, int min, int max) {
        while (!input.hasNextInt()) {
            System.out.print("That is not a valid input, please try again.\n" + "Please choose an option: ");
            input.next();
        }

        int menuOption = input.nextInt();

        if (menuOption < min || menuOption > max) {
            System.out.print("This option is not in the menu.\n" + "Please choose an option: ");
            menuOption = validateIntInput(input, min, max);
        }
        return menuOption;
    }

    private static float validateFloatInput(Scanner input) {
        while (!input.hasNextFloat()) {
            System.out.print("That is not a valid input, please try again.\n" + "Please set a prices: ");
            input.next();
        }

        float price = input.nextFloat();

        if (price < 0f ) {
            System.out.print("The price must be positive.\n" + "Please set a prices: ");
            price = validateFloatInput(input);
        }

        return price;
    }
}

