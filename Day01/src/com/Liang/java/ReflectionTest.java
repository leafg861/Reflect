package com.Liang.java;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Mr Liang
 * @create 2023-01-28-22:50
 */
public class ReflectionTest {
    @Test
    public void test() {
//      在反射之前，对于Person的操作，不能通过Person类对象调用其内部的私有属性和方法
        Person p1 = new Person("Tom", 12);
        p1.age = 10;
        System.out.println(p1);
        p1.show();
    }
    @Test
    //       在反射之后
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
//      通过反射创造Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj=cons.newInstance("Tom",12);
        System.out.println(obj.toString());
//       通过反射调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(obj,10);
        System.out.println(obj.toString());
//       调用方法
        Method show = clazz.getDeclaredMethod("show");//调用空参show方法
        show.invoke(obj);
//        通过反射可以调用私有结构，私有方法，私有属性
        Constructor cons1 = clazz.getDeclaredConstructor(String.class,int.class);
        cons1.setAccessible(true);
        Person p=(Person)cons1.newInstance("Jerry",6);
        System.out.println(p.toString());
//      调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"Bob");
        System.out.println(p);
//      调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p,"中国");
    }
    @Test
    public void test3() throws ClassNotFoundException {
//        方式一:
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
//        方式二：
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
//        方式三
        Class clazz3 = Class.forName("com.Liang.java.Person");
        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);
//       方式四
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.Liang.java.Person");
        System.out.println(clazz4);
    }
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
// 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
