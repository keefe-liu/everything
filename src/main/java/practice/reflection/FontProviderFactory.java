package practice.reflection;

import java.lang.reflect.Proxy;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public abstract class FontProviderFactory {

    public static FontProvider getProvider() {
        return new FontProviderFromDisk();
    }

    public static FontProvider getCachedProvider() {
        return new CachedFontProvider();
    }

    public static FontProvider getFontProvider() {
        Class<FontProvider> target = FontProvider.class;
        return (FontProvider) Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, new CacheFontProviderHandler(new FontProviderFromDisk()));
    }
}
