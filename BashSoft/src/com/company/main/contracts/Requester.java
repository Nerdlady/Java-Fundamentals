package com.company.main.contracts;

import com.company.main.dataStructures.SimpleSortedList;

import java.util.Comparator;

public interface Requester {
   void  getStudentsMarksInCourse(String course, String student);
    void getStudentsByCourse(String course);
    SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> comparator);
    SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> comparator);

}
