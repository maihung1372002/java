package hw6_20001928_maiviethung.ex1;


import java.util.Iterator;

import hw6_20001928_maiviethung.ex1.SortedLinkedPriority.NodeEntry;;

public class SortedLinkedPriority<K extends Comparable, E> implements PriorityQueueInterface<K,E> {

    public class NodeEntry<K, E> implements Entry<K, E> {
        public K key;
        public E element;

        public NodeEntry<K, E> next;

        public NodeEntry (K k, E e){
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            // TODO Auto-generated method stub
            return this.key;
        }

        @Override
        public E getValue() {
            // TODO Auto-generated method stub
            return this.element;
        }
        
        public Entry getNext() {
            return next;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;

    int n = 0;

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.size() == 0;
    }


    @Override
    public void insert(K k, E e) {
        // TODO Auto-generated method stub
        NodeEntry<K,E> newNode = new NodeEntry<K,E>(k,e);
        if (head == null) {
            head = newNode;
            tail = newNode;
            n++;
            return;
        }
        if (k.compareTo(tail.key) == 1) {
            tail.next = newNode;
            tail = newNode;
            n++;
            return;
        }
        if (k.compareTo(head.key) == -1) {
            newNode.next = head;
            head = newNode;
            n++;
            return;
        }
        newNode.next = head;
        NodeEntry<K,E> tempEntry = head;
        while(tempEntry.next != null) {
            if (k.compareTo(tempEntry.next.key) != 1) {

                newNode.next = tempEntry.next;
                tempEntry.next = newNode;
                break;
            }

            // if (tempEntry.next == null) {
            //     // tempEntry.ne
            //     tempEntry.next = newNode;
            //     break;
            // } else if (k.compareTo(tempEntry.next.key) != 1 && tempEntry.next != null) {
            // }
            // // tempEntry.next = 
            tempEntry = tempEntry.next;
        }
        n++;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        K k = entry.getKey();
        E e = entry.getValue();
        this.insert(k,e);
    }
    @Override
    public Entry<K, E> removeMin() {
        // TODO Auto-generated method stub
        Entry<K,E> min = this.min();
        head = head.next;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        // TODO Auto-generated method stub
        NodeEntry<K,E> min = head; 
        return min;
    }

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private NodeEntry<K,E> currentNode = head;

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
        };
        return it;
    }

    public static void main(String[] args) {
        SortedLinkedPriority<Integer, String> prio = new SortedLinkedPriority<>();
        // NodeEntry<Inter>
        prio.insert(3, "hung3");
        prio.insert(4, "hung4");
        prio.insert(0, "hung0");
        prio.insert(2, "hung2");
        prio.insert(0, "hung0");
        prio.insert(5, "hung5");
        
        Iterator it = prio.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(prio.removeMin().getValue());
        System.out.println(prio.removeMin().getValue());
        // System.out.println(prio.removeMin().getValue());
        // System.out.println(prio.removeMin().getValue());

        // Iterator it2 = prio.iterator();
        // while(it2.hasNext()) {
        //     System.out.println(it2.next());
        // }

    }
   
}
