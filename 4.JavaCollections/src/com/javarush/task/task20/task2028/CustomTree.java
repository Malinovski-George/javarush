package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;


public class CustomTree extends AbstractList<String> implements List<String>, Cloneable, Serializable {
    private Entry<String> header = new Entry<String>(null, null, null, null, null, null);
    private int size = 0;

    public CustomTree() {
        header.next = header.previous = header;
        header.parent = header;
    }

    public String getParent(String value) {
        if (value == null) {
            for (Entry<String> e = header.next; e != header; e = e.next)
                if (e.element == null) return e.parent.element;
        } else for (Entry<String> e = header.next; e != header; e = e.next)
            if (value.equals(e.element)) return e.parent.element;
        return null;
    }

    public int size() {
        return size;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Entry<String> e = header.next; e != header; e = e.next) {
                if (e.element == null) {
                    remove(e);
                    return true;
                }
            }
        } else {
            for (Entry<String> e = header.next; e != header; e = e.next) {
                if (o.equals(e.element)) {
                    remove(e);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean add(String e) {
        Entry<String> lastParent = header.previous.parent;
        Entry<String> forAdd = addBefore(e, header);
        while (true) {
            if (lastParent.left == null) {
                lastParent.left = forAdd;
                break;
            } else if (lastParent.right == null) {
                lastParent.right = forAdd;
                break;
            }
            lastParent = lastParent.next;
        }
        forAdd.parent = lastParent;
        return true;
    }

    @Override
    public void clear() {
        if (size() == 0) return;
        if (header.next != header) remove(header.next);
        if (header.next != header) remove(header.next);
    }

    private static class Entry<String> implements Serializable {
        String element;
        Entry<String> next;
        Entry<String> previous;
        Entry<String> parent;
        Entry<String> left;
        Entry<String> right;

        Entry(String element, Entry<String> next, Entry<String> previous, Entry<String> parent, Entry<String> left, Entry<String> right) {
            this.element = element;
            this.next = next;
            this.previous = previous;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    private class Itr implements Iterator<String> {

        int cursor = 0;
        int lastRet = -1;
        int expectedModCount = modCount;
        Entry<String> currentEntry = header;


        @Override
        public boolean hasNext() {
            return currentEntry.next == header;
        }

        @Override
        public String next() {
            checkForComodification();
            int i = cursor;
            Entry<String> next = currentEntry.next;
            if (next == header) throw new NoSuchElementException();
            lastRet = i;
            cursor = i + 1;
            currentEntry = next;
            checkForComodification();
            return next.element;
        }

        @Override
        public void remove() {
            if (lastRet < 0) throw new IllegalStateException();
            checkForComodification();
            try {
                Entry<String> prevEntry = currentEntry.previous;
                CustomTree.this.remove(currentEntry);
                currentEntry = prevEntry;
                cursor--;
                if (lastRet < cursor) cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) throw new ConcurrentModificationException();
        }
    }

    private Entry<String> addBefore(String e, Entry<String> entry) {
        //добавляем в список
        Entry<String> newEntry = new Entry<String>(e, entry, entry.previous, null, null, null);
        newEntry.previous.next = newEntry;
        newEntry.next.previous = newEntry;
        size++;
        modCount++;
        return newEntry;
    }

    private String remove(Entry<String> e) {
        //если элемент - хедер, то выбрасываем исключение
        if (e == header) throw new NoSuchElementException();
        //удаляем элемент из списка
        String result = e.element;
        e.previous.next = e.next;
        e.next.previous = e.previous;
        e.next = e.previous = null;
        //удаляем элемент из древа
        if (e.parent != null) {
            if (e.parent.left == e) e.parent.left = null;
            else if (e.parent.right == e) e.parent.right = null;
        }
        if (e.left != null) {
            e.left.parent = null;
            remove(e.left);
        }
        if (e.right != null) {
            e.right.parent = null;
            remove(e.right);
        }
        size--;
        modCount++;
        return result;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}
