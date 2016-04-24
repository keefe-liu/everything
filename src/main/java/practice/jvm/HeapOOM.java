package practice.jvm;


/**
 * Created by tingfang.liu on 2016/4/23.
 */
public class HeapOOM {

    public void dontStop() {
        while (true) {
        }
    }

    @Deprecated
    public void leakStack() {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        HeapOOM hoom = new HeapOOM();
        hoom.leakStack();
    }
}
