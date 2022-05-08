package hw6_20001928_maiviethung.ex1;

import java.util.Arrays;
import hw6_20001928_maiviethung.ex1.SortedArrayPriorityQueue.ArrEntry;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K,E> {

    public class ArrEntry<K,E> implements Entry<K, E> {
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

    ArrEntry<K,E>[] array;
    int n = 0;
    int defaultsize = 1000;

    public SortedArrayPriorityQueue(int cap) {
        array = new ArrEntry[cap];
    }
    public SortedArrayPriorityQueue() {
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
        if (this.size() == 0) {
            array[0] = new ArrEntry<>(k,e);
            this.n++;
            return;
        }
        int n = this.size() - 1;
        array[n + 1] = new ArrEntry<>(k,e);
        while(k.compareTo(array[n].getKey()) != 1 ) {
            ArrEntry temp = array[n];
            array[n] = array[n+1];
            array[n + 1] = temp;
            if (n == 0) break;
            n--;
        }
        this.n++;
    }
    @Override
    public Entry<K, E> removeMin() {
        // TODO Auto-generated method stub
        Entry<K,E> min = this.min();
        for (int i = 0; i < this.size(); i++) {
            array[i] = array[i + 1];
        }
        this.n--;
        return min;
    }
    @Override
    public Entry<K, E> min() {
        // TODO Auto-generated method stub
        return array[0];
    }
    public ArrEntry<K,E>[] getArr(){
        return this.array;
    }
    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> prio = new SortedArrayPriorityQueue<>(12);
        prio.insert(4, "hungf");
        prio.insert(6, "husng");
        prio.insert(5, "husng");
        prio.insert(3, "hunag");
        for (SortedArrayPriorityQueue<Integer, String>.ArrEntry<Integer, String> string : prio.array) {
            if(string != null) {
                System.out.print(string.getValue()+" " +string.getKey() + " -");
            }
        }

        System.out.println(prio.removeMin().getValue());
        System.out.println(prio.min().getValue());
    }
}
