package hw2;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    
    public SelectionSort(T[] arr) {
        super(arr);
    }

    public T[] sort() {
        int indexMin, i, j;
        for (i = 0; i < this.arr.length - 1; i++) {
            indexMin = i;
 
            for (j = i + 1; j < this.arr.length; j++) {
                this.compare++;
                if (this.arr[j].compareTo(this.arr[indexMin]) == -1) {
                    indexMin = j;
                    this.replace++;
                }
            }
            this.compare++;
            if (indexMin != i) {
                
                T temp = this.arr[indexMin];
                this.arr[indexMin] = this.arr[i];
                this.arr[i] = temp;
                this.replace++;
            }
            
        }
        return this.arr;
    }
}
