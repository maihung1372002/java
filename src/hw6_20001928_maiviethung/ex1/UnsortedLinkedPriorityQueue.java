package hw6_20001928_maiviethung.ex1;

import java.util.Iterator;

import hw6_20001928_maiviethung.ex1.UnsortedLinkedPriorityQueue.NodeEntry;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K,E> {

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
        this.tail.next = newNode;
        tail = newNode;
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
        Entry<K, E> min = this.min(); 
        NodeEntry<K,E> tempHead = head; 
        if (head == min) {
            head = head.next;
            n--;
            return min;
        }
        while (tempHead.next != null) {
            if (tempHead.next == min) {
                tempHead.next = tempHead.next.next;
                return min;
            }
            tempHead = tempHead.next;
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        // TODO Auto-generated method stub
        NodeEntry<K,E> min = head; 
        NodeEntry<K,E> tempHead = head; 

        while (tempHead.next != null) {
            if (min.key.compareTo(tempHead.next.key) == 1) {
                min = tempHead.next;
            }
            tempHead = tempHead.next;
        }
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
        UnsortedLinkedPriorityQueue<Integer, String> prio = new UnsortedLinkedPriorityQueue<>();
        // NodeEntry<> node = new NodeEntry<>(3, "hungdfjsjd");
        prio.insert(5, "hungsldjfosj");
        prio.insert(3, "hungdfjsjd");
        prio.insert(4, "hung");
        prio.insert(0, "hung");
        prio.insert(2, "hudfng");
        prio.insert(0, "hundfdcfsf33g");
        
        Iterator it = prio.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(prio.removeMin().getValue());

        Iterator it2 = prio.iterator();
        while(it2.hasNext()) {
            System.out.println(it2.next());
        }

    }
   
}
