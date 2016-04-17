package practice.springaction;

import org.springframework.stereotype.Component;

/**
 * Created by tingfang.liu on 2016/4/1.
 */
@Component
public class Poem {
    private int a;

    public Poem() {
    }

    public Poem(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}