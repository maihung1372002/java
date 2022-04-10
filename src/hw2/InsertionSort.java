package hw2;

public class InsertionSort<T extends Comparable<T>> extends Sort<T>{
    public InsertionSort(T[] arr) {
        super(arr);
        //TODO Auto-generated constructor stub
    }

    public T[] sort() {
        T valueToInsert;
        int holePosition;
        int i;
        for (i = 1; i < arr.length; i++) {
            valueToInsert = arr[i];
            holePosition = i;
            while (holePosition > 0 && arr[holePosition - 1].compareTo(valueToInsert) == 1) {
                this.compare++;
                arr[holePosition] = arr[holePosition - 1];
                this.replace++;
                holePosition--;
            }
            this.compare++;
            if (holePosition != i) {
                arr[holePosition] = valueToInsert;
                this.replace++;
            }
        }
        return arr;
    }
}
