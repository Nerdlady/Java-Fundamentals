package com.company.main.repository;

import com.company.main.contracts.DataSorter;
import com.company.main.io.OutputWriter;
import com.company.main.staticData.ExceptionMessages;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorySorter implements DataSorter{

    public void printSortedStudents(HashMap<String, Double> studentsWithMarks, String comparisonType, Integer numberOfStudents) {
        comparisonType = comparisonType.toLowerCase();

        if (!comparisonType.equals("ascending") && !comparisonType.equals("descending")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPARISON_QUERY);
        }


        Comparator<Map.Entry<String, Double>> comparator = (x, y) -> Double.compare(x.getValue(), y.getValue());
        List<String> sortedStudents = studentsWithMarks.entrySet()
                .stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }

        printStudents(studentsWithMarks, sortedStudents);
    }

    private void printStudents(HashMap<String, Double> courseData, List<String> sortedStudents) {
        for (String student : sortedStudents) {
            OutputWriter.writeMessageOnNewLine(String.format(
                    "%s - %f", student, courseData.get(student)));
        }
    }
}
