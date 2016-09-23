package com.company.main.contracts;

import java.util.HashMap;

public interface DataSorter {
    void printSortedStudents(HashMap<String, Double> studentsWithMarks, String comparisonType, Integer numberOfStudents);
}
