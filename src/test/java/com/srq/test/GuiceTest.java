package com.srq.test;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**guic 注入测试
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-07-27
 * Time: 14:49
 */
public class GuiceTest {

    interface Person {
       public void say();
    }

    static class School {
        @Inject
        private Person person;
        @Inject
        @Named("JDBC")
        private String jdbc;

        private void say() {
            person.say();
        }
    }

    static class Teacher implements Person {
        public void say() {
            System.out.println("i am a teacher!");
        }
    }

    static class PersonModule implements Module {
        @Override
        public void configure(Binder binder) {
            binder.bind(Person.class).to(Teacher.class);
            binder.bind(String.class).annotatedWith(Names.named("JDBC")).toInstance("jdbc:mysql://localhost/pizza");
        }
    }

    public static void main(String...args) {

        Injector injector = Guice.createInjector(new PersonModule());
        School school = injector.getInstance(School.class);
        school.say();

        System.out.println(school.jdbc);
        
    }

}
