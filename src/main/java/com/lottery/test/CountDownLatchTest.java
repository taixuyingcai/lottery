package com.lottery.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 10名选手准备赛跑,裁判一声令下,开始跑. 全部跑到终点后 结束
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-12-05
 * Time: 18:02
 */
public class CountDownLatchTest {

    public static void main(String... args) {
        // begin flag
        final CountDownLatch begin = new CountDownLatch(1);
        // end flag
        final CountDownLatch end = new CountDownLatch(10);

        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            final int NO = i;
            executorService.submit(
                    () -> {
                        try {
                            begin.await(); // 等待,直到begin数量为0时(裁判发开始命令),得以继续运行
                            System.out.println("begin run ....." + Thread.currentThread().getName());
                            Thread.sleep((long) (Math.random() * 1000));
                            System.out.println("breast the yarn NO." + NO);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            end.countDown(); // 到达终点时数量减1
                        }
                    });
        }
        System.out.println("Game Start...");
        begin.countDown(); // 发开始命令,所以运动员可以开始跑
        try {
            end.await(); // 等待所有运动员到达终点
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Game end...");

    }
}
