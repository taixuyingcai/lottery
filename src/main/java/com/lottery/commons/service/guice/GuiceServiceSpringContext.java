package com.lottery.commons.service.guice;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.lottery.commons.service.ServiceEntry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;
import java.util.Set;

/**
 * 奖guice容器中管理的对象注入的spring的容器中，可以在springmvc中使用
 * 需要注意的是,只有绑定到 {@link ServiceEntry}的service才会被注册到spring中
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-17
 * Time: 17:38
 */
public class GuiceServiceSpringContext extends AbstractApplicationContext {

    private Guice2SpringBeanFactory beanFactory;

    public GuiceServiceSpringContext(List<Module> modules) {
        beanFactory = new Guice2SpringBeanFactory(modules);
        refresh();
    }

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {

    }

    @Override
    protected void closeBeanFactory() {

    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return beanFactory;
    }

    private static final class Guice2SpringBeanFactory extends DefaultListableBeanFactory {
        private final Injector injector;

        public Guice2SpringBeanFactory(List<Module> modules) {
            List<Module> allModule = Lists.newArrayList();
            allModule.addAll(modules);
            injector = Guice.createInjector(allModule);
            Set<ServiceEntry> serviceEntries = ServiceEntry.getAllService(injector);
            for (ServiceEntry serviceEntry : serviceEntries) {
                Object instance = injector.getInstance(serviceEntry.getGuiceKey());
                String annotatedName = serviceEntry.getAnnotatedName();
                if (annotatedName == null) {
                    this.registerSingleton(serviceEntry.getClassName(), instance);
                } else {
                    // 如果有注解名称则用注解名称注入
                    this.registerSingleton(annotatedName, instance);
                }
            }
        }
    }
}
