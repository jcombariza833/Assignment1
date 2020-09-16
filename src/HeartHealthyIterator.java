import IteratorPattern.MenuIterator;
import java.util.ArrayList;

public class HeartHealthyIterator implements MenuIterator<MenuItem>, MenuFilter {
    private ArrayList<MenuItem> menuItems;
    private int index;

    public HeartHealthyIterator(ArrayList<MenuItem> menuItems) {
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
            if (item.isHeartHealthy()) {
                result.add(item);
            }
        }

        return result;
    }
}
