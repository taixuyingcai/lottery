package com.lottery.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.multibindings.Multibinder;
import com.lottery.commons.service.ServiceEntry;

/**
 *提供service的注入服务。通过bindService方法注入
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-30
 * Time: 15:54
 */
public abstract class ServiceModule extends AbstractModule {

    protected synchronized <T> void bindService(Class<T> serviceInterface, Class<? extends T> serviceImpl) {
        bind(serviceInterface).to(serviceImpl).asEagerSingleton();
        Key<T> key = Key.get(serviceInterface);

        Multibinder<ServiceEntry> multibinder = Multibinder.newSetBinder(binder(), ServiceEntry.class);
        multibinder.addBinding().toInstance(new ServiceEntry(serviceInterface.getSimpleName(),
                serviceInterface.getName(), key, null));
    }

}
