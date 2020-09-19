import menu.MenuController;
import ui.UIController;

import java.util.*;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuController menuController = new MenuController();
        boolean running = true;

        UIController.initialMenu();

        while (running){
            System.out.print("Please choose an option: ");
            int menuOption = validateIntInput(scanner,1,9);
            UIController.separator();

            switch (menuOption) {
                case 6:
                    System.out.print("Please set a prices: ");
                    float price = validateFloatInput(scanner);
                    UIController.separator();
                    menuController.displayMenuItemsUnderPrice(price);
                    break;
                case 7:
                    addNewMenuItem(scanner, menuController);
                    break;
                case 8:
                    System.out.print("Enter the item name: ");
                    String itemName = scanner.next();
                    UIController.separator();
                    menuController.deleteMenuItem(itemName);
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    menuController.displayMenuItems(menuOption);
                    break;
            }
        }
    }

    private static void addNewMenuItem(Scanner scanner, MenuController menuController) {
        System.out.print("Enter the new item name: ");
        String name = scanner.next();
        UIController.separator();

        UIController.menuCategoryMenu();
        int category = validateIntInput(scanner,1,3);
        UIController.separator();

        UIController.menuHeartHealthyMenu();
        int healthyIn = validateIntInput(scanner,1,2);
        UIController.separator();
        boolean isHealthy = healthyIn == 1;

        System.out.print("Enter the new item price: ");
        float newPrice = validateFloatInput(scanner);
        UIController.separator();

        menuController.addNewMenuItem(name, category, isHealthy, newPrice);
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

