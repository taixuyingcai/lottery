package com.lottery.test;

import java.io.FilePermission;

/**
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-24
 * Time: 14:20
 */
public class SecurityTest {

    public static void main(String...args) {
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager);
        securityManager.checkPermission(new FilePermission("d:\\", "read"));

    }
}
