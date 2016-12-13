package com.lottery.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-29
 * Time: 17:02
 */
public class CommonTest {

    public static void main(String...args) {
//        byte a = 127;
//        byte b = 127;
//        a += b;
//        System.out.print(a);
//        Map<String, Integer> aa = new HashMap<>();
//        Arrays.toString(new int[]{1,2,3,4,5});
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

//        Calendar calendar = Calendar.getInstance(Locale.UK);
//        String s = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
//        String dateStr = "29 Ноябрь 2016";
//        SimpleDateFormat sd = new SimpleDateFormat("dd MM YYYY");
//        try {
//            Date date = sd.parse(dateStr);
//            System.out.println(date.getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(s);
//
//        Collections.synchronizedCollection(Lists.newArrayList());
//        Collections.synchronizedMap(Maps.newHashMap());
//        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i <= 10; i++) {
            System.out.println(hash(i));
        }

//        System.out.println(16 >> 2);
//        System.out.println(16 >>> 2);

        Semaphore semaphore = new Semaphore(1);
        try {
            semaphore.acquire();
        } catch (Exception e) {

        }
        semaphore.release();
    }

    private static int hash(int key) {
        long factor = 2654435769l; // 32位
        return (int)((key * factor) >> 28);
    }
}
