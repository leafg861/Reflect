package com.Liang.java2;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

/**
 * @author Mr Liang
 * @create 2023-02-11-13:50
 */
public class MethodTest {
    @Test
    public void test1() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
//   获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("---------------");
//        getDeclaredMethods()获取当前运行类中声明的所有方法（不包含父类中的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    /*
     * @Xxxx
     * 权限修饰符 返回值类型 方法名(参数类型1 形参名1，...) throw XxxException()
     * */
    @Test
    public void test2() throws ClassNotFoundException {
        Class clazz = Class.forName("com.Liang.java1.Person");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            //1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            //3.方法的返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");
            //5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " args" + i);
                    }else {
                        System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                    }
                }
            }
            System.out.print(")");
//            6.获取方法可能抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(!(exceptionTypes==null&&exceptionTypes.length==0)){
                if(exceptionTypes.length!=0){
                    System.out.print("throws ");
                }
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i==exceptionTypes.length-1){
                        System.out.print(exceptionTypes[i].getName());
                    }else {
                        System.out.print(exceptionTypes[i].getName()+",");
                    }
                }
            }
            System.out.println();
        }
    }
}
