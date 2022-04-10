package hw5_20001928_maiviethung.ex2;

import hw5_20001928_maiviethung.ex1.LinkedBinaryTree;
import hw5_20001928_maiviethung.ex1.LinkedBinaryTree.Node;

public class Caculator {
    LinkedBinaryTree<String> tree ;
    
    
    public Caculator(LinkedBinaryTree<String> tree) {
        this.tree = tree;
    }

    private boolean isOperator(String ch) {
        return ch == "+" || ch == "-" || ch == "*" || ch == "/";
    }
    private boolean isNumber(String ch) {
        try {
            double num = Double.parseDouble(ch);
            return true;
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
    }
    private double processOperator(String t , String num1, String num2) {
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
        double r = 0;
        if (t == "+") {
            r = a + b;
        } else if (t == "-") {
            r = a - b;
        } else if (t == "*") {
            r = a * b;
        } else if (t == "/") {
            r = a / b;
        }
        return  r;
    }

    public void calcPreOrder(Node<String> node) {
        if (node== null) return;
        if (isOperator(node.element) & node.left != null & node.right != null) {
            if (isNumber(node.left.element) 
             & isNumber(node.right.element)) {
                node.element = String.valueOf(this.processOperator(node.element, node.left.element, node.right.element));
                node.left = null;
                node.right = null;
            }
        }
        calcPreOrder(node.left);
        calcPreOrder(node.right);
    }

    public Double calc(LinkedBinaryTree<String> tree){
        while (!isNumber(tree.root().element)) {
            this.calcPreOrder(tree.root());
        }
        return Double.parseDouble(tree.root().getElement());
    }
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Caculator c = new Caculator(tree);
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

        Double result = c.calc(tree);
        
        // exp.inorderPrint(root);
        // System.out.println();
        System.out.println(result);
        // exp.postorderPrint(root);
    }
}
