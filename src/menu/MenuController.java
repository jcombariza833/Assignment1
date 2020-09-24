package menu;

import ui.UIController;

public class MenuController {
    private Menu menu;

    public MenuController() {
        this.menu = new Menu();
        populateMenu(menu);

    }

    public void displayMenuItems(int menuOption) {
        MenuIterator<MenuItem> iterator = getIterator(menuOption);
        titleMenuUnderPrice(menuOption);
        displayMenu(iterator);
    }

    public void displayMenuItemsUnderPrice(Float price) {
        MenuIterator<MenuItem> iterator = menu.getPriceIterator(price);
        titleMenuUnderPrice(price);
        displayMenu(iterator);
    }

    public void addNewMenuItem(String name, int category, boolean heartHealthy, float price) {
        MenuItem newMenuItem = new MenuItem(name, category, heartHealthy, price);
        menu.add(newMenuItem);
    }

    public void deleteMenuItem(String name) {
        menu.deleteItem(menu.getAllItemsIterator(), name);
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

    private void displayMenu(MenuIterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item.getName() + " $" + item.getPrice());
        }
        UIController.separator();
    }

    private MenuIterator<MenuItem> getIterator(int menuOption) {
        MenuIterator<MenuItem> iterator = null;

        switch (menuOption){
            case 1:
                iterator = menu.getAllItemsIterator(); break;
            case 2:
                iterator = menu.getItemIterator(Menu.APPETIZERS); break;
            case 3:
                iterator = menu.getItemIterator(Menu.MAIN_DISH); break;
            case 4:
                iterator = menu.getItemIterator(Menu.DESSERT);break;
            case 5:
                iterator = menu.getHeartHealthyIterator(); break;
        }

        return iterator;
    }

    private void titleMenuUnderPrice(int menuOption) {
        String title = "";

        switch (menuOption){
            case 1:
                title = "ALL MENU ITEMS"; break;
            case 2:
                title = "APPETIZERS"; break;
            case 3:
                title = "MAIN DISHES"; break;
            case 4:
                title = "DESSERTS"; break;
            case 5:
                title = "ALL HEART HEALTHY MENU ITEMS"; break;
        }

        UIController.separator();
        System.out.println(title);
        UIController.separator();
    }

    private void titleMenuUnderPrice(Float price) {
        UIController.separator();
        System.out.println("ALL MAIN DISHES UNDER " + price + " USD");
        UIController.separator();
    }
}
