package hw2;


public abstract class Sort<T extends Comparable<T>> {
    T[] arr;
    int compare;
    int replace;


    public int getCompare() {
        return compare;
    }


    public int getReplace() {
        return replace;
    }

    public Sort(T[] arr) {
        this.arr = arr;
        compare = 0;
        replace = 0;
    }

    
    public abstract T[] sort();
    
    public void print() {
        for (T i : this.arr) {
            System.out.print(i + " ");
        }
    }
}
