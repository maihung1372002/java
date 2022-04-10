package hw4_20001928_maiviethung.ex2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    private int n = 0;
    private E[] array;

    public ArrayStack(){
        this.array =(E[]) new Object[100];
    }
    
    public ArrayStack(int cap) {
        this.array =(E[]) new Object[cap];
    }
    
    @Override
    public void push(E element) {
        for (int i = 0; i < n; i++) {
            array[i+1] = array[i];
        }
       array[0] = element;
       n++;
    }

    @Override
    public E pop() {
        // Lấy một phần tử khỏi stack
        E top = array[0];
        for (int i = 0; i < n; i++) {
            array[i] = array[i+1];
        }
        n--;
        return top;
    }

    @Override
    public boolean isEmpty() {
        // Kiểm tra stack rỗng
        return n == 0;
    }

    @Override
    public E top() {
        // Lấy giá trị phần tử đầu tiên của stack
        return array[0];
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        Iterator it = new Iterator<E>() {
            int id = 0;

            @Override
            public boolean hasNext() {
                return id < n - 1;
            }

            @Override
            public E next() {
                return array[id++];
            }
        };

    return it;
    
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("hung");
        stack.push("hug");
        stack.push("hng");
        stack.push("hng");
        stack.push("hnug");
        // xoa va tra ve ele dau stack
        System.out.println(stack.pop());
        // check empty
        System.out.println(stack.isEmpty());
        // tra ve ele dau stack
        System.out.println(stack.top());

        Iterator it = stack.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
