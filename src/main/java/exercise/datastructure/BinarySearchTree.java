package exercise.datastructure;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class BinarySearchTree<V extends Comparable> {

    private V v;

    private BinarySearchTree left;

    private BinarySearchTree right;

    public BinarySearchTree(V v, BinarySearchTree left, BinarySearchTree right) {
        this.v = v;
        this.left = left;
        this.right = right;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public void setRight(BinarySearchTree right) {
        this.right = right;
    }

    public static <V extends Comparable> BinarySearchTree<V> newInstance() {
        return null;
    }

    public void insert(V v) {
        insertNode(new BinarySearchTree<V>(v, null, null));
    }

    private void insertNode(BinarySearchTree<V> binarySearchTree) {
        int cpt = v.compareTo(binarySearchTree.v);
        if (cpt == 0) {
            return;
        } else if (cpt < 0) {
            if (right == null) {
                right = binarySearchTree;
            } else {
                right.insertNode(binarySearchTree);
            }
        } else {
            if (left == null) {
                left = binarySearchTree;
            } else {
                left.insertNode(binarySearchTree);
            }
        }
    }

    public BinarySearchTree findMin() {
        BinarySearchTree temp = this;
        while (temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    public BinarySearchTree findMax() {
        BinarySearchTree temp = this;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(7, null, null);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 14; i > 0; i--) {
            binarySearchTree.insert(random.nextInt(50));
        }
        InOrderTraversal.inOrderTraversal(binarySearchTree);
        BinarySearchTree temp = binarySearchTree.findMin();
        System.out.println();
    }
}
