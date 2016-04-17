package practice.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by tingfang.liu on 2016/3/31.
 */
public class KnightMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
        //ApplicationContext context = new FileSystemXmlApplicationContext("d:/access/knights.xml");
        //ApplicationContext context = new XmlWebApplicationContext();
        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();
    }
}
