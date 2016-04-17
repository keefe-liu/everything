package practice.datastructure;

import java.util.Iterator;

/**
 * Created by tingfang.liu on 2016/4/14.
 */
public class SingleLinkedList<V> implements Iterable<V> {

    private Node<V> first;

    public void add(V v) {
        Node<V> node = new Node<>(v, null);
        if (first == null) {
            first = node;
            return;
        }
        Node<V> temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }


    @Override
    public Iterator<V> iterator() {
        return new MyIterator();
    }

    private final class MyIterator implements Iterator {
        Node<V> current;

        public MyIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Node<V> result;
            result = current;
            current = current.next;
            return result.v;
        }
    }

    private static class Node<V> {
        private V v;
        private Node<V> next;

        public Node(V v, Node<V> next) {
            this.v = v;
            this.next = next;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        public Node<V> next() {
            return next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Long> sll = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            sll.add(i + 1l);
        }
        for (Iterator<Long> it = sll.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        for (Long l : sll) {
            System.out.print(l);
        }
    }
}
