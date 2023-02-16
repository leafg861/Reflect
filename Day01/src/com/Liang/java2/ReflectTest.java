package com.Liang.java2;

import com.Liang.java1.Person;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Name;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类指定的结构，主要是属性、方法、构造器
 *
 * @author Mr Liang
 * @create 2023-02-14-19:49
 */
public class ReflectTest {
    @Test
    public void testField() throws Exception {
        Class clazz = Class.forName("com.Liang.java1.Person");
//      创建运行时类的对象
//      属性是动态的，在没有指明属性的对象时，并不知道该调用哪个对象的属性，在这里需要获取指定的对象
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();
//     获取指定的属性
//     要求运行时类的属性是public的
        Field id = clazz.getField("id");
//      设置当前的属性的值
//      set():参数1：指明设置哪个对象的属性    参数2：设置当前属性的值
        id.set(p, 1001);
//      get():参数1，获取指定对象的当前属性值
        int pid = (int) id.get(p);
        System.out.println(pid);
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Class.forName("com.Liang.java1.Person");
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();
        Field name = clazz.getDeclaredField("name");
//      保证当前属性是可访问的
        name.setAccessible(true);
        name.set(p, "Tom");
        System.out.println(name.get(p));
    }

    /*
     *如何操作运行时类指定的方法
     * */
    @Test
    public void test3() throws Exception {
        Class clazz = Class.forName("com.Liang.java1.Person");
//      创建运行时类对象
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();
//      获取指定的某个方法
//      getDeclaredMethod():参数1：指明获取的方法 参数2：指明获取的方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        /*
         * invoke()：参数1：方法的调用者 参数2：给方法形参赋值的实参
         * invoke()方法的返回值即为对应类中调用方法的返回值
         * */
        String s = (String) show.invoke(p, "CHN"); //相当于正向调用 p.show(“CHN”)
        System.out.println(s);//接收调用invoke()方法后的返回值并输出

        System.out.println("******如何调用静态方法*******");
//      private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnValue = showDesc.invoke(Person.class);
        System.out.println(returnValue);
    }

    /*
     * 如何调用运行时类中的指定的构造器
     * */
    @Test
    public void test4() throws Exception {
        Class clazz = Class.forName("com.Liang.java1.Person");
//     调用Person类的构造方法 private Person(String name)
//      1.获取指定的构造器
//        getDeclaredConstructor() 参数：指明构造器的参数列表
        Constructor c = clazz.getDeclaredConstructor(String.class);
//      2.保证此构造器是可访问的
        c.setAccessible(true);
//      3.调用此构造器创建运行时类的对象
        Person per = (Person) c.newInstance("Tom");
        System.out.println(per);
    }
}