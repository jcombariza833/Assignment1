import IteratorPattern.MenuIterator;
import menu.Menu;
import menu.MenuController;
import menu.MenuItem;
import ui.UIController;

import java.util.*;

public class Assignment1 {
    public static void main(String[] args) {
        UIController.initialMenu();
        Scanner scanner = new Scanner(System.in);

        int menuOption = validateIntInput(scanner);

        MenuController menuController = new MenuController();
        Menu menu = new Menu();

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
                MenuItem newMenuItem = new MenuItem("Eggs", Menu.APPETIZERS, true, 15.0f);
                menu.add(newMenuItem);
                break;
            case 8:
                MenuItem newMenuItem2 = new MenuItem("Eggs", Menu.APPETIZERS, true, 15.0f);
                menu.deleteItem(newMenuItem2);
                menuController.displayAllMenuItems();
        }
    }

    private static int validateIntInput(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("That is not a valid input, please try again.\n" + "Please choose an option: ");
            input.next();
        }

        int menuOption = input.nextInt();

        if (menuOption < 1 || menuOption > 8) {
            System.out.print("This option is not in the menu.\n" + "Please choose an option: ");
            menuOption = validateIntInput(input);
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

