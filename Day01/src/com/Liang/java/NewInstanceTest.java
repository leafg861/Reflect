package com.Liang.java;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author Mr Liang
 * @create 2023-02-01-21:01
 */
public class NewInstanceTest {
    @Test
    public void test1() throws Exception {
        Class clazz = Class.forName("com.Liang.java.Person");
        /*
        newInstance():调用此方法，创建对应的运行时类的对象。
        要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够，通常设置为Public
        在Javabean中要求提供一个public的空参构造器，原因
        1.便于通过反射，创建运行时对象
        2.便于子类继承此运行时类时，默认调用super()时，有此构造器
        * */
//        Person obj = (Person) clazz.newInstance();此方法已过时
        Person obj = (Person) clazz.getDeclaredConstructor().newInstance();
        Person obj1 = (Person) clazz.getDeclaredConstructor(String.class).newInstance("小王");
        System.out.println(obj);
        System.out.println(obj1);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(3);
            String classpath = null;
            switch (num) {
                case 0:
                    classpath = "java.lang.Object";
                    break;
                case 1:
                    classpath = "java.util.Date";
                    break;
                case 2:
                    classpath = "com.Liang.java.Person";
                    break;
            }
            Object obj = null;
            try {
                obj = getInstance(classpath);
                System.out.println(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        }
    /*
     * 创建一个指定类的对象
     * classPath指定类的全类名
     * */
    public Object getInstance(String classpath) throws Exception {
        Class clazz = Class.forName(classpath);
        return clazz.getDeclaredConstructor().newInstance();
    }
}
