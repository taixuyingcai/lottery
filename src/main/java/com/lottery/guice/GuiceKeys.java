package com.lottery.guice;

import com.google.inject.Key;
import com.google.inject.util.Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * guice key 工具类
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-06
 * Time: 15:27
 */
public class GuiceKeys {

    public static <T> Key<T> getSimpleKey(Type rawType, Type... typeArguments) {
        ParameterizedType type = Types.newParameterizedType(rawType, typeArguments);
        return (Key<T>) Key.get((Type) type);
    }
}
