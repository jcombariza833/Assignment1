package menu.iterators;

import IteratorPattern.MenuIterator;
import menu.MenuItem;
import java.util.ArrayList;

public class AllItemsIterator implements MenuIterator<MenuItem> {
    private ArrayList<MenuItem> menuItems;
    private int index;

    public AllItemsIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return index < menuItems.size();
    }

    @Override
    public void next() {
        if (this.hasNext()) {
            index++;
        }
    }

    @Override
    public MenuItem getItem() {
        return menuItems.get(index);
    }
}
