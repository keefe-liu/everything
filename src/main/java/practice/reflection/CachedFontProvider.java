package practice.reflection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class CachedFontProvider implements FontProvider {

    public CachedFontProvider() {
    }

    private Font font;
    private Map<String, Font> cache = new HashMap<>();

    @Override
    public Font getFont(String name) {
        Font result = cache.get(name);
        if (result == null) {
            result = new Font(name);
            cache.put(name, result);
        }
        return result;
    }
}
