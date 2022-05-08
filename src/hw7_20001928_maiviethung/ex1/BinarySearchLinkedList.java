package hw7_20001928_maiviethung.ex1;

import hw3.ex3.SimpleLinkedList;

public class BinarySearchLinkedList<T extends Comparable<T>> extends SimpleLinkedList<T>{
    
    public void insert(T element) {
        Node insertNode = this.findPositionFor(element);
        if (insertNode == null) {
            if (super.isEmpty()) {
                // super.add(element);
                Node newNode = new Node(element, null);
                super.bot = newNode;
                super.top = newNode;
                // return;
            } else {
                Node newNode =  new Node(element, super.top);
                super.top = newNode;
            }
            super.n++;
            return;    
        }
        Node newNode = new Node(element, insertNode.next);
        insertNode.next = newNode;
        System.out.println(insertNode.data);
        if (insertNode == super.bot) {
            super.bot = newNode;
        }
        super.n++;
    }
    
    public Node findPositionFor(T element) {
        Node pos = null;
        Node temp = super.top;
        
        System.out.println(super.toString());

        if (temp != null) {
            if (temp.data.compareTo(element) != -1) {
                return null;
            }
        }

        while (temp != null) {
            if (temp.next == null) {
                if (temp.data.compareTo(element) != 1) {
                    pos = temp;
                    break;
                }
            } else if (temp.next.data.compareTo(element) != -1) {
                pos = temp;
                break;
            }
            temp = temp.next;
            pos = temp;
        }
        return pos;
    }

    public int search(T value) {
        return binarySearch(this, 0, this.size(), value);
    }

    public int binarySearch(BinarySearchLinkedList<T> list,int left, int right, T value) {
        if (right >= left) {
            int middle = left + (right - left) / 2;

            if (list.get(middle).compareTo(value) == 0) {
                return middle;
            }

            if (list.get(middle).compareTo(value) == 1) {
                return binarySearch(list, left, middle -1, value);
            }

            return binarySearch(list, middle + 1, right, value);
        }
        return -1;
    }
}
