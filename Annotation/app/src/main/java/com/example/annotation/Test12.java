package com.example.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.example.annotation.Student2");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation: annotations) {
            System.out.println(annotation);
        }

        Tablekuang tablekuang = (Tablekuang)c1.getAnnotation(Tablekuang.class);
        String value = tablekuang.value();
        System.out.println(value);

        Field field = c1.getDeclaredField("id");
        Fieldkuang annotation = field.getAnnotation(Fieldkuang.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@Tablekuang("db_student")
class Student2 {
    @Fieldkuang(columnName = "db_id", type="int", length = 10)
    private int id;
    @Fieldkuang(columnName = "db_id", type="int", length = 10)
    private int age;
    @Fieldkuang(columnName = "db_id", type="varchar", length = 3)
    private String name;

    Student2() {

    }

    Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

// 类名的注解
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Tablekuang {
    String value();
}

// 属性的注解
@interface Fieldkuang {
    String columnName();
    String type();
    int length();
}
