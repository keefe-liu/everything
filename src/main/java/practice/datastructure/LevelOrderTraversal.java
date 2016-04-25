package practice.datastructure;

import java.util.LinkedList;

import static java.lang.System.out;
import static java.lang.System.runFinalization;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class LevelOrderTraversal {

    public static void levelOrderTraversal(TreeNode<Integer> treeNode) {
        LinkQueue<TreeNode> queue = new LinkQueue();
        while (treeNode != null) {
            out.print(treeNode.getV() + "　");
            TreeNode<Integer> left = treeNode.getLeft();
            if (left != null) {
                queue.offer(left);
            }
            TreeNode<Integer> right = treeNode.getRight();
            if (right != null) {
                queue.offer(right);
            }
            treeNode = queue.poll();
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = TreeNode.<Integer>newInstance(5, 1);
        levelOrderTraversal(treeNode);
    }
}
