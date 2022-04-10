package hw5_20001928_maiviethung.ex1;

import java.util.Arrays;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<Integer> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize + 1];

    }
    public ArrayBinaryTree(int cap) {
        array = (E[]) new Object[cap + 1];
    }

    // update methods
    public void setRoot(E element) {
        // Set element to root of an empty tree (at index 1)
        if( array[1] == null) {
            n++;
        }
        array[1] = element;
    }

    public void setLeft(int p, E element) {
        // Set left child of p (at index 2p)
        if( array[2*p] == null) {
            n++;
        }
        array[2*p] = element;
    }

    public void setRight(int p, E element) {
        // Set right child of p (at index 2p+1)
        if (array[2*p + 1] == null) {
            n++;
        }
        array[2*p + 1] = element;
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
    public int numChildren(Integer p) {
        // TODO Auto-generated method stub
        int num = 0;
        if (array[(int) this.left(p)] != null) {
            num+=1;
        }
        if(array[(int) this.right(p)] != null) {
            num+=1;
        }
        return num;
    }

    @Override
    public Integer root() {
        // TODO Auto-generated method stub
        return 1;
    }
    @Override
    public Integer parent(Integer p) {
        // TODO Auto-generated method stub
        return p % 2 == 0 ? p / 2 : (p - 1) / 2;
    }
    @Override
    public Integer left(Integer p) {
        // TODO Auto-generated method stub
        return p*2;
    }
    @Override
    public Integer right(Integer p) {
        // TODO Auto-generated method stub
        return p*2+1;
    }
    @Override
    public Integer sibling(Integer p) {
        // TODO Auto-generated method stub
        return p % 2 == 0 ? p + 1 : p - 1;
    }
    
  

    public static void main(String[] args) {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>(12);

        tree.setRoot(1);
        tree.setLeft(1, 2);
        tree.setRight(1, 3);
        System.out.println(Arrays.toString(tree.array));
        System.out.println(tree.numChildren(2));
        System.out.println(tree.sibling(2));
    }
}