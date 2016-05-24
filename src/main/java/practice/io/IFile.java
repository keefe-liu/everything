package practice.io;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingfang.liu on 2016/4/29.
 */
public class IFile {
    public static void main(String[] args) {
        List<SimpleDateFormat> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            list.add(new SimpleDateFormat("yyyy-MM-dd"));
        }
    }
}
