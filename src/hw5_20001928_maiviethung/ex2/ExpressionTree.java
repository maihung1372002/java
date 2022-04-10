package hw5_20001928_maiviethung.ex2;

import hw5_20001928_maiviethung.ex1.LinkedBinaryTree;

public class ExpressionTree<E> extends LinkedBinaryTree<E> {
    public void preorderPrint(Node<E> p) {
        // pre-order traversal of tree with root p
        if (p == null)
            return;
        System.out.print(p.element);
        preorderPrint(p.left);
        preorderPrint(p.right);
    }

    public void postorderPrint(Node<E> p) {
        // post-order traversal of tree with root p
        if (p == null) return;
        postorderPrint(p.left);
        postorderPrint(p.right);
        System.out.print(p.element);
    }

    public void inorderPrint(Node<E> p) {
    
        // in-order traversal of tree with root p
        if (p == null)
            return;
        // String padding = "";
        inorderPrint(p.left);
        // for (int i = 0; i < getDeg(p); i++) {
        // padding = padding + " ";
        // }
        // out.write(padding + p.element + "\n");
        System.out.print(p.element);
        inorderPrint(p.right);
    }

    public void caculator() {
        
    }
}
