package _02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int count = 0;
    static  LinkedList<Student> students = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            String line = reader.readLine();
            try {
                if (line.equals("End") || line.isEmpty() || line == null){
                    break;
                }

                Student student = new Student(line);
                students.add(student);
            } catch (Exception e){
                break;
            }

        }

        System.out.println(count);
    }

    static class Student{
        String name;

        public Student(String name) {
            this.name = name;
            boolean contains = false;
            for (Student student : students) {
                if (student.name.equals(name)){
                    contains = true;
                }
            }

            if (!contains){
                count++;
            }

        }
    }
}

