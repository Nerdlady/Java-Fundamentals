package com.company._07;


import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Immutable {
    public static void main(String[] args) {
        Field[] fields = ImmutableList.class.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatException();
        }

        System.out.println(1);

        java.lang.reflect.Method[] methods = ImmutableList.class.getDeclaredMethods();
        List<Method> methodsReturnTypes = Arrays.stream(methods).filter(m -> {
            if (!m.getReturnType().getSimpleName().equalsIgnoreCase("ImmutableList")) {
                return false;
            }

            return true;
        }).collect(Collectors.toList());

        if (methodsReturnTypes.size() < 1) {
            throw new ClassFormatException();
        }
        System.out.println(5);

    }
}

class ImmutableList{
    private LinkedList<Integer> integers;

    public ImmutableList(LinkedList<Integer> ints) {
        this.integers = ints;
    }

    public ImmutableList ImmutableList() {
        LinkedList<Integer> b =new LinkedList<Integer>();
        Collections.copy(b, integers);
        return new ImmutableList(b);
    }
}
