package com.lottery.test.InheritanceDemo;

/**
 * 静态块(只执行一次)(父类->子类)  父类非静太代码块(每次加载都执行) 父类构造方法 子类非静态块(每次加载都执行) 子类构造方法
 * 在构造方法完成前 成员属性的值都是默认的
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-30
 * Time: 16:44
 */
public class Child extends Father {

    static {
        System.out.println("child static");
    }

    private int age = 20;
    {
        age = 30;
    }

    // 与父类同样的属性
    public int x = 100;

    public Child() {
        this("child constructor..");
        System.out.println("child constructor body age = " + age);
    }

    public Child(String s) {
        System.out.println("child constructor s=" + s);
    }

    public void age() {
        System.out.println("age = " + age);
    }

    public void printX() {
        System.out.println("print x=" + x);
    }

    public static void main(String... args) {
        new Child().printX();
    }
}
