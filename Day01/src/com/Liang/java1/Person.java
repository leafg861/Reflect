package com.Liang.java1;

/**
 * @author Mr Liang
 * @create 2023-02-10-17:48
 */
@MyAnnotation(value="hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation
    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    public String diplay (String interest, int age) throws NullPointerException,RuntimeException{
        return interest + age;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
    private static void showDesc(){
        System.out.println("Xxx");
    }
}
