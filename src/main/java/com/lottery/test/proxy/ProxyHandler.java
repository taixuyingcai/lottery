package com.lottery.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-23
 * Time: 15:22
 */
public class ProxyHandler implements InvocationHandler {

    private Object proxied;

    public ProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dosomething before....");
        method.invoke(proxied, args);
        System.out.println("dosomething after...");
        return null;
    }
}
