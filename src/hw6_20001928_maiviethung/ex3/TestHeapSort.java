package hw6_20001928_maiviethung.ex3;

import java.util.Arrays;

import hw2.MergeSort;
import hw2.QuickSort;
import hw2.SelectionSort;
import hw2.Sort;
import hw6_20001928_maiviethung.ex1.UnsortedArrayPriorityQueue.ArrEntry;

public class TestHeapSort {
    public static void main(String[] args) {
        Integer [] ar = { 12,23,12,432,12,35};
        Integer [] ar1 = { 12,23,12,432,12,35};
        Integer [] ar2 = { 12,23,12,432,12,35};
        Integer [] ar3 = { 12,23,12,432,12,35};
        Integer [] ar4 = { 12,23,12,432,12,35};

        Sort<Integer> select = new SelectionSort(ar2);
        Sort<Integer> quick = new QuickSort<Integer>(ar3);
        Sort<Integer> merge = new MergeSort<Integer>(ar4);


        // ArrEntry[] arr = new ArrEntry[ar3.length];
        // for (int i = 0; i < ar3.length; i++) {
        //     arr[i] = new ArrEntry(ar3[i], ar3[i]);
        // }
        HeapSort<Integer> heap = new HeapSort<>(ar3);
        long nano_startTime = System.nanoTime();
        Comparable[] re = heap.sort();
        long nano_endTime = System.nanoTime();
        System.out.print("heap:"+Arrays.toString(re));
        System.out.println();
        System.out.println("heap sort take " + (nano_endTime - nano_startTime) + " nano seconds");
        System.out.println();
        
        System.out.print("quick:");
        nano_startTime = System.nanoTime();
        quick.sort();
        nano_endTime = System.nanoTime();
        quick.print();
        System.out.println();
        System.out.println("quick sort take " + (nano_endTime - nano_startTime) + " nano seconds");
        System.out.println();

        System.out.print("merge:");
        nano_startTime = System.nanoTime();
        merge.sort();
        nano_endTime = System.nanoTime();
        merge.print();
        System.out.println();
        System.out.println("merge sort take " + (nano_endTime - nano_startTime) + " nano seconds");
        System.out.println();

        System.out.print("select:");
        nano_startTime = System.nanoTime();
        select.sort();
        nano_endTime = System.nanoTime();
        select.print();
        System.out.println();
        System.out.println("select sort take " + (nano_endTime - nano_startTime) + " nano seconds");
        System.out.println();
    }
}
