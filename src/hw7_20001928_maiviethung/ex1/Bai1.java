package hw7_20001928_maiviethung.ex1;

import java.util.Iterator;


public class Bai1 {
    public static void main(String[] args) throws Exception {
        BinarySearchArrayList<Integer> list = new BinarySearchArrayList<>(6);
        SequentialSearchArrayList<Integer> list2 = new SequentialSearchArrayList<>();

        SequentialSearchLinkedList<Integer> list3 = new SequentialSearchLinkedList<>();
        BinarySearchLinkedList<Integer> list4 = new BinarySearchLinkedList<>();

        list.add(2);
        list.add(1);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(6);

        list2.add(2);
        list2.add(1);
        list2.add(6);
        list2.add(5);
        list2.add(4);
        list2.add(6);

        list3.add(2);
        list3.add(1);
        list3.add(6);
        list3.add(5);
        list3.add(4);
        list3.add(6);

        list4.insert(2);
        list4.insert(5);
        list4.insert(6);
        list4.insert(1);
        list4.insert(6);
        list4.insert(4);

        System.out.println("list1:");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String s = it.next().toString();
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("2 appears at index " + list.search(2));

        System.out.println();
        System.out.println("list2:");
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            String s = it2.next().toString();
            System.out.print(s + " ");
        }
        
        System.out.println();

        list2.search(6);
        System.out.println(list2.toString());

        System.out.println("list3:");
        // System.out.println(list3.toString());
        Iterator it3 = list3.iterator();
        while (it3.hasNext()) {
            String s = it3.next().toString();
            System.out.print(s + " ");
        }
        
        System.out.println();
        System.out.println("2 appears at index " + list3.search(2));

         System.out.println();
        System.out.println("list4:");
        Iterator it4 = list4.iterator();
        while (it4.hasNext()) {
            String s = it4.next().toString();
            System.out.print(s + " ");
        }
        
        System.out.println();
        System.out.println("4 appears at index " + list4.search(4));
    }
}
