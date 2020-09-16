import IteratorPattern.MenuIterator;

import java.util.ArrayList;

public class ItemIterator implements MenuIterator<MenuItem>, MenuFilter {
    private ArrayList<MenuItem> menuItems;
    private int itemType;
    private int index;

    public ItemIterator(ArrayList<MenuItem> menuItems, int itemType) {
        this.itemType = itemType;
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
            if (item.getCategory() == itemType) {
                result.add(item);
            }
        }

        return result;
    }
}
