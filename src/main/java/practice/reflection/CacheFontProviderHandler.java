package practice.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class CacheFontProviderHandler implements InvocationHandler {

    private FontProvider fontProvider;
    private Map<String, Object> cache = new HashMap<>();

    public CacheFontProviderHandler(FontProvider fontProvider) {
        this.fontProvider = fontProvider;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws InvocationTargetException, IllegalAccessException {

        Type[] types = method.getParameterTypes();
        if (method.getName().matches("get.+") && (types.length == 1) && (types[0] == String.class)) {
            String key = (String) objects[0];
            Object value = cache.get(key);
            if (value == null) {
                value = method.invoke(fontProvider, objects);
                cache.put(key, value);
            }
            return value;
        }

        return method.invoke(fontProvider, objects);
    }
}
