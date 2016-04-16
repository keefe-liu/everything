package exercise.datastructure;

import java.util.Objects;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class TreeNode<V> {

    private V v;

    private TreeNode<V> left;

    private TreeNode<V> right;

    public TreeNode(V v, TreeNode<V> left, TreeNode<V> right) {
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

    public TreeNode<V> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<V> left) {
        this.left = left;
    }

    public TreeNode<V> getRight() {
        return right;
    }

    public void setRight(TreeNode<V> right) {
        this.right = right;
    }

    /*rootNum（序号）从上到下，从左到右逐渐增大*/
    public static TreeNode newInstance(int depth,int rootNum) {
        if (depth <= 0) {
            return null;
        }
        TreeNode<Integer> left = newInstance(depth - 1, 2 * rootNum);
        TreeNode<Integer> right = newInstance(depth - 1, 2 * rootNum + 1);
        TreeNode<Integer> treeNode = new TreeNode(rootNum, left, right);
        return treeNode;
    }
}
