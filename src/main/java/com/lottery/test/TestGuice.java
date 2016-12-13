package com.lottery.test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import javax.inject.Inject;

/**
 * <p/>
 * User: alexhu@tcl.com
 * Date: 2016-09-05
 * Time: 17:29
 */
public class TestGuice {

    @Inject
    public Test1 test1;

    public TestGuice() {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                Test2 test2 = new Test2();
                test2.setName("tttt");
                bind(Test2.class).toInstance(test2);

                bind(Test1.class).asEagerSingleton();
            }
        });
        injector.injectMembers(this);
    }

    public static void main(String[] args) {
//        TestGuice testGuice = new TestGuice();
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(String.class).annotatedWith(Names.named("JDBC MySQL")).toInstance("jdbc:mysql://localhost/lottery");
            }
        });
        Test2 t2 = injector.getInstance(Test2.class);
        System.out.println(t2.getName());
    }

    public static class Test1 {
        private String name;
        private Test2 test2;

        @Inject
        public void create(Test2 test2) {
            this.test2 = test2;
        }

        @Override
        public String toString() {
            return "test1 name:" + name;
        }
    }

    public static class Test2 {
        private String name;

        public String getName() {
            return name;
        }

        @Inject
        public void setName(@Named("JDBC MySQL")String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "test2 name: " + name;
        }
    }
}


