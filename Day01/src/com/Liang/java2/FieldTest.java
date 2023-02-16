package com.Liang.java2;

import com.Liang.java1.MyAnnotation;
import com.Liang.java1.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Mr Liang
 * @create 2023-02-10-18:45
 */
public class FieldTest {
    @Test
    public void test() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
//    getField():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("-----------------");
//        getDeclaredFields():获取当前运行时类中声明的所有属性，(不包含父类中声明的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    //
    @Test
    public void test1() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
        MyAnnotation myAnnotation=(MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
        System.out.println("类的注解："+myAnnotation.value());
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
//        1.权限修饰符
            int modifier = f.getModifiers();
            System.out.println("权限修饰符"+Modifier.toString(modifier));
//        2.数据类型           Annotation annotation = clazz.getAnnotation();
            Class type = f.getType();
            System.out.println("数据类型："+type.getName()+"\t");
//        3.变量名
            String name = f.getName();
            System.out.println("变量名"+name);
            System.out.println("-------------------");
        }
    }
}
