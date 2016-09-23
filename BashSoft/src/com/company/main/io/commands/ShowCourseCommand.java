package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;

@Alias("show")
public class ShowCourseCommand  extends Command implements Executable {
    @Inject
    private Database repository;
    public ShowCourseCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght( 2) || checkLenght(3)) {

            if (data.length == 2) {
                String courseName = data[1];
                this.repository.getStudentsByCourse(courseName);
            }


            if (data.length == 3) {
                String courseName = data[1];
                String user = data[2];
                this.repository.getStudentsMarksInCourse(courseName, user);
            }
        }

    }
}
