package com.intouch.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final String PATH = "serviceMethods.properties";
    private static Properties props = new Properties();

    static {
        ClassLoader loader = PropertiesUtil.class.getClassLoader();
        InputStream is = loader.getResourceAsStream(PATH);
        try {
            props.load(is);
        } catch (IOException e) {
            System.out.println("properties文件加载失败！");
            e.printStackTrace();
        }

    }

    private PropertiesUtil() {
    }

    public static String getPropertyValue(String key) {
        return props.getProperty(key);
    }
}
