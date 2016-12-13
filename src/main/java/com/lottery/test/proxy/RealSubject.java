package com.lottery.test.proxy;

/**
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-23
 * Time: 15:21
 */
public class RealSubject implements Subject {
    @Override
    public void doSomeThing() {
        System.out.println("RealSubject do something...");
    }

    @Override
    public void doSomeThing1() {
        System.out.println("RealSubject do something1...");
    }
}
