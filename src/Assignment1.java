import IteratorPattern.MenuIterator;
public class Assignment1 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        populateMenu(menu);
        displayAllMenuItems(menu);
        displayAllAppetizers(menu);
        displayAllMainDishes(menu);
        displayAllDesserts(menu);
        displayAllHealthyItems(menu);
        displayAllMainDishesUnderPrice(menu);
        MenuItem newMenuItem = new MenuItem("Eggs", Menu.APPETIZERS, true, 15.0f);
        menu.add(newMenuItem);
        menu.deleteItem(newMenuItem);
        displayAllMenuItems(menu);
    }

    private static void populateMenu(Menu menu) {
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

    private static void displayAllMenuItems(Menu menu) {
        MenuIterator<MenuItem> allItemsIterator = menu.getAllItemsIterator();
        separator();
        System.out.println("ALL MENU ITEMS");
        separator();
        while (allItemsIterator.hasNext()) {
            MenuItem item = allItemsIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allItemsIterator.next();
        }
    }

    private static void displayAllAppetizers(Menu menu) {
        MenuIterator<MenuItem> allAppetizersIterator = menu.getItemIterator(Menu.APPETIZERS);
        separator();
        System.out.println("APPETIZERS");
        separator();
        while (allAppetizersIterator.hasNext()) {
            MenuItem item = allAppetizersIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allAppetizersIterator.next();
        }
    }

    private static void displayAllMainDishes(Menu menu) {
        MenuIterator<MenuItem> allMainDishesIterator = menu.getItemIterator(Menu.MAIN_DISH);
        separator();
        System.out.println("MAIN DISHES");
        separator();
        while (allMainDishesIterator.hasNext()) {
            MenuItem item = allMainDishesIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allMainDishesIterator.next();
        }
    }

    private static void displayAllDesserts(Menu menu) {
        MenuIterator<MenuItem> allDessertsIterator = menu.getItemIterator(Menu.DESSERT);
        separator();
        System.out.println("DESSERTS");
        separator();
        while (allDessertsIterator.hasNext()) {
            MenuItem item = allDessertsIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allDessertsIterator.next();
        }
    }

    private static void displayAllHealthyItems(Menu menu) {
        MenuIterator<MenuItem> allHealthyItemsIterator = menu.getHeartHealthyIterator();
        separator();
        System.out.println("ALL HEART HEALTHY MENU ITEMS");
        separator();
        while (allHealthyItemsIterator.hasNext()) {
            MenuItem item = allHealthyItemsIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allHealthyItemsIterator.next();
        }
    }

    private static void displayAllMainDishesUnderPrice(Menu menu) {
        MenuIterator<MenuItem> allMainDishesUnderPriceIterator = menu.getPriceIterator(10.00f);
        separator();
        System.out.println("ALL MAIN DISHES UNDER 10.00 USD");
        separator();
        while (allMainDishesUnderPriceIterator.hasNext()) {
            MenuItem item = allMainDishesUnderPriceIterator.getItem();
            System.out.println(item.getName() + " $" + item.getPrice());
            allMainDishesUnderPriceIterator.next();
        }
        separator();
    }

    private static void separator() {
        System.out.println("-----------------------------------");
    }
}

