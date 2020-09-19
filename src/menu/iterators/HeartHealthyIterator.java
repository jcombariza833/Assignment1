package menu.iterators;

import menu.MenuIterator;
import menu.MenuItem;

import java.util.NoSuchElementException;

public class HeartHealthyIterator implements MenuIterator<MenuItem> {
    private MenuItem[] menuItems;
    private int index;

    public HeartHealthyIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
        this.index = 0;
        findHeartHealthyItem();
    }

    @Override
    public boolean hasNext() {
        return index < menuItems.length;
    }

    @Override
    public MenuItem next() {
        MenuItem item = menuItems[index];
        index++;
        findHeartHealthyItem();

        return item;
    }

    private void findHeartHealthyItem() {
        while (hasNext() && !menuItems[index].isHeartHealthy()) index++;
    }
}
