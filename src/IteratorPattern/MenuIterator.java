package IteratorPattern;

public interface MenuIterator<T> {
    boolean hasNext();
    void next();
    T getItem();
}
