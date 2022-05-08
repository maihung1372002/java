package hw6_20001928_maiviethung.ex2;

import java.util.Arrays;

import hw6_20001928_maiviethung.ex1.UnsortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable, E> extends UnsortedArrayPriorityQueue<K, E> {

    // public class ArrEntry<K,E> implements Entry<K, E> {
    // K key;
    // E element;

    // public ArrEntry(K k, E e) {
    // this.key = k;
    // this.element = e;
    // }

    // @Override
    // public K getKey() {
    // // TODO Auto-generated method stub
    // return this.key;
    // }

    // @Override
    // public E getValue() {
    // // TODO Auto-generated method stub
    // return this.element;
    // }
    // }

    // Các phương thức bổ sung
    ArrEntry<K, E> heapPQ[];

    public MinHeapPriorityQueue(int cap) {
        super(cap);
    }

    public MinHeapPriorityQueue() {
        super();
    }

    // @Override
    public void insert(K k, E e) {
        // ArrEntry<K,E> newEntry = new ArrEntry<>(k,e);
        if (super.array[0] == null) {
            super.array[0] = new ArrEntry<K, E>(null, null);
            super.n++;
            super.insert(k, e);
            return;
        }
        super.insert(k, e);
        // if(super.size() - 1 < 2) return;
        this.upHeap();
    }

    protected void upHeap() {
        // ArrEntry<K,E> [] array = super.array;
        // System.out.print(Arrays.toString(array));
        // ArrEntry<K,E> lastNode = array[array.length - 1];
        int i = this.size() - 1;
        while (i > 1 && super.array[i / 2].getKey().compareTo(super.array[i].getKey()) == 1) {
            // swap(array[i/2], array[i]);
            // System.out.print("ok");
            ArrEntry<K, E> temp = super.array[i / 2];
            super.array[i / 2] = super.array[i];
            super.array[i] = temp;
            i /= 2;
        }

    }

    // protected void swap(ArrEntry<K,E> a, ArrEntry<K,E> b) {
    // ArrEntry<K,E> temp = a;
    // a = b;
    // b = temp;

    // }
    public ArrEntry<K, E> removeMin() {
        ArrEntry<K, E> min = super.array[1];
        super.array[1] = super.array[super.n - 1];
        super.n--;
        this.downHeap();
        return min;
    }
    public int size() {
        return super.n -1 ;
    }
    protected void downHeap() {
        int i = 1;
        int n = super.size() ;
        while (i < n) {
            if (2 * i + 1 < n) {
                if (super.array[i].getKey().compareTo(super.array[2 * i].getKey()) == -1
                        && super.array[i].getKey().compareTo(super.array[2 * i + 1].getKey()) == -1) {
                    return;
                } else {
                    int minIndex = super.array[2 * i].getKey().compareTo(super.array[2 * i + 1].getKey()) == -1 ? 2 * i
                            : 2 * i + 1;
                    ArrEntry<K, E> temp = super.array[minIndex];
                    super.array[minIndex] = super.array[i];
                    super.array[i] = temp;
                    i = minIndex;
                }
            } else {
                if (2 * i < n) {
                    if (super.array[i].getKey().compareTo(super.array[2 * i].getKey()) == 1) {
                        ArrEntry<K, E> temp = super.array[i];
                        super.array[i] = super.array[2 * i];
                        super.array[2 * i] = temp;
                    }
                }
                return;
            }
        }
        return;
    }

    public ArrEntry<K, E>[] getArr() {
        return super.array;
    }
}
