package hw6_20001928_maiviethung.ex3;

import hw6_20001928_maiviethung.ex1.UnsortedArrayPriorityQueue.ArrEntry;
import hw6_20001928_maiviethung.ex2.MinHeapPriorityQueue;

public class HeapSort<T extends Comparable<T>> {
    // class ArrEntry<K,E> {
    //     K key;
    //     E element;
    //     public ArrEntry(K k, E e) {
    //         this.key = k;
    //         this.element = e;
    //     }
    // }
    MinHeapPriorityQueue<T,T> array = new MinHeapPriorityQueue<>();
    // public Hea
    public HeapSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.array.insert(arr[i], arr[i]);
        }
    }

    public T[] sort() {
        int n = array.size();
        T[] res = (T[])new Comparable[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = (T) array.removeMin().getKey();
        }
        return res;
    }
}
