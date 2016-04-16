package exercise.datastructure;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class BinarySearchTree<V extends Comparable> {

    private V v;

    private BinarySearchTree left;

    private BinarySearchTree right;

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
}
