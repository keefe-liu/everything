package exercise.datastructure;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class LinkedStack<V> {

    static class ListNode<V> {
        V v;
        ListNode<V> next;


        public int size() {
            int i = 1;
            ListNode<V> temp = next;
            while (temp != null) {
                temp = temp.next;
                i++;
            }
            return i;
        }

        public ListNode(V v, ListNode<V> next) {
            this.v = v;
            this.next = next;
        }
    }

    private ListNode<V> listNode;

    public LinkedStack() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return listNode == null ? 0 : listNode.size();
    }

    public void push(V v) {
        ListNode<V> node = new ListNode<>(v, listNode);
        this.listNode = node;
    }

    public V pop() {
        ListNode<V> temp = listNode;
        if (temp == null) {
            throw new IllegalArgumentException("empty");
        }
        this.listNode = listNode.next;
        return temp.v;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(stack.pop());
        }
        stack.push(111);
        stack.push(222);
        stack.push(333);
        for (int i = 0; i < 4; i++) {
            System.out.println(stack.pop());
        }
    }
}