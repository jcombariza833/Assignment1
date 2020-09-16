package IteratorPattern;

public interface Iterable<T> {
    MenuIterator<T> getAllItemsIterator();
    MenuIterator<T> getItemIterator(int itemType);
    MenuIterator<T> getHeartHealthyIterator();
    MenuIterator<T> getPriceIterator(float price);
}

