package com.company.main.repository;

import com.company.main.contracts.*;
import com.company.main.dataStructures.SimpleSortedList;
import com.company.main.io.OutputWriter;
import com.company.main.models.SoftUniCourse;
import com.company.main.models.SoftUniStudent;
import com.company.main.staticData.ExceptionMessages;
import com.company.main.staticData.SessionData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsRepository implements Database {
    private boolean isDataInitialized = false;
    private LinkedHashMap<String, Course> courses;
    private LinkedHashMap<String, Student> students;
    private DataFilter filter;
    private DataSorter sorter;

    public StudentsRepository(DataFilter filter, DataSorter sorter) {
        this.filter = filter;
        this.sorter = sorter;
    }

    public void loadData(String fileName) {
        if (isDataInitialized) {
            throw new RuntimeException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
        }
        this.courses = new LinkedHashMap<>();
        this.students = new LinkedHashMap<>();
        readData(fileName);
        isDataInitialized = true;
    }

    public void unloadData() {
        if (!this.isDataInitialized) {
            throw new RuntimeException(ExceptionMessages.DATA_NOT_INITIALIZED);
        }

        this.courses = null;
        this.students = null;
        this.isDataInitialized = false;
    }


    public void readData(String fileName) {
        String regex = "([A-Z][a-zA-Z#\\+]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Za-z]+\\d{2}_\\d{2,4})\\s([\\s0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        String path = SessionData.currentPath + "\\" + fileName;
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                matcher = pattern.matcher(line);
                if (!line.isEmpty() && matcher.find()) {
                    String courseName = matcher.group(1);
                    String studentName = matcher.group(2);
                    String scoresStr = matcher.group(3);

                    try {
                        String[] splitScores = scoresStr.split("\\s+");
                        int[] scores = new int[scoresStr.length()];
                        for (int i = 0; i < splitScores.length; i++) {
                            scores[i] = Integer.parseInt(splitScores[i]);
                        }

                        if (Arrays.stream(scores).anyMatch(score -> score > 100 || score < 0)) {
                            OutputWriter.displayException(ExceptionMessages.INVALID_SCORE);
                            continue;
                        }

                        if (scores.length > SoftUniCourse.NUMBER_OF_TASK_ON_EXAM) {
                            OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
                            continue;
                        }

                        if (!this.students.containsKey(studentName)) {
                            this.students.put(studentName, new SoftUniStudent(studentName));
                        }

                        if (!this.courses.containsKey(courseName)) {
                            this.courses.put(courseName, new SoftUniCourse(courseName));
                        }

                        Course course = courses.get(courseName);
                        Student student = students.get(studentName);
                        student.enrollInCourse(course);
                        student.setMarksInCourse(courseName, scores);
                        course.enrollStudent(student);
                    } catch (NumberFormatException nfe) {
                        int lineIndex = Thread.currentThread().getStackTrace()[2].getLineNumber();
                        OutputWriter.displayException(nfe.getMessage() + " at line: " + lineIndex);
                    }


                }


            }

            OutputWriter.writeMessageOnNewLine("Data read.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getStudentsMarksInCourse(String course, String student) {
        if (isQueryForStudentPossiblе(course, student)) {
            return;
        }
        double mark = this.courses.get(course).getStudentsByName().get(student).getMarksByCourseName().get(course);
        String output = students.get(student).getMarkForCourse(course);
        OutputWriter.writeMessageOnNewLine(output);
    }

    public void getStudentsByCourse(String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }

        OutputWriter.writeMessageOnNewLine(course + ":");
        for (Map.Entry<String, Student> student : this.courses.get(course).getStudentsByName().entrySet()) {
            this.getStudentsMarksInCourse(course, student.getKey());
        }
    }

    @Override
    public SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> comparator) {
        SimpleSortedList<Course> courseSortedList = new SimpleSortedList<Course>(Course.class,comparator);
        courseSortedList.addAll(this.courses.values());
        return courseSortedList;
    }

    @Override
    public SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> comparator) {
           SimpleSortedList<Student> studentSortedList = new SimpleSortedList<Student>(Student.class,comparator);
        studentSortedList.addAll(this.students.values());
        return studentSortedList;
    }


    private boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }
        if (!this.courses.containsKey(courseName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_COURSE);
            return false;
        }
        return true;
    }

    private boolean isQueryForStudentPossiblе(String courseName, String studentName) {
        if (!isQueryForCoursePossible(courseName)) {
            return false;
        }

        if (!this.courses.get(courseName).getStudentsByName().containsKey(studentName)) {
            throw new IllegalArgumentException(ExceptionMessages.NON_EXISTING_STUDENT);
        }
        return true;


    }


    public void filterAndTake(String courseName, String filter) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        filterAndTake(courseName, filter, studentsToTake);
    }

    private void filterAndTake(
            String courseName, String filter, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }

        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry : this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourseName().get(courseName));
        }
        this.filter.printFilteredStudents(marks, filter, studentsToTake);
    }

    private void orderAndTake(
            String courseName, String orderType, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }

        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry : this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourseName().get(courseName));
        }
        this.sorter.printSortedStudents(marks, orderType, studentsToTake);
    }

    public void orderAndTake(String courseName, String orderType) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        orderAndTake(courseName, orderType, studentsToTake);
    }

}
