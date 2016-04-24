package practice.reflection;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class FontProviderFromDisk implements FontProvider {
    public Font getFont(String name) {

        return new Font("正楷");
    }
}
