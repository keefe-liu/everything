package practice.reflection;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class Person implements Animal {
    private String name;
    private int age;
    private String privateName;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println(name + " eat sandwich");
    }

    private void saySomething(String sth) {
        System.out.println(name + "说: " + sth);
    }

    private static void staticMethod() {
        System.out.println("我是 static method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
