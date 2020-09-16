import java.util.ArrayList;

import IteratorPattern.Iterable;
import IteratorPattern.MenuIterator;

public class Menu implements Iterable<MenuItem> {
    public static final int APPETIZERS = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;

    private ArrayList<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
    }

    public void add(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void deleteItem(MenuItem menuItem) {
        menuItems.remove(menuItem);
    }

    @Override
    public MenuIterator<MenuItem> getAllItemsIterator() {
        return new AllItemsIterator(menuItems);
    }

    @Override
    public MenuIterator<MenuItem> getItemIterator(int itemType) {
        return new ItemIterator(menuItems, itemType);
    }

    @Override
    public MenuIterator<MenuItem> getHeartHealthyIterator() {
        return new HeartHealthyIterator(menuItems);
    }

    @Override
    public MenuIterator<MenuItem> getPriceIterator(float price) {
        return new PriceIterator(menuItems, price);
    }
}
