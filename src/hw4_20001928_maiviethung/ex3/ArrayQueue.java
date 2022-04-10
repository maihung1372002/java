package hw4_20001928_maiviethung.ex3;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public void enqueue(E element) {
        // TODO Auto-generated method stub
        queue[count] = element;
        count++;
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        E top = queue[0];
        for (int i = 0; i < count; i++) {
            queue[i] = queue[i + 1];
        }
        count--;
        return top;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        Iterator it = new Iterator<E>() {
            int id = 0;

            @Override
            public boolean hasNext() {
                return id < count;
            }

            @Override
            public E next() {
                return queue[id++];
            }
        };

        return it;

    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() + " dequeued from queue\n");

        Iterator it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("Front item is " + queue.dequeue());

    }
}
