package com.company.main.repository;

import com.company.main.contracts.DataFilter;
import com.company.main.io.OutputWriter;
import com.company.main.staticData.ExceptionMessages;

import java.util.HashMap;
import java.util.function.Predicate;

public class RepositoryFilter implements DataFilter {
    public  void printFilteredStudents(HashMap<String, Double> studentsWithMarks, String filterType, Integer numberOfStudents) {
        Predicate<Double> filter = createFilter(filterType);
        if (filter == null) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FILTER);
        }

        int studentsCount = 0;
        for (String student : studentsWithMarks.keySet()) {
            if (studentsCount == numberOfStudents) {
                break;
            }


            Double mark = studentsWithMarks.get(student);
            if (filter.test(mark)) {
                OutputWriter.writeMessageOnNewLine(String.format(
                        "%s - %f", student, mark));
                studentsCount++;
            }
        }

    }

    private  Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5.0;
            case "average":
                return mark -> mark >= 3.5 && mark < 5.0;
            case "poor":
                return mark -> mark < 3.5;
            default:
                return null;
        }
    }



}
