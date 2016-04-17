package practice.inheritance;

/**
 * Created by tingfang.liu on 2016/3/15.
 */
public class SuperClass {

    public SuperClass(String superField) {
        this.superField = superField;
    }

    private String superField;

    public String getSuperField() {
        return superField;
    }

    public void setSuperField(String superField) {
        this.superField = superField;
    }

    public static int test(int i) {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {

        System.out.println(test(1));
    }
}
