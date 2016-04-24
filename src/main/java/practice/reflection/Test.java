package practice.reflection;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class Test {
    public static void main(String[] args) {
        FontProvider fontProvider = FontProviderFactory.getCachedProvider();
        Font font = fontProvider.getFont("雅黑");
        System.out.println(font.getName());
    }
}
