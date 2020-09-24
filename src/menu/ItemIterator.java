package menu;

class ItemIterator implements MenuIterator<MenuItem> {
    private MenuItem[] menuItems;
    private int itemType;
    private int index;

    public ItemIterator(MenuItem[] menuItems, int itemType) {
        this.itemType = itemType;
        this.menuItems = menuItems;
        this.index = 0;
        findCategory();
    }

    @Override
    public boolean hasNext() {
        return index < menuItems.length;
    }

    @Override
    public MenuItem next() {
        MenuItem item = menuItems[index];
        index++;
        findCategory();

        return item;
    }

    private void findCategory() {
        while (hasNext() && menuItems[index].getCategory() != itemType) index++;
    }
}
