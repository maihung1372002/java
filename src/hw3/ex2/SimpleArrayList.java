package hw3.ex2;


import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;
    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }
    public SimpleArrayList(int capacity) throws Exception {
        if (capacity <= 0) {
            throw new Exception("invalid length");
        }
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        array[n] = data;
        n++;
    }
    public T get(int i) {
        return array[i];
    }
    public void set(int i, T data) {
        // if (i > n)
        array[i] = data;
    }
    public void remove(T data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == data) {
                for (int index = i; index < array.length - 1; index++) {
                    array[index] = array[index + 1];
                }
                break;
            }
        }
        this.array = Arrays.copyOf(array, array.length - 1);
    }

    public boolean isContain(T data) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i] == data) {
                return true;
            }
        }
        return false;
    }
   
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return n == 0 ? true : false;
    }
    @Override
    public Iterator<T> iterator() {
        Iterator iter = new Iterator<T>() {
            int id = 0;

            @Override
            public boolean hasNext() {
                return id < n - 1;
            }

            @Override
            public T next() {
                return array[id++];
            }
        };

        return iter;
    }
    public static void main(String[] args) throws Exception {
        SimpleArrayList<String> ob1 = new SimpleArrayList<>(4);
        ob1.add("Hai");
        ob1.add("Hoan");
        ob1.add("Hung");
        ob1.add("Hieu");
        System.out.println(Arrays.toString(ob1.array));

        System.out.println(ob1.isContain("Hoan"));

        ob1.set(3,"hahaa");
        System.out.println(Arrays.toString(ob1.array));

        ob1.remove("hahaa");

        System.out.println(ob1.size());
        Iterator it = ob1.iterator();
        while (it.hasNext()) {
            String s = it.next().toString();
            System.out.println(s);
        }
    }    
    
}
