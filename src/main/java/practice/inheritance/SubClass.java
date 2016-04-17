package practice.inheritance;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * Created by tingfang.liu on 2016/3/15.
 */
public class SubClass extends SuperClass {

    public SubClass(String superField, String subField)  {
        super(superField);
        this.subField = subField;
        InnerClass ic=this.new InnerClass();
    }

    public class InnerClass {
        public InnerClass() {
            if (StringUtils.isNotBlank(SubClass.this.subField)) {
                System.out.println(subField);
            }
        }
    }

    private String subField;

    public String getSubField() {
        return subField;
    }

    public void setSubField(String subField) {
        this.subField = subField;
    }

    public static void main(String[] args) {

        Class<SuperClass> clz = SuperClass.class;
        Field[] fields = clz.getDeclaredFields();

        System.out.println("fuck");
        System.out.println(fields.length);
        for (Field f : fields) {
            System.out.println(f.getType().getName());
        }
    }
}
