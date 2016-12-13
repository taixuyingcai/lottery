package com.lottery.test;

import com.googlecode.mp4parser.ByteBufferByteChannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * ByteBuffer
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-30
 * Time: 11:08
 */
public class ByteBufferTest {

    public static void main(String...args) {
//        String str = "abcd";
//        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
//        byteBuffer.put(str.getBytes());
//        System.out.println(byteBuffer.limit()+ ":" +byteBuffer.position());
//        byteBuffer.flip();
//        System.out.println(byteBuffer.limit()+ ":" +byteBuffer.position());
//        byte[] bytes = new byte[byteBuffer.limit()];
//        byteBuffer.get(bytes);
//        System.out.println(new String(bytes));
//        byteBuffer.clear();

//        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
//        byteBuffer.order(ByteOrder.BIG_ENDIAN);
//        byteBuffer.asIntBuffer().put(1);
//        byteBuffer.asIntBuffer().put(2);
//        System.out.println(Arrays.toString(byteBuffer.array()));
//        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
//        byteBuffer.asIntBuffer().put(3);
//        byteBuffer.asIntBuffer().put(4);
//        System.out.println(Arrays.toString(byteBuffer.array()));
//        byteBuffer.getInt();
//
//        byteBuffer.clear(); // position = 0 limit = capacity  mark = -1  重置位置（内容并没有清空）
//        byteBuffer.flip(); // limit = position postion = 0; mark = -1   把position置0，limit置成原来position的位置，是为了只能读取写入的数据
//        byteBuffer.compact();
        readFile();
    }

    // 读取文件
    private static void readFile() {
        try {
            RandomAccessFile file = new RandomAccessFile("d://crwa.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int byteRead = channel.read(byteBuffer);
            while (byteRead != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println((char) byteBuffer.get());
                }
                byteBuffer.clear();
                byteRead = channel.read(byteBuffer);
            }
            file.close();
        } catch (Exception e) {

        }
    }
}
