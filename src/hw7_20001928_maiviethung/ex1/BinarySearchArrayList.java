package hw7_20001928_maiviethung.ex1;


import hw3.ex2.SimpleArrayList;

public class BinarySearchArrayList <T extends Comparable<T>> extends SimpleArrayList<T>{
    public BinarySearchArrayList() {
        super();
    }
    public BinarySearchArrayList(int cap) throws Exception {
        super(cap);
    }

    @Override
    public void add(T data) {
        int index = findPositionFor(data);
        for (int i = super.size(); i > index; i--) {
            super.array[i] = super.array[i-1];
            
        }
        super.array[index] = data;
        super.n++;
    }

    public int findPositionFor(T element) {
        int pos = 0;
        for (int i = 0; i < super.size(); i++) {
            if (element.compareTo(super.array[i]) != 1) {
                pos = i;
                break;
            }
            pos++;
        }
        return pos;
    }


    public int search(T value) {
        return binarySearch(super.array, 0, super.size() - 1, value);
    }

    public int binarySearch(T[] array, int left, int right, T value) {
        if (right >= left) {
            int middle = left + (right - left) / 2;

            if (array[middle].compareTo(value) == 0) {
                return middle;
            }

            if (array[middle].compareTo(value) == 1) {
                return binarySearch(array, left, middle -1, value);
            }

            return binarySearch(array, middle + 1, right, value);
        }
        return -1;
    }
}
