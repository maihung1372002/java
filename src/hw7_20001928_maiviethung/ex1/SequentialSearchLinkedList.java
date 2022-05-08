package hw7_20001928_maiviethung.ex1;

import java.util.Iterator;

import hw3.ex3.SimpleLinkedList;

public class SequentialSearchLinkedList<T extends Comparable<T>> extends SimpleLinkedList<T> {
    public SequentialSearchLinkedList() {
        super();
    }

    public int search(T value) {
        Iterator<T> it = super.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().compareTo(value) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
