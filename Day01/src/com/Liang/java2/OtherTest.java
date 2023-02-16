package com.Liang.java2;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Mr Liang
 * @create 2023-02-14-15:19
 */
public class OtherTest {
    @Test
    public void test1() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
//        获取当前运行时类中声明为Public的构造器
        Constructor[] constructor = clazz.getConstructors();
        for (Constructor c : constructor) {
            System.out.println(c);
        }
        System.out.println();
//        获取当前运行时类中所有的构造器
        Constructor[] declaredConstructor = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructor) {
            System.out.println(c);
        }
    }

    @Test
    public void test2() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
//       获取运行时类的泛型
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
//        获取运行时类的带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
//        获取运行时类带泛型的父类的泛型
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;//强制类型转换为ParameterizedType类，带参数类型的类
//      获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();//获取实际的参数，这里即为泛型
//       这里本质上Class类实现了Type类，返回的一个类型也是Class,可以强转为Class类
        System.out.println(((Class) actualTypeArguments[0]).getTypeName());
    }

    @Test
    public void test3() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
//       获取运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }
//        获取运行时类父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }
    }

    @Test
    public void test4() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
//        获取运行时类所在的包名
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    @Test
    public void test5() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
        Annotation[] annotation = clazz.getAnnotations();
//        获取运行时类声明的注解
        for (Annotation a : annotation) {
            System.out.println(a);
        }
    }
}
