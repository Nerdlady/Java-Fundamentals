package com.company;



import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StudentsJoinedToSpecialties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new LinkedList<Student>();
        List<StudentSpecialty> students = new LinkedList<StudentSpecialty>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Students:")) {
                break;
            }
            String[] info = line.split("\\s+");
            String fName = info[0] + " " + info[1];
            Integer fMumber = Integer.parseInt(info[2]);

            students.add(new StudentSpecialty(fName, fMumber));
        }

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("END")) {
                break;
            }


            String[] info = line.split("\\s+");
            String name = info[1] + " " + info[2];
            Integer fMumber = Integer.parseInt(info[0]);

            studentList.add(new Student(name, fMumber));


        }


        studentList.stream().sorted((a,b) -> a.getName().compareTo(b.getName()))
                .flatMap(new Function<Student, Stream<?>>() {
            @Override
            public Stream<?> apply(Student student) {
                StringBuilder out = new StringBuilder();
                out.append("");
                for (StudentSpecialty studentSpecialty : students) {

                    if (student.getFNumber().equals(studentSpecialty.getFNumber())){

                       out.append(student.getName())
                               .append(" ")
                               .append(student.getFNumber())
                               .append(" ")
                               .append(studentSpecialty.getSpeciality())
                               .append("\n");

                    }

                }
                return   Stream.of(out.toString());
            }
        }).forEach(a -> System.out.print(a));
    }

}

class StudentSpecialty {

    String specialty;
    Integer facultyNumber;

    public StudentSpecialty(String specialty, Integer fNumber) {
        this.specialty = specialty;
        this.facultyNumber = fNumber;
    }

    public String getSpeciality() {
        return specialty;
    }

    public Integer getFNumber() {
        return facultyNumber;
    }

}

class Student {

    String name;
    Integer facultyNumber;

    public Student(String name, Integer fNumber) {
        this.name = name;
        this.facultyNumber = fNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getFNumber() {
        return facultyNumber;
    }

}
