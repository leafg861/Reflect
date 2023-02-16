package com.Liang.java;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Mr Liang
 * @create 2023-02-01-16:02
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
//        对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
//        调用系统类加载器的getParent()
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
//        调用扩展类加载器的getParent():无法获取引导类加载器
//        引导类加载器主要负责java的核心类库，无法加载自定义类的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    @Test
    public void test2() throws Exception {
//        Properties用来读取配置文件
        Properties pros = new Properties();
//        此时文件默认在当前module下
//        读取配置文件方式一
       /* FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);*/
//        方式二通过类的加载器
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = ClassLoaderTest.class.getResourceAsStream("jdbc.properties");
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user=" + user + ",password=" + password);
    }
}
