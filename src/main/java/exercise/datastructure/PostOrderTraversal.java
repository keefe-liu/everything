package exercise.datastructure;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class PostOrderTraversal {

    public static void postOrderTraversal(TreeNode<Integer> treeNode) {
        if (treeNode != null) {
            postOrderTraversal(treeNode.getLeft());
            postOrderTraversal(treeNode.getRight());
            out.print(treeNode.getV() + " ");
        }
    }

    public static void nonRecursionPostOrder(TreeNode<Integer> treeNode) {
        TreeNode<Integer> temp = treeNode;
        LinkedStack<TreeNode> stack = new LinkedStack<>();
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

    //TODO postOrderTraversal by loop
    public static void main(String[] args) {
        TreeNode<Integer> treeNode = TreeNode.<Integer>newInstance(4, 1);
        postOrderTraversal(treeNode);
        nonRecursionPostOrder(treeNode);
    }
}
