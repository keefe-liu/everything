package exercise.springaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tingfang.liu on 2016/3/31.
 */
public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("performers.xml");
        PoeticJuggler b100 = (PoeticJuggler) context.getBean("beanBags100");
        b100.perform();
        System.out.println(b100.getPoem().getA());
    }
}
