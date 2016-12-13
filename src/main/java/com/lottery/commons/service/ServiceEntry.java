package com.lottery.commons.service;

import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;

import java.util.List;
import java.util.Set;

/**
 * 服务实体封装类  可以把这种类型的服务从guice中注入到spring中
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-17
 * Time: 17:44
 */
public class ServiceEntry {

    public static final TypeLiteral<Set<ServiceEntry>> SET_TYPE_LITERAL = (TypeLiteral<Set<ServiceEntry>>)
            TypeLiteral.get(Types.setOf(ServiceEntry.class));
    public static final Key<Set<ServiceEntry>> SET_KEY = Key.get(SET_TYPE_LITERAL);

    private final String name;

    private final String className;

    private final Key<?> guiceKey;

    private final String annotatedName;

    public ServiceEntry(String name, String className, Key<?> guiceKey, String annotatedName) {
        this.name = name;
        this.className = className;
        this.guiceKey = guiceKey;
        this.annotatedName = annotatedName;
    }

    /**
     *取得所有serviceEntry类型的服务
     * @return
     */
    public static Set<ServiceEntry> getAllService(Injector injector) {
        List<Binding<Set<ServiceEntry>>> bindingList = injector.findBindingsByType(SET_TYPE_LITERAL);
        if (bindingList == null || bindingList.isEmpty()) {
            throw new IllegalStateException("Can't find define ServiceEntry.");
        }
        return injector.getInstance(SET_KEY);
    }

    public String getAnnotatedName() {
        return annotatedName;
    }

    public String getName() {
        return name;
    }

    public Key<?> getGuiceKey() {
        return guiceKey;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ServiceEntry that = (ServiceEntry) o;
        if (!name.equals(that.name)) return false;
        if (!guiceKey.equals(that.guiceKey)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + guiceKey.hashCode();
        return result;
    }
}
