package practice.datastructure;

/**
 * Created by tingfang.liu on 2016/4/19.
 */
public class AVLTree<V extends Comparable> {
    static class TreeNode<V> {
        private TreeNode<V> left;
        private TreeNode<V> right;
        private V v;
        private int hight;

        public TreeNode(TreeNode<V> left, TreeNode<V> right, V v) {
            this.left = left;
            this.right = right;
            this.v = v;
        }
    }

    private TreeNode<V> treeNode;

    /*treeNode 的左子树的左子树上插入导致不平衡,进行 right-right 旋转*/
    public static <V extends Comparable> TreeNode RRRotate(TreeNode treeNode) {
        TreeNode temp = treeNode.left;
        treeNode.left = temp.right;
        temp.right = treeNode;
        return temp;
    }

    /*treeNode 的右子树的右子树上插入导致不平衡,进行 left-left 旋转*/
    public static <V extends Comparable> TreeNode LLRotate(TreeNode treeNode) {
        TreeNode temp = treeNode.right;
        treeNode.right = temp.left;
        temp.left = treeNode;
        return temp;
    }

    /*treeNode 的左子树的右子树上插入导致不平衡,进行 right-left 旋转*/
    public static <V extends Comparable> TreeNode RLRotate(TreeNode treeNode) {
        TreeNode temp = treeNode.left;
        treeNode.left = temp.right.right;
        temp.right.right = treeNode;
        TreeNode root = temp.right;
        temp.right = root.left;
        root.left = temp;
        return root;
    }

    /*treeNode 的右子树的左子树上插入导致不平衡,进行 left-right 旋转*/
    public static <V extends Comparable> TreeNode LRRotate(TreeNode treeNode) {
        return null;
    }

    public static void main(String[] args) {
//        AVLTree<Integer> avlTree = new AVLTree<>();
//        avlTree.treeNode = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null, null, 3), null, 5), new TreeNode(null, null, 8), 7), new TreeNode(null, null, 11), 10);
//        avlTree.treeNode = RRRotate(avlTree.treeNode);
        TreeNode t1 = new TreeNode(null, null, 3);
        TreeNode t2 = new TreeNode(null, null, 5);
        TreeNode t3 = new TreeNode(null, null, 7);
        TreeNode t4 = new TreeNode(null, null, 8);
        TreeNode t5 = new TreeNode(null, null, 10);
        TreeNode t6 = new TreeNode(null, null, 11);
        t3.left = t2;
        t3.right = t5;
        t5.left = t4;
        t5.right = t6;
        t6.right = t1;
        TreeNode ll = LLRotate(t3);
        System.out.println();

    }
}
