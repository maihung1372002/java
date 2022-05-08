package hw2;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    public MergeSort(T[] arr) {
        super(arr);
        // TODO Auto-generated constructor stub
    }

    @Override
    public T[] sort() {
        // TODO Auto-generated method stub
        mergeSort(this.arr, 0, this.arr.length - 1);
        return this.arr;
    }
    @SuppressWarnings("unchecked")
    void merge(T arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        T L[] = (T[]) new Comparable[n1];
        T R[] = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) != 1) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(T arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

}
