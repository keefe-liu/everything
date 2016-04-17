package exercise.datastructure;

import exercise.datastructure.*;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class PreOrderTraversal {

    private TreeNode<Integer> treeNode;

    public static void preOrderTraversal(TreeNode<Integer> treeNode) {
        if (treeNode != null) {
            out.print(treeNode.getV() + " ");
            preOrderTraversal(treeNode.getLeft());
            preOrderTraversal(treeNode.getRight());
        }
    }

    public static <V extends Comparable> void preOrderTraversal(BinarySearchTree<V> treeNode) {
        if (treeNode != null) {
            out.print(treeNode.getV() + " ");
            preOrderTraversal(treeNode.getLeft());
            preOrderTraversal(treeNode.getRight());
        }
    }

    public static void nonRecursionPreOrder(TreeNode<Integer> treeNode) {
        TreeNode<Integer> temp = treeNode;
        LinkedStack<TreeNode> stack = new LinkedStack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                out.print(temp.getV() + " ");
                stack.push(temp);
                temp = temp.getLeft();
            }
            if (!stack.isEmpty()) {
                temp = stack.pop();
                temp = temp.getRight();
            }

        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = TreeNode.<Integer>newInstance(4, 1);
        preOrderTraversal(treeNode);
        out.println();
        nonRecursionPreOrder(treeNode);
    }
}
