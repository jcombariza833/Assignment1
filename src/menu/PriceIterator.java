package menu;

class PriceIterator implements MenuIterator<MenuItem> {
    private MenuItem[] menuItems;
    private float price;
    private int index;

    public PriceIterator(MenuItem[] menuItems, float price) {
        this.price = price;
        this.menuItems = menuItems;
        this.index = 0;
        findItemBelowPrice();
    }

    @Override
    public boolean hasNext() {
        return index < menuItems.length;
    }

    @Override
    public MenuItem next() {
        MenuItem item = menuItems[index];
        index++;
        findItemBelowPrice();
        return item;
    }

    private void findItemBelowPrice() {
        while (hasNext() && !(menuItems[index].getCategory() == 2 && menuItems[index].getPrice() < price))
            index++;
    }
}
