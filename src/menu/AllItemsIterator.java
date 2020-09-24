package menu;

 class AllItemsIterator implements MenuIterator<MenuItem> {
    private MenuItem[] menuItems;
    private int index;

    public AllItemsIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() { return index < menuItems.length; }

    @Override
    public MenuItem next() { return menuItems[index++]; }
}
