package practice.inheritance;

/**
 * Created by tingfang.liu on 2016/4/20.
 */
public class Example {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch = new char[]{'m', 'b', 'h'};
        ch[0] = 'g';
    }
}