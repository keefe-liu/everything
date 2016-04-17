package practice.springaction;

/**
 * Created by tingfang.liu on 2016/3/31.
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    public int getBeanBags() {
        return beanBags;
    }

    public void setBeanBags(int beanBags) {
        this.beanBags = beanBags;
    }

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    public void perform() {
        System.out.println("Juggler " + beanBags);
    }
}
