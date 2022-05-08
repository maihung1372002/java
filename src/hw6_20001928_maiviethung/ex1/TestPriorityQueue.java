package hw6_20001928_maiviethung.ex1;

import java.util.Iterator;

public class TestPriorityQueue {
    // @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer,Integer> numberPrioQueue = new UnsortedLinkedPriorityQueue<>();
        numberPrioQueue.insert(1, 1);
        numberPrioQueue.insert(5, 5);
        numberPrioQueue.insert(2, 2);
        numberPrioQueue.insert(4, 4);
        numberPrioQueue.insert(3, 3);
        Iterator<Integer> it = numberPrioQueue.iterator();
        System.out.println("PriorityQueue voi key, element la so");
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("xoa so nho nhat:"+numberPrioQueue.removeMin().getValue());
        
        Iterator<Integer> it2 = numberPrioQueue.iterator();
        while(it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }
        System.out.println();

        UnsortedLinkedPriorityQueue<Integer,String> taskPrioQueue = new UnsortedLinkedPriorityQueue<>();
        System.out.println();
        System.out.println("key la muc do can thiet cua cac task");
        taskPrioQueue.insert(5, "do homework");
        taskPrioQueue.insert(1, "make dinner");
        taskPrioQueue.insert(6, "play game");
        taskPrioQueue.insert(0, "chat with girlfriend");

        Iterator it3 = taskPrioQueue.iterator();
        System.out.println("PriorityQueue voi key, element la so");
        while(it3.hasNext()) {
            System.out.println(" -" + it3.next());
        }
        System.out.println();
        System.out.println("lam task quan trong nhat: "+taskPrioQueue.removeMin().getValue());
        
        Iterator it4 = taskPrioQueue.iterator();
        while(it4.hasNext()) {
            System.out.println(" -" + it4.next());
        }
        System.out.println();
    }
}
