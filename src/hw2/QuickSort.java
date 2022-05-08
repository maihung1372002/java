package hw2;

public class QuickSort<T extends Comparable<T>> extends Sort<T>{

    public QuickSort(T[] arr) {
        super(arr);
        //TODO Auto-generated constructor stub
    }

    @Override
    public T[] sort() {
        // TODO Auto-generated method stub
        this.quickSort(this.arr, 0, arr.length - 1);
        return this.arr;
    }

    public void swap(T arr[], int num1, int num2) {
        T temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
 
    public int partition(T arr[], int left, int right, T pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;
 
        while (true) {
            while (arr[++leftPointer].compareTo(pivot) == -1) {
            }
            while (rightPointer > 0 && arr[--rightPointer].compareTo(pivot) == 1) {
            }
            if (leftPointer >= rightPointer) {
                break;
            } else {
                swap(arr, leftPointer, rightPointer);
            }
        }

        swap(arr, leftPointer, right);
        return leftPointer;
    }
 
    public void quickSort(T arr[], int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            T pivot = arr[right];
            int partitionPoint = partition(arr, left, right, pivot);
            quickSort(arr, left, partitionPoint - 1);
            quickSort(arr, partitionPoint + 1, right);
        }
    }
    
}
