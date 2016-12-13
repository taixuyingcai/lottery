package com.lottery.test;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.sun.tools.corba.se.idl.StringGen;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JAVA8中的流操作
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-18
 * Time: 15:15
 */
public class TestStream {

    public static void main(String... args) {

        List<Integer> list = Lists.newArrayList(1, 1, null, 3, 4, 6, null, 8, 9);
        System.out.println(list.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println)
                .skip(2).limit(4).sum());

        List<String> names = Lists.newArrayList("adBd", "JamesBlock", "Smith");
        System.out.println(names.stream().map(String::toLowerCase).collect(Collectors.toList()));

        String[] list1 = {"a", "b", "c"};
        for (Integer i : Lists.newArrayList(1, 2, 3)) {
            Stream.of(list1).map(item -> Strings.padEnd(item, i, '@')).forEach(System.out::println);
        }
    }

}
