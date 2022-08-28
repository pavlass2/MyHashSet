package org.example;

import java.util.*;

public class MyHashSet implements Set {
    private int prime;
    private LinkedList[] values;

    private int hashFunc(final CharSequence chars) {
        int hash = 0;
        for (int i = 1; i < chars.length(); i++) {
            hash += hash + chars.charAt(i) * i;
        }
        return hash % prime;
    }
    public MyHashSet(final int prime) {
        this.prime = prime;
        values = new LinkedList[prime];
    }


    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        if (values.length == 0) {
            return true;
        }

        for (LinkedList possibleValues : values) {
            if (possibleValues != null) {
                for(Object value : possibleValues) {
                    if (value != null) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean contains(Object o) {
        int index = hashFunc(o.toString());
        if (index > values.length) {
            return false;
        }

        LinkedList possibleValues = values[index];
        if (possibleValues == null) {
            return false;
        }

        for (Object value : possibleValues) {
            if (value.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(values).iterator();
    }

    @Override
    public Object[] toArray() {
        return values;
    }

    @Override
    public boolean add(Object o) {
        if (contains(o)) {
            return false;
        }

        final int index = hashFunc(o.toString());
        LinkedList element;
        if (values.length < index || values[index] == null) {
            element = new LinkedList();
            values[index] = element;
        } else {
            element = values[index];
        }
        element.add(o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }

        int index = hashFunc(o.toString());
        LinkedList possibleValues = values[index];

        for (Iterator i = possibleValues.iterator(); i.hasNext();) {
            if (i.next().equals(o)) {
                i.remove();
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean changed = false;
        for (Object value : c) {
            if (add(value)) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public void clear() {
        values = new LinkedList[prime];
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean changed = false;
        for (Object value : c) {
            if (remove(value)) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection c) {
        return Arrays.stream(values).toList().retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object value : c) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
