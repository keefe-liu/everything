package exercise.springaction;

import org.springframework.beans.factory.InitializingBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tingfang.liu on 2016/4/2.
 */
public class BeanT implements InitializingBean{

    private String str;

    public BeanT(){
        this.str=new SimpleDateFormat("hh:mm:ss").format(new Date());
        System.out.println(this.str);
    }

    public void initMethod(){
        System.out.println("init-method");
    }

    public void destroyMethod(){
        System.out.println("destory-method");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("done");
    }
}
