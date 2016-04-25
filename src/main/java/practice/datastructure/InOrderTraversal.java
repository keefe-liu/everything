package practice.datastructure;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class InOrderTraversal {

    public static void inOrderTraversal(TreeNode<Integer> treeNode) {
        if (treeNode != null) {
            inOrderTraversal(treeNode.getLeft());
            out.print(treeNode.getV() + " ");
            inOrderTraversal(treeNode.getRight());
        }
    }

    public static <V extends Comparable> void inOrderTraversal(BinarySearchTree<V> treeNode) {
        if (treeNode != null) {
            inOrderTraversal(treeNode.getLeft());
            out.print(treeNode.getV() + " ");
            inOrderTraversal(treeNode.getRight());
        }
    }

    public static void nonRecursionInOrder(TreeNode<Integer> treeNode) {
        TreeNode temp = treeNode;
        LinkedStack<TreeNode> stack = new LinkedStack();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }
            if (!stack.isEmpty()) {
                temp = stack.pop();
                out.print(temp.getV() + " ");
                temp = temp.getRight();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = TreeNode.<Integer>newInstance(4, 1);
        inOrderTraversal(treeNode);
        out.println();
        nonRecursionInOrder(treeNode);
    }
}