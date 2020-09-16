import IteratorPattern.MenuIterator;

import java.util.ArrayList;

public class PriceIterator implements MenuIterator<MenuItem>, MenuFilter {

    private ArrayList<MenuItem> menuItems;
    private float price;
    private int index;

    public PriceIterator(ArrayList<MenuItem> menuItems, float price) {
        this.price = price;
        this.menuItems = menuFilter(menuItems);
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

    @Override
    public ArrayList<MenuItem> menuFilter(ArrayList<MenuItem> menuItems) {
        ArrayList<MenuItem> result = new ArrayList<>();

        for (MenuItem item: menuItems) {
            boolean condition = item.getCategory() == 2 && item.getPrice() < price;
            if (condition) {
                result.add(item);
            }
        }

        return result;
    }
}
