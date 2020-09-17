package menu;

import IteratorPattern.MenuIterator;
import ui.UIController;

public class MenuController {
    private Menu menu;

    public MenuController() {
        this.menu = new Menu();
        populateMenu(menu);
    }

    public void displayAllMenuItems() {
        MenuIterator<MenuItem> allItemsIterator = menu.getAllItemsIterator();
        UIController.separator();
        System.out.println("ALL MENU ITEMS");
        UIController.separator();
        while (allItemsIterator.hasNext()) {
            MenuItem item = allItemsIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allItemsIterator.next();
        }
    }

    public void displayAllAppetizers() {
        MenuIterator<MenuItem> allAppetizersIterator = menu.getItemIterator(Menu.APPETIZERS);
        UIController.separator();
        System.out.println("APPETIZERS");
        UIController.separator();
        while (allAppetizersIterator.hasNext()) {
            MenuItem item = allAppetizersIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allAppetizersIterator.next();
        }
    }

    public void displayAllMainDishes() {
        MenuIterator<MenuItem> allMainDishesIterator = menu.getItemIterator(Menu.MAIN_DISH);
        UIController.separator();
        System.out.println("MAIN DISHES");
        UIController.separator();
        while (allMainDishesIterator.hasNext()) {
            MenuItem item = allMainDishesIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allMainDishesIterator.next();
        }
    }

    public void displayAllDesserts() {
        MenuIterator<MenuItem> allDessertsIterator = menu.getItemIterator(Menu.DESSERT);
        UIController.separator();
        System.out.println("DESSERTS");
        UIController.separator();
        while (allDessertsIterator.hasNext()) {
            MenuItem item = allDessertsIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allDessertsIterator.next();
        }
    }

    public void displayAllHealthyItems() {
        MenuIterator<MenuItem> allHealthyItemsIterator = menu.getHeartHealthyIterator();
        UIController.separator();
        System.out.println("ALL HEART HEALTHY MENU ITEMS");
        UIController.separator();
        while (allHealthyItemsIterator.hasNext()) {
            MenuItem item = allHealthyItemsIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allHealthyItemsIterator.next();
        }
    }

    public void displayAllMainDishesUnderPrice(Float price) {
        MenuIterator<MenuItem> allMainDishesUnderPriceIterator = menu.getPriceIterator(price);
        UIController.separator();
        System.out.println("ALL MAIN DISHES UNDER " + price + " USD");
        UIController.separator();
        while (allMainDishesUnderPriceIterator.hasNext()) {
            MenuItem item = allMainDishesUnderPriceIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allMainDishesUnderPriceIterator.next();
        }
        UIController.separator();;
    }

    public void addNewMenuItem(String name, int category, boolean heartHealthy, float price) {
        MenuItem newMenuItem = new MenuItem(name, category, heartHealthy, price);
        menu.add(newMenuItem);
    }

    public void deleteMenuItem(String name) {
        MenuItem item = null;
        MenuIterator<MenuItem> iterator = menu.getAllItemsIterator();
        while (iterator.hasNext()) {
            if (iterator.getItem().getName().equals(name)) {
                item = iterator.getItem();
                break;
            }
        }

        if(item != null) {
            menu.deleteItem(item);
        }
    }

    private void populateMenu(Menu menu) {
        menu.add(new MenuItem("Bruschetta", Menu.APPETIZERS, true, 8.95f));
        menu.add(new MenuItem("Artichoke and Spinach Dip", Menu.APPETIZERS, true, 8.00f));
        menu.add(new MenuItem("Stuffed Mushrooms", Menu.APPETIZERS, true, 7.50f));
        menu.add(new MenuItem("Fried Calamari", Menu.APPETIZERS, true, 8.00f));
        menu.add(new MenuItem("Four Cheese Garlic Bread", Menu.APPETIZERS, true, 4.00f));
        menu.add(new MenuItem("Shrimp Scampi", Menu.APPETIZERS, true, 10.00f));
        menu.add(new MenuItem("French Fries", Menu.APPETIZERS, false, 6.00f));
        menu.add(new MenuItem("Cobb Salad", Menu.MAIN_DISH, true, 10.00f));
        menu.add(new MenuItem("Caesar Salad", Menu.MAIN_DISH, true, 10.00f));
        menu.add(new MenuItem("Minestrone Soup", Menu.MAIN_DISH, true, 8.00f));
        menu.add(new MenuItem("Meatball Sandwich", Menu.MAIN_DISH, false, 8.00f));
        menu.add(new MenuItem("Philly Steak Sandwich", Menu.MAIN_DISH, false, 9.50f));
        menu.add(new MenuItem("Bacon Cheeseburger", Menu.MAIN_DISH, false, 12.00f));
        menu.add(new MenuItem("Cheesecake", Menu.DESSERT, false, 10.00f));
        menu.add(new MenuItem("Warm apple crumb tart", Menu.DESSERT, false, 10.50f));
        menu.add(new MenuItem("Chocolate sin cake", Menu.DESSERT, false, 10.50f));
        menu.add(new MenuItem("Creme brulee", Menu.DESSERT, false, 11.00f));
    }
}
