package hw6_20001928_maiviethung.ex1;

import java.util.Arrays;
import hw6_20001928_maiviethung.ex1.UnsortedArrayPriorityQueue.ArrEntry;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K,E> {

    public class ArrEntry<K extends Comparable,E> implements Entry<K, E> {
        K key;
        E element;
    
        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }
    
        @Override
        public K getKey() {
            // TODO Auto-generated method stub
            return this.key;
        }
    
        @Override
        public E getValue() {
            // TODO Auto-generated method stub
            return this.element;
        }
    }

    protected ArrEntry<K,E>[] array;
    protected int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue(int cap) {
        array = new ArrEntry[cap];
    }
    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.size() == 0;
    }
    @Override
    public void insert(Entry<K, E> entry) {
        // TODO Auto-generated method stub
        K k = entry.getKey();
        E e = entry.getValue();
        this.insert(k,e);
    }
    @Override
    public void insert(K k, E e) {
        // TODO Auto-generated method stub
        array[n] = new ArrEntry<>(k, e);
        this.n++;
    }
    @Override
    public Entry<K, E> removeMin() {
        // TODO Auto-generated method stub
        Entry<K,E> min = this.min();
        for (int i = this.indexMin(); i < this.size(); i++) {
            array[i] = array[i + 1];
        }
        this.n--;
        return min;
    }
    @Override
    public Entry<K, E> min() {
        // TODO Auto-generated method stub
        return array[this.indexMin()];
    }

    public int indexMin() {
        int index = 0;
        K min = array[0].getKey();
        for (int i = 0; i < this.size(); i++) {
            if (min.compareTo(array[i].getKey()) == 1) {
                min = array[i].getKey();
                index = i;
            }
        }
        // System
        return index;
    }
    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> prio = new UnsortedArrayPriorityQueue<>(12);
        prio.insert(4, "hungf");
        prio.insert(6, "husng");
        prio.insert(5, "husng");
        prio.insert(3, "hunag");
        for (UnsortedArrayPriorityQueue<Integer, String>.ArrEntry<Integer, String> string : prio.array) {
            if(string != null) {
                System.out.print(string.getValue()+" " +string.getKey() + " -");
            }
        }

        System.out.println(prio.indexMin());
        System.out.println(prio.removeMin().getValue());
        System.out.println(prio.indexMin());
        System.out.println(prio.min().getValue());
    }
}
