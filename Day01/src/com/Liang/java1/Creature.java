package com.Liang.java1;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

/**
 * @author Mr Liang
 * @create 2023-02-10-17:49
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
    @Test
    public void test4(){

    }
}
