package hw7_20001928_maiviethung.ex1;

import hw3.ex2.SimpleArrayList;

public class SequentialSearchArrayList<T extends Comparable<T>> extends SimpleArrayList<T>{
    private String str ;
    private int count;
    private T valueSearching;

    public SequentialSearchArrayList() {
        super();
        str = "";
        count = 0;
    }
    public SequentialSearchArrayList(int cap) throws Exception {
        super(cap);
        str = "";
        count = 0;
    }


    public int search(T value) {
        str = "";
        count = 0;
        valueSearching = value;
        int position =  this.seqentialSearch(super.array, 0, super.size(), value);
        while (position != -1) {
            count++;
            str = str + "\n" + value + " at index " + position;
            if (position < super.size()) {
                position = this.seqentialSearch(super.array, position + 1, super.size(), value);
            }
        }
        return position;
    }

    public int seqentialSearch(T[] array, int start, int end, T value) {
        for (int i = start; i < end; i++) {
            if(array[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }

    public String toString () {
        str = this.valueSearching + " appears " + count + " times in list" + str;
        return str;
    }
}
