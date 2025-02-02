package com.problems.function;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


// Repeated annotation
@Repeatable(Roles.class)
@Retention(RetentionPolicy.RUNTIME)
@interface  Role{
   String name();
}

// Container Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Roles{
    Role[] value();
}

@Role(name = "Ashraf")
@Role(name="Saif")
public class RepeatableAnnotation {
    public static void main(String[] args) {
            if(RepeatableAnnotation.class.getAnnotation(Roles.class)!=null){
                Roles annotation = RepeatableAnnotation.class.getAnnotation(Roles.class);
                for (Role an : annotation.value()){
                    System.out.println(an.name());
                }
            }
    }
}
