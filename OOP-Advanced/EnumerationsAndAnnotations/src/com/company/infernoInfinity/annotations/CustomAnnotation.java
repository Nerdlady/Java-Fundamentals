package com.company.infernoInfinity.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    String author();
    int revision();
    String description();
    String[] reviewers();
}
