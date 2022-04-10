package hw5_20001928_maiviethung.ex1;

import java.io.FileWriter;
import java.io.IOException;

import hw5_20001928_maiviethung.ex1.LinkedBinaryTree.Node;

public class Bai1_3 {
    public static void inorderPrint( Node<String> bt, FileWriter out) throws IOException {

        if (bt == null)
            return;
        String padding = "";
        inorderPrint(bt.right,out);
        for (int i = 0; i < getDeg(bt); i++) {
            padding = padding + "    ";
        }
        out.write(padding + bt.getElement() + "\n");
        inorderPrint(bt.left,out);

    }

    public static int getDeg(Node<String> node) {
        int deg = 0;
        while (node.parent != null) {
            node = node.parent;
            deg++;
        }
        return deg;
    }

    public static void main(String[] args) throws IOException {

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        // root o vi tri 1
        Node<String> root = tree.addRoot("+");
        // setLeft, right cho root
        Node<String> leftRoot = tree.addLeft(root, "+");
        Node<String> rightRoot = tree.addRight(root, "*");
        
        
        Node<String> node_4 = tree.addLeft(leftRoot, "8");
        Node<String> node_5 = tree.addRight(leftRoot, "*");
        
        Node<String> node_6 = tree.addLeft(rightRoot, "+");
        Node<String> node_7 = tree.addRight(rightRoot, "5");
        
        Node<String> node_10 = tree.addLeft(node_5, "3");
        Node<String> node_11 = tree.addRight(node_5, "6");
        
        Node<String> node_12 = tree.addLeft(node_6, "*");
        Node<String> node_13 = tree.addRight(node_6, "4");
        Node<String> node_14 = tree.addLeft(node_12, "1");
        Node<String> node_15 = tree.addRight(node_12, "9");
        FileWriter out = null;
        
        try {
            out = new FileWriter("output.txt");
            inorderPrint(root ,out);

            
        } finally {

            if (out != null) {
                out.close();
            }
        }
        // int [] arrTree= (int[]) (tree.getArrTree());
        // System.out.print(tree.size());
        // for (int i = 1; i <= tree.size();i++) {
        // System.out.print(tree.getArrTree());
        // }
    }
}
