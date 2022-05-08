package hw5_20001928_maiviethung.ex1;
import  hw5_20001928_maiviethung.ex1.LinkedBinaryTree.Node;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<Node<E>> {
    
    
    public static class Node<E> {
        public E element; // an element stored at this node
        public Node<E> parent; // a reference to the parent node (if any)
        public Node<E> left; // a reference to the left child
        public Node<E> right; // a reference to the right child
        // Constructs a node with the given element and neighbors. ∗/
        // public Node<E> getLeft() {
        //     return left;
        // }
        // public Node<E> getRight() {
        //     return right;
        // }
        // public Node<E> getParent() {
        //     return parent;
        // }
        // public Node<E> getLeft() {
        //     return left;
        // }

        public Node(E e, Node<E> above, Node<E> leftChild,Node<E> rightChild){
            this.element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        public E getElement() {
            return this.element;
        }
    }

    protected int n = 0;
    protected Node<E> root = null;
    // protected Node<>
    //update methods
    public Node<E> addRoot(E element) {
        // Add element to root of an empty tree
        Node<E> newRoot = new Node<>(element, null, root, null);
        this.root = newRoot;
        n++;
        return newRoot;
    }
    public Node<E> addLeft(Node<E> p, E element) {
        // Add element to left child node of p if empty
        Node<E> left = new Node<>(element, p, null, null);
        p.left = left;
        n++;

        return left;
    }
    public Node<E> addRight(Node<E> p, E element) {
        // Add element to right child node of p if empty
        Node<E> right = new Node<>(element, p, null, null);
        p.right = right;
        n++;
        return right ;
    }
    public void set(Node<E> p, E element) {
        // set element to nnode p
        p.element = element;
    }
    @Override
    public Node<E> root() {
        // TODO Auto-generated method stub
        return this.root;
    }
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
    public int numChildren(Node<E> p) {
        // TODO Auto-generated method stub
        int num = 0;
        if (p.left != null) {
            num++;
        }
        if (p.right != null) {
            num++;
        }
        return num;
    }
    @Override
    public Node<E> parent(Node<E> p) {
        // TODO Auto-generated method stub
        return p.parent;
    }
    @Override
    public Node<E> left(Node<E> p) {
        // TODO Auto-generated method stub
        return p.left;
    }
    @Override
    public Node<E> right(Node<E> p) {
        // TODO Auto-generated method stub
        return p.right;
    }
    @Override
    public Node<E> sibling(Node<E> p) {
        // TODO Auto-generated method stub
        return p.parent.left == p ? p.parent.right : p.parent.left;
    }
    
    public LinkedBinaryTree<E> left() {
        this.root = root.left;
        return this;
    }

    public LinkedBinaryTree<E> right() {
        this.root = root.right;
        return this;
    }

    public static void main(String[] args) {
        
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
    
        Node<Integer> root = tree.addRoot(1);
        Node<Integer> leftRoot = tree.addLeft(root, 2);
        Node<Integer> rightRoot =  tree.addRight(root, 3);
       
        // System.out.println(Arrays.toString(tree.array));
        System.out.println(tree.numChildren(root));
        System.out.println(tree.sibling(leftRoot).getElement());
    }
   

    
    
}