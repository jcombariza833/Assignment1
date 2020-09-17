package menu.iterators;

import IteratorPattern.MenuIterator;
import menu.MenuItem;
import java.util.ArrayList;

public class HeartHealthyIterator implements MenuIterator<MenuItem> {
    private ArrayList<MenuItem> menuItems;
    private int index;

    public HeartHealthyIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.index = -1;
        fixNext();
    }

    @Override
    public boolean hasNext() {
        return index < menuItems.size();
    }

    @Override
    public void next() {
        fixNext();
    }

    @Override
    public MenuItem getItem() {
        return menuItems.get(index);
    }

    private void fixNext() {
        index++;
        while (hasNext() && !menuItems.get(index).isHeartHealthy()) index++;
    }
}
