package practice.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    public MyHeap(Collection<V> vs, boolean isMax) {
        // create heap 与 delete 类似
        this.elements = vs.toArray();
        this.size = elements.length;
        this.isMax = isMax;
        for (int i = (size - 1) / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int n) {
        int child = left(n);
        V root = (V) elements[n];
        while (child < size) {
            if (child + 1 < size && compare((V) elements[child], (V) elements[child + 1]) < 0) {
                child++;
            }
            if (compare(root, (V) elements[child]) < 0) {
                elements[n] = elements[child];
                n = child;
                child = left(child);
            } else {
                break;
            }
        }
        elements[n] = root;
    }

    /*通过isMax来控制是最大堆还是最小堆，compare(v1 ,v2) < 0 不代表 v1 > v2 ,只代表 v1 在 v2 上面*/
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
        int size = 88;
        List<Integer> list = new ArrayList<>(size);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println("\nbefore heapify\n" + Arrays.toString(list.toArray()));
        MyHeap heap1 = new MyHeap(list, false);
        System.out.println("\nafter heapify\n" + Arrays.toString(heap1.elements));
        System.out.println("after heapify ");
        while (!heap1.isEmpty()) {
            System.out.print(" " + heap1.delete());
        }
    }
}
