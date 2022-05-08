package hw6_20001928_maiviethung.ex2;

import hw6_20001928_maiviethung.ex1.UnsortedArrayPriorityQueue;
import hw6_20001928_maiviethung.ex1.UnsortedArrayPriorityQueue.ArrEntry;



public class TestHeap {

    public static void printHeap(MinHeapPriorityQueue heap){
        ArrEntry[] arr = heap.getArr();
        for (int i = 1; i<= heap.size(); i++) {
            if(arr[i] != null) {
                System.out.print(arr[i].getValue() + " -");
            }

        } 
        System.out.println();
    }
    public static void main(String[] args) {
   
        MinHeapPriorityQueue<Integer, String> heap = new MinHeapPriorityQueue<>(8);
        // NodeEntry<Inter>
        heap.insert(3, "hung3");
        printHeap(heap);
        heap.insert(0, "hung0");
        printHeap(heap);
        heap.insert(4, "hung4");
        printHeap(heap);
        heap.insert(6, "hung6");
        printHeap(heap);
        heap.insert(2, "hung2");
        printHeap(heap);
        heap.insert(5, "hung5");
        printHeap(heap);

        // System.out.println(heap.size());
        // System.out.println(Arrays.toString(heap.getArr()));
        
        System.out.println(heap.size());
        System.out.println(heap.removeMin().getValue());
        printHeap(heap);
        System.out.println(heap.removeMin().getValue());
        printHeap(heap);

    }

}
