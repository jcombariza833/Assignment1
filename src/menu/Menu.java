package menu;

import menu.iterators.AllItemsIterator;
import menu.iterators.HeartHealthyIterator;
import menu.iterators.ItemIterator;
import menu.iterators.PriceIterator;

public class Menu {
    public static final int APPETIZERS = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;

    private MenuItem[] menuItems;

    public Menu() {
        menuItems = new MenuItem[0];
    }

    public void add(MenuItem menuItem) {
        MenuItem[] menuItems = new MenuItem[this.menuItems.length + 1];

        for(int i = 0; i < this.menuItems.length; i++) {
            menuItems[i] = this.menuItems[i];
        }

        menuItems[menuItems.length - 1] = menuItem;
        this.menuItems = menuItems;
    }

    public void deleteItem(MenuIterator<MenuItem> iterator, String name) {
        int rm_index = 0;

        while (iterator.hasNext()) {
            MenuItem item = iterator.next();

            if(item.getName().equals(name)) {
                MenuItem[] newMenuItems = new MenuItem[menuItems.length - 1];

                for (int i = 0, k = 0; i < menuItems.length; i++) {
                    if (i == rm_index) {
                        continue;
                    }
                    newMenuItems[k++] = menuItems[i];
                }

                menuItems = newMenuItems;
                break;
            }
            rm_index++;
        }
    }

    public MenuIterator<MenuItem> getAllItemsIterator() {
        return new AllItemsIterator(menuItems);
    }

    public MenuIterator<MenuItem> getItemIterator(int itemType) {
        return new ItemIterator(menuItems, itemType);
    }

    public MenuIterator<MenuItem> getHeartHealthyIterator() {
        return new HeartHealthyIterator(menuItems);
    }

    public MenuIterator<MenuItem> getPriceIterator(float price) {
        return new PriceIterator(menuItems, price);
    }
}
