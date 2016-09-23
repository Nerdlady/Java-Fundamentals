package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;
import com.company.main.exceptions.InvalidCommandException;
import com.company.main.io.OutputWriter;

import java.util.Comparator;

@Alias("display")
public class DisplayCommand extends Command {
    @Inject
    private Database repository;
    public DisplayCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght(3)){
            String entityToDisplay = data[1];
            String sortType = data[2];
            if (entityToDisplay.equalsIgnoreCase("students")){
                Comparator<Student> studentComparator = this.createStudentComaparator(sortType);
                SimpleOrderedBag<Student> list = this.repository.getAllStudentsSorted(studentComparator);
                OutputWriter.writeMessageOnNewLine(list.joinWith(System.lineSeparator()));
            } else if (entityToDisplay.equalsIgnoreCase("courses")){
                Comparator<Course> courseComparator = this.createCourseComaparator(sortType);
                SimpleOrderedBag<Course> list = this.repository.getAllCoursesSorted(courseComparator);
                OutputWriter.writeMessageOnNewLine(list.joinWith(System.lineSeparator()));
            }
        }

    }

    private Comparator<Course> createCourseComaparator(String sortType) {
        if (sortType.equalsIgnoreCase("ascending")){
            return ((o1, o2) -> o1.compareTo(o2));
        } else if (sortType.equalsIgnoreCase("descending")){
            return (o1, o2) -> o2.compareTo(o1);
        } else {
            throw new InvalidCommandException(this.getInput());
        }
    }

    private Comparator<Student> createStudentComaparator(String sortType) {
        if (sortType.equalsIgnoreCase("ascending")){
            return ((o1, o2) -> o1.compareTo(o2));
        } else if (sortType.equalsIgnoreCase("descending")){
            return (o1, o2) -> o2.compareTo(o1);
        } else {
            throw new InvalidCommandException(this.getInput());
        }
    }
}
