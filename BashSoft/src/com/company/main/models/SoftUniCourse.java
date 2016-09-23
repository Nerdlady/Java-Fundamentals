package com.company.main.models;


import com.company.main.contracts.Course;
import com.company.main.contracts.Student;
import com.company.main.exceptions.DuplicateEntryInStructureException;
import com.company.main.exceptions.InvalidStringException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUniCourse implements Course {
    public static final int NUMBER_OF_TASK_ON_EXAM = 5;
    public static final int MAX_SCORE_ONE_EXAM_TASK = 100;
    private String name;
    private LinkedHashMap<String,Student> studentsByName;

    public SoftUniCourse(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new InvalidStringException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    public void enrollStudent(Student student){
        if  (this.studentsByName.containsKey(student.getUserName())){
            throw  new DuplicateEntryInStructureException(student.getUserName(),this.name);
        }
        this.studentsByName.put(student.getUserName(),student);
    }

    @Override
    public int compareTo(Course other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
