package exercise.datastructure;

import java.util.Objects;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class SearchFromTree {
    public static <V extends Comparable> BinarySearchTree<V> findRecursive(BinarySearchTree<V> binarySearchTree, V v) {
        Objects.requireNonNull(v);
        if (binarySearchTree != null) {
            V temp = binarySearchTree.getV();
            if (v.equals(temp)) {
                return binarySearchTree;
            } else if (v.compareTo(temp) < 0) {
                return findRecursive(binarySearchTree.getLeft(), v);
            } else {
                return findRecursive(binarySearchTree.getRight(), v);
            }
        }
        return null;
    }

    public static <V extends Comparable> BinarySearchTree<V> findByLoop(BinarySearchTree<V> binarySearchTree, V v) {
        Objects.requireNonNull(v);
        while (binarySearchTree != null) {
            if (v.equals(binarySearchTree.getV())) {
                return binarySearchTree;
            } else if (v.compareTo(binarySearchTree.getV()) < 0) {
                binarySearchTree = binarySearchTree.getLeft();
            } else {
                binarySearchTree = binarySearchTree.getRight();
            }
        }
        return null;
    }
}
