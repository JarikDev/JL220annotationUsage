package com;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Main main = new Main();
        Person person = new Person();
        main.print(person, person.getClass());
    }

    void print(Object o, Class c) throws IllegalAccessException {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().equals(Show.class)) {
                    System.out.println(field.get(o));
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface Show {
    boolean value() default true;
}

class Person {
    @Show
    String name = "Jarik";
    int age = 18;
}


















