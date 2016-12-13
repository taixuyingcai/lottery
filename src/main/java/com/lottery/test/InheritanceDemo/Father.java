package com.lottery.test.InheritanceDemo;

/**
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-30
 * Time: 16:41
 */
public class Father {
    static
    {
        System.out.println("father static ");
    }

    public static int age = 10;
    public int x = 10;

    public Father() {
        System.out.println("father constructor x=" + x);
        age();
    }

    public void age() {
        System.out.println("nothing...");
    }

}
