package practice.datastructure;

import java.util.LinkedList;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class LevelOrderTraversal {

    public static void levelOrderTraversal(TreeNode<Integer> treeNode) {
        // TODO: 2016/4/16 not done yet
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (treeNode != null) {
            stack.offer(treeNode);
        }
        while (!stack.isEmpty()) {
            treeNode = stack.poll();
            TreeNode<Integer> left = treeNode.getLeft();
            if (left != null) {
                stack.offer(left);
            }
            TreeNode<Integer> right = treeNode.getRight();
            if (right != null) {
                stack.offer(right);
            }
            out.print(treeNode.getV() + " ");
        }

    }

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = TreeNode.<Integer>newInstance(5, 1);
        levelOrderTraversal(treeNode);
    }
}
