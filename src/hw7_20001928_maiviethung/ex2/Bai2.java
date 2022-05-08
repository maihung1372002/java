package hw7_20001928_maiviethung.ex2;

import java.io.FileWriter;
import java.io.IOException;

import hw5_20001928_maiviethung.ex1.LinkedBinaryTree.Node;
import hw7_20001928_maiviethung.ex1.BinarySearchLinkedList;
import hw7_20001928_maiviethung.ex1.SequentialSearchLinkedList;

public class Bai2 {
    public static void inorderPrint( Node<Integer> bt, FileWriter out) throws IOException {

        if (bt == null)
            return;
        String padding = "";
        inorderPrint(bt.right, out);
        for (int i = 0; i < getDeg(bt); i++) {
            padding = padding + "    ";
        }
        out.write(padding + bt.getElement() + "\n");
        inorderPrint(bt.left, out);

    }

    public static int getDeg(Node<Integer> node) {
        int deg = 0;
        while (node.parent != null) {
            node = node.parent;
            deg++;
        }
        return deg;
    }
    public static void main(String[] args) throws IOException {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        BinarySearchLinkedList<Integer> binaryList = new BinarySearchLinkedList<>();
        SequentialSearchLinkedList<Integer> seqentialList = new SequentialSearchLinkedList<>();
        int[] nums = {12315423, 23152345, 263427614, 2461732, 1238413};

        for (int i : nums) {
            tree.insert(i, tree);
            binaryList.add(i);
            seqentialList.add(i);
        }


        System.out.println("searching " + nums[nums.length/2]);
        long nano_startTime = System.nanoTime();
        tree.search(nums[nums.length/2], tree);
        long nano_endTime = System.nanoTime();
        System.out.println("BinarySearchTree take " + (nano_endTime - nano_startTime) + " nano secs");

        nano_startTime = System.nanoTime();
        binaryList.search(nums[nums.length/2]);
        nano_endTime = System.nanoTime();
        System.out.println("BinarySearch take " + (nano_endTime - nano_startTime) + " nano secs");

        nano_startTime = System.nanoTime();
        seqentialList.search(nums[nums.length/2]);
        nano_endTime = System.nanoTime();
        System.out.println("SeqentialSearch take " + (nano_endTime - nano_startTime) + " nano secs");
        
        // tree.insert(3, tree);
        // tree.insert(6, tree);
        // tree.insert(4, tree);
        // tree.insert(1, tree);
        // tree.insert(5, tree);
        // tree.insert(2, tree);

        // tree.printInOrder(tree.root());
        // System.out.println();
        // tree.rotateRight(tree.root());
        // tree.rotateLeft(tree.root().right);
        // tree.rotateRight(tree.root());
        // tree.rotateRight(tree.root().left);
        // System.out.println(tree.root().right.left.element);
        // System.out.println(getDeg(tree.root().right.left));
        // tree.delete(6, tree);
        // tree.delete(3, tree);
        // tree.insert(7, tree);
        // tree.delete(2, tree);
        // tree.delete(7, tree);
        // FileWriter out = null;
        // try {
        //     out = new FileWriter("output.txt");
        //     inorderPrint(tree.root() ,out);

            
        // } finally {

        //     if (out != null) {
        //         out.close();
        //     }
        // }
        // tree.printInOrder(tree.root());
    }

}
