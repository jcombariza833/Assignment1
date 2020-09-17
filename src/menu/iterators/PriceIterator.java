package menu.iterators;

import IteratorPattern.MenuIterator;
import menu.MenuItem;

import java.util.ArrayList;

public class PriceIterator implements MenuIterator<MenuItem> {

    private ArrayList<MenuItem> menuItems;
    private float price;
    private int index;

    public PriceIterator(ArrayList<MenuItem> menuItems, float price) {
        this.price = price;
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
        while (hasNext() && !(menuItems.get(index).getCategory() == 2 && menuItems.get(index).getPrice() < price))
            index++;
    }
}
