package practice.datastructure;

/**
 * Created by tingfang.liu on 2016/4/17.
 */
public class MyHeap<V extends Comparable> {
    private Object[] elements;

    private int size;

    private boolean isMax;

    public MyHeap(int capacity, boolean isMax) {
        this.elements = new Object[capacity];
        this.isMax = isMax;
    }

    /*通过isMax来控制是最大堆还是最小堆*/
    private int compare(V v1, V v2) {
        return isMax ? v1.compareTo(v2) : v2.compareTo(v1);
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(V v) {
        int index = size;
        if (!isEmpty()) {
            V parent = (V) elements[parent(index)];
            while (index > 0 && compare(v, parent) > 0) {
                elements[index] = parent;
                index = parent(index);
                if (index > 0) {
                    parent = (V) elements[parent(index)];
                }
            }
        }
        size++;
        elements[index] = v;
    }

    public V delete() {
        if (isEmpty()) {
            return null;
        }
        V result = (V) elements[0];
        int index = 0;
        V temp = (V) elements[--size];
        int parent = 0;
        /*left 与 right 中较大的下标*/
        int child;
        while (left(parent) < size) {
            child = left(parent);
            if (child + 1 < size && compare((V) elements[child], (V) elements[child + 1]) < 0) {
                //找出较大元素的下标
                child++;
            }
            if (compare(temp, (V) elements[child]) > 0) {
                break;
            } else {
                elements[parent] = elements[child];
                parent = child;
            }
        }
        elements[parent] = temp;
        return result;
    }

    private int left(int index) {
        return (index << 1) + 1;
    }

    private int right(int index) {
        return (index + 1) << 1;
    }

    private int parent(int index) {
        return (index - 1) >> 1;
    }

    public static void main(String[] args) {
        MyHeap<Integer> heap = new MyHeap<>(25, false);
        for (int i = 0; i < 21; i++) {
            heap.insert(i + 1);
        }
        while (!heap.isEmpty()) {
            System.out.print(" " + heap.delete());
        }
    }
}
