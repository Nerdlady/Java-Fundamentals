package com.company.main.contracts;

import java.util.Map;

public interface Student extends Comparable<Student> {
    String getMarkForCourse(String courseName);
    void setMarksInCourse(String courseName,int... scores);
    void	enrollInCourse(Course course);
    Map<String, Double> getMarksByCourseName();
    Map<String, Course> getEnrolledCourses();
    String getUserName();
}
