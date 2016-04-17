package exercise.datastructure;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/17.
 */
public class DeleteFromTree {

    public static <V extends Comparable> BinarySearchTree deleteFromTree(BinarySearchTree binarySearchTree, V v) {
        if (binarySearchTree != null) {
            BinarySearchTree rightMin;
            int compare = v.compareTo(binarySearchTree.getV());
            if (compare < 0) {
                binarySearchTree.setLeft(deleteFromTree(binarySearchTree.getLeft(), v));
            } else if (compare > 0) {
                binarySearchTree.setRight(deleteFromTree(binarySearchTree.getRight(), v));
            } else {
                BinarySearchTree left = binarySearchTree.getLeft();
                BinarySearchTree right = binarySearchTree.getRight();
                if (left != null && right != null) {
                    rightMin = right.findMin();
                    binarySearchTree.setV(rightMin.getV());
                    binarySearchTree.setRight(deleteFromTree(right, rightMin.getV()));
                } else {
                    if (left != null) {
                        binarySearchTree = left;
                    } else {
                        binarySearchTree = right;
                    }
                }
            }
        }
        return binarySearchTree;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(50, null, null);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] elements = new int[14];
        int temp;
        for (int i = 14; i > 0; i--) {
            temp = random.nextInt(100);
            elements[i - 1] = temp;
            binarySearchTree.insert(temp);
        }
        out.println("before delete ");
        InOrderTraversal.inOrderTraversal(binarySearchTree);
        for (int i = 14; i > 0; i--) {
            deleteFromTree(binarySearchTree, elements[i - 1]);
            out.println("\n after delete " + elements[i - 1]);
            InOrderTraversal.inOrderTraversal(binarySearchTree);
        }
    }
}
