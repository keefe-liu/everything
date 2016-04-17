package practice.datastructure;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class LevelOrderTraversal {

    public static void levelOrderTraversal(TreeNode<Integer> treeNode) {
        // TODO: 2016/4/16 not done yet
        if (treeNode != null) {
            out.println(treeNode.getV());
            TreeNode<Integer> left = treeNode.getLeft();
            TreeNode<Integer> right = treeNode.getRight();
            if (left != null) {
                out.println(left.getV());
            }
            if (right != null) {
                out.println(right.getV());
            }
            levelOrderTraversal(left);
            levelOrderTraversal(right);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = TreeNode.<Integer>newInstance(4, 1);
        levelOrderTraversal(treeNode);
    }
}
