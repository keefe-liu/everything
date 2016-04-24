package practice.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class InvocationHandlerTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyInvocationHandler proxy = new MyInvocationHandler();
        Subject subject = (Subject) proxy.bind(new RealSubject());
        subject.say("快睡觉了");
        String time = subject.sleep("十点");
        System.out.println(time);

        MyInvocationHandler proxy1 = new MyInvocationHandler();
        Animal person = (Animal) proxy1.bind(new Person());
        person.eat();

    }
}

interface Subject {
    void say(String sth);

    String sleep(String time);
}

class RealSubject implements Subject {
    @Override
    public void say(String sth) {
        System.out.println(sth);
    }

    @Override
    public String sleep(String time) {
        System.out.println(time + " 就去睡");
        return time + 123;
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws InvocationTargetException, IllegalAccessException {

        System.out.println("do log before");
        Object result = method.invoke(object, objects);
        System.out.println("do log after");
        return result;
    }
}
