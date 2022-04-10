package hw2;

public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    public BubbleSort(T[] ar) {
        super(ar);
    }

    public T[] sort() {
        T temp;
        int i, j;
 
        boolean swapped = false;
 
        for (i = 0; i < this.arr.length - 1; i++) {
            swapped = false;
            for (j = 0; j < this.arr.length - 1 - i; j++) {
                this.compare++;
                if (this.arr[j].compareTo(arr[j + 1]) == 1) {
                    temp = this.arr[j];
                    this.arr[j] = this.arr[j + 1];
                    this.arr[j + 1] = temp;
                    this.replace++;
                    swapped = true;
                } 
            }
 
            if (!swapped) {
                break;
            }
 
        }
        return this.arr;
    }
}
