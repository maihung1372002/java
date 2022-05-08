package hw7_20001928_maiviethung.ex2;

// import javax.swing.text.html.HTMLDocument.RunElement;

import hw5_20001928_maiviethung.ex1.LinkedBinaryTree;

public class BinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T>{
    
    public T findMin(Node<T> root) {
        Node<T> min = root;
        while (min.left != null) {
            min = min.left;
        } 
        return min.element;
    }

    public Node<T> insert(T element, Node<T> root) {
        // Node<T> temp = tree.root();
        // if (tree.isEmpty()) {
        //     BinarySearchTree<T> newTree = new BinarySearchTree<>();
        //     newTree.addRoot(element);
        //     return newTree;
        // } 
        // while (temp != null) {

        // }
        if (root == null) {
            // return root.parent;
        }
        if (element.compareTo(root.element) == -1) {
            if (root.left == null) {
                root.left = new Node<>(element, root, null, null);
                return root;
            }
            root.left = insert(element, root.left);
        } else if (element.compareTo(root.element) == 1) {
            if (root.right == null) {
                root.right = new Node<>(element, root, null, null);
                return root;
            }
            root.right = insert(element, root.right);
        } else {
            try {
                throw new Exception("value in BST must be unique");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return root;

    }

    public BinarySearchTree<T> insert(T element, BinarySearchTree<T> tree) {
        Node<T> root = tree.root();
        // System.out.println("insert" + element);
        if (tree.isEmpty()) {
            tree.addRoot(element);
            return tree;
        }
        insert(element, root);
        super.n++;
        // this.printInOrder(root);
        // System.out.println();

        return tree;

    }

    public Node<T> search(T value, BinarySearchTree<T> tree) {
        Node<T> temp = super.root();
        while (temp != null) {
            if (value == temp) {
                return temp;
            } else if (value.compareTo(temp.element) == -1) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    public BinarySearchTree<T> delete(T value, BinarySearchTree<T> tree) {
        Node<T> root = tree.root();
        if (root == null) {
            System.out.println("NOT FOUND " + value + " in tree");
        }
        this.delete(value, root);

        return tree;
    }

    public Node<T> delete(T value, Node<T> root) {
        if (this.numChildren(root) == 0) {
            if (root.element.compareTo(value) == 0) {
                if (root == super.root()) {
                    root = null;
                    return null;
                }
                root.parent.left = null;
                root.parent.right = null;
            } else {
                System.out.println("NOT FOUND " + value + " in tree");
            }
            return null;
        }
        else if (this.numChildren(root) == 1 && root.left != null) {
            if (value.compareTo(root.element) == 0) {
                if (root ==  super.root()) {
                    super.root = root.left;
                    return null;
                }
                if (root.parent.left == root) {
                    root.parent.left = root.left;
                } else {
                    root.parent.right = root.left;
                }
                root.left.parent = root.parent;
                return root.left;
            } else {
                if (this.numChildren(root) == 0) {
                    // root.left = null;
                }
                else if (this.numChildren(root) != 0) {
                    root.left = delete(value, root.left);
                } 
            }
            return root;
        }
        else if (this.numChildren(root) == 1 && root.right != null) {
            if (value.compareTo(root.element) == 0) {
                if (root == super.root()) {
                    super.root = root.right;
                    return null;
                }
                if (root.parent.left == root) {
                    root.parent.left = root.right;
                } else {
                    root.parent.right = root.right;
                }
                root.right.parent = root.parent;
                return root.right;
            } else {
                if (this.numChildren(root) == 0) {
                    // root.right = null;
                }
                else if (this.numChildren(root) != 0) {
                    root.right = delete(value, root.right);
                } 
            }
            return root;
        }
        else {
            if (value.compareTo(root.element) == 0) {
                root.element = findMin(root.right);
                delete(findMin(root.right), root.right);
                if (this.numChildren(root.right) == 0) {
                    // root.right = null;
                }
                else if (this.numChildren(root.right) != 0) {
                    // root.right = delete(value, root.right);
                } 
            } else if (value.compareTo(root.element) == -1) {
                root.left = delete(value, root.left);
            } else {
                root.right = delete(value, root.right);
            }
            return root;
        }
    }

    protected void toBalance() {

 
    }

    public void rotateRight(Node<T> x) {
        if (x.left == null) {
            return;
        }
        Node<T> L = x.left;
        x.left = L.right;
        L.right.parent = x;
        L.right = x;
        Node<T> p = x.parent;
        if (p == null) {
            // p.right = L;
            super.root = L;
        }
        // x.parent = L;
        else if (p.left == x) {
            p.left = L;
        } else {
            p.right = L;
        }
        // if (x == super.root()) {
        // } 
        L.parent = p;
        x.parent = L;

    }

    public void rotateLeft(Node<T> x) {
        if (x.right == null) {
            return;
        }
        Node<T> R = x.right;
        x.right = R.left;
        R.left.parent = x;
        R.left = x;
        Node<T> p = x.parent;
        if (p == null) {
            // p.left = L;
            super.root = R;
        }
        // x.parent = L;
        else if (p.right == x) {
            p.right = R;
        } else {
            p.left = R;
        }
        // if (x == super.root()) {
        // } 
        R.parent = p;
        x.parent = R;

    }

    public void printInOrder(Node<T> p) {
        if (p == null)
        return;
    // String padding = "";
    printInOrder(p.left);
    // for (int i = 0; i < getDeg(p); i++) {
    // padding = padding + " ";
    // }
    // out.write(padding + p.element + "\n");
    System.out.print(p.element);
    printInOrder(p.right);
    }
}
