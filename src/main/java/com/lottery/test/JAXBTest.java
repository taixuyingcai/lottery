package com.lottery.test;

import com.lottery.conf.redis.RedisConf;
import com.lottery.xml.JAXBContextUtil;

/**
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-24
 * Time: 18:05
 */
public class JAXBTest {

    public static void main(String...args) {
        RedisConf redisConf = JAXBContextUtil.unmarshal(RedisConf.class, "conf/redis_conf.xml");
        System.out.println(redisConf.getPath());
        System.out.println(redisConf.getServices().get(0).getName());
    }
}
