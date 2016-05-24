package practice.datastructure;

/**
 * Created by tingfang.liu on 2016/5/24.
 */
public class ReverseNode {
    private static class Node<V> {
        V v;
        Node<V> next;

        Node(V v, Node next) {
            this.v = v;
            this.next = next;
        }
    }

    static Node reverse(Node node) {

        Node tNext = node.next;
        if (tNext == null) {
            return node;
        }
        Node rNext = reverse(tNext);
        tNext.next = node;
        node.next = null;

        return rNext;
    }

    static Node reverse2(Node node) {

        if (node == null) {
            return node;
        }
        Node head = node;
        Node hNext = node.next;
        Node temp;
        while (hNext != null) {
            temp = hNext.next;
            hNext.next = head;
            head = hNext;
            hNext = temp;
        }
        node.next = null;
        return head;
    }

    static Node newNode(int length) {
        Node tail = new Node(length, null);
        Node result = tail;
        while (--length > 0) {
            result = new Node(length, tail);
            tail = result;
        }
        return result;
    }

    static void visitNode(Node node) {
        while (node != null) {
            System.out.print(node.v + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node n1 = newNode(10);
        visitNode(n1);
        n1 = reverse2(n1);
        visitNode(n1);
        n1 = reverse2(n1);
        visitNode(n1);
        n1 = reverse2(n1);
        visitNode(n1);
    }
}
