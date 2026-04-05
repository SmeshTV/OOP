package lab3.task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleCollection<E> implements MyCollection<E> {
    private List<E> items = new ArrayList<>();

    @Override
    public boolean add(E element) { return items.add(element); }

    @Override
    public boolean remove(Object o) { return items.remove(o); }

    @Override
    public void clear() { items.clear(); }

    @Override
    public int size() { return items.size(); }

    @Override
    public boolean isEmpty() { return items.isEmpty(); }

    @Override
    public boolean contains(Object o) { return items.contains(o); }

    @Override
    public Iterator<E> iterator() { return items.iterator(); }
}
