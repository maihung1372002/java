package hw4_20001928_maiviethung.ex2;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }

    private Node stack = null;

    @Override
    public void push(E element) {
        Node newStack = new Node();
        newStack.element = element;
        newStack.next = stack == null ? null : stack;
        stack = newStack;
    }

    @Override
    public E pop() {
        // Lấy một phần tử khỏi stack
        E tmp = stack.element;
        stack = stack.next;
        return tmp;
    }

    @Override
    public boolean isEmpty() {
        // Kiểm tra stack rỗng
        return stack == null;
    }

    @Override
    public E top() {
        // Lấy giá trị phần tử đầu tiên của stack
        if(this.isEmpty()) return null;
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return new StackIterator();
    }

    class StackIterator implements Iterator<E>
    {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentNode != null;
        }

        @Override
        public E next() {

            // TODO Auto-generated method stub
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;

        }
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
