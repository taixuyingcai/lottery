package com.lottery.test;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-25
 * Time: 10:47
 */
public class EightTest {

    public static void main(String...args) {
//        new Thread(
//                (Runnable) ()->{
//                    System.out.println("run ...");
//                }
//        ).start();

        Function<String, String> function = (x) -> {System.out.print(x + ": "); return "Function";};
        System.out.println(function.apply("hello world"));

        Runnable runnable = () -> {
          System.out.print("run...");
        };
        runnable.run();
    }
}
