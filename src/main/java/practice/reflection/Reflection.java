package practice.reflection;

import practice.algorithm.QuickSort;
import practice.jvm.ClassLoading;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class Reflection {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("practice.jvm.ClassLoading");
            ClassLoading classLoading = (ClassLoading) c.newInstance();
            classLoading.main(new String[]{""});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
