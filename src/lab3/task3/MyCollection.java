package lab3.task3;

import java.util.Iterator;

public interface MyCollection<E> extends Iterable<E> {
    
    boolean add(E element);       // Adds an item; returns true if the collection changed
    boolean remove(Object o);     // Removes an item; returns true if it was present
    void clear();                 // Removes all elements from the collection

    int size();                   // Returns the current count of elements
    boolean isEmpty();            // Returns true if size is 0
    boolean contains(Object o);   // Checks if a specific item exists in the group

    @Override
    Iterator<E> iterator();
}

