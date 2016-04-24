package practice.reflection;

import practice.jvm.ClassLoading;

import java.lang.reflect.*;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class Reflection {

    public static void main(String[] args) throws Exception {
        Class personClass = Class.forName("practice.reflection.Person");
        Constructor<Person>[] cons = personClass.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Person person1 = (Person) cons[0].newInstance();
        Person person2 = (Person) cons[1].newInstance("liutingfang", 1);
        out.println(person1.getName());
        out.println(person2.getName());
        out.println(personClass.getInterfaces()[0].getName());
        out.println(personClass.getSuperclass().getName());
        out.println(Modifier.toString(cons[0].getModifiers()));
        Method method = personClass.getDeclaredMethod("saySomething", String.class);
        method.setAccessible(true);
        method.invoke(person2, "叫我爸爸!");
        Method staticMethod = personClass.getDeclaredMethod("staticMethod");
        staticMethod.setAccessible(true);
        staticMethod.invoke(Person.class);
        Field field = personClass.getDeclaredField("privateName");
        field.setAccessible(true);
        field.set(person1, "小明");
        out.println(field.get(person1));
        out.println(personClass.getClassLoader().getClass().getName());
    }
}
