package exercise.datastructure;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class ArrayStack<V> {

    private Object[] vs;

    private int size = 0;

    public ArrayStack(int capacity) {
        this.vs = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == vs.length;
    }

    public void push(V v) {
        if (isFull()) {
            throw new IllegalArgumentException("full");
        }
        vs[size++] = v;
    }

    public V pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
        return (V) vs[--size];
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack(10);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        stack.pop();
        System.out.println(stack.pop());
        stack.push(100);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());
    }

}
