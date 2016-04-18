package practice.datastructure;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by tingfang.liu on 2016/4/18.
 */
public class LinkQueue<V> {

    static class Node<V> {
        V v;
        Node<V> next;

        public Node(V v) {
            this.v = v;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        public Node<V> getNext() {
            return next;
        }

        public void setNext(Node<V> next) {
            this.next = next;
        }
    }

    private Node<V> head;

    private Node<V> tail;

    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(V v) {
        Node<V> newNode = new Node<>(v);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public V poll() {
        if (isEmpty()) {
            return null;
        }
        V v = head.v;
        size--;
        head = head.next;
        return v;
    }

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int temp;
        int size = 20;
        LinkQueue queue = new LinkQueue();
        for (int i = 0; i < size; i++) {
            temp = random.nextInt(100);
            queue.offer(temp);
            System.out.print(temp + " ");
        }
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
