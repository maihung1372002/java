package hw5_20001928_maiviethung.ex2;

import hw5_20001928_maiviethung.ex1.LinkedBinaryTree;
import hw5_20001928_maiviethung.ex1.LinkedBinaryTree.Node;

public class Bai2_2 {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        ExpressionTree<String> exp = new ExpressionTree<>();
        
        
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
        
        exp.inorderPrint(root);
        System.out.println();
        exp.preorderPrint(root);
        System.out.println();
        exp.postorderPrint(root);

        System.out.print(tree.root());

    }
}
