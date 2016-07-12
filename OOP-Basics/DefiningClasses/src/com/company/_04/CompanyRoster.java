package com.company._04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CompanyRoster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        HashMap<String, LinkedList<Employee>> employes = new HashMap<>();
        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            String name = info[0];
            double salary = Double.parseDouble(info[1]);
            String position = info[2];
            String department = info[3];
            int age = -1;
            String email = "n/a";
            if (info.length == 6) {
                email = info[4];
                age = Integer.parseInt(info[5]);
            }

            if (info.length == 5) {
                try {
                    age = Integer.parseInt(info[4]);
                } catch (Exception e) {
                    email = info[4];
                }
            }

            if (!employes.containsKey(department)) {
                employes.put(department, new LinkedList<>());
            }

            employes.get(department).add(new Employee(name, salary, position, department, age, email));

        }

        String most = "";
        double mostSum = 0;
        for (Map.Entry<String, LinkedList<Employee>> employee : employes.entrySet()) {
            double sum = 0;
            for (Employee em : employee.getValue()) {
                sum += em.salary;
            }

            if (sum > mostSum){
                most = employee.getKey();
                mostSum = sum;
            }
        }

        System.out.printf("Highest Average Salary: %s%n",most);
        employes.get(most).stream().sorted((a,b) -> Double.compare(b.salary,a.salary)).forEach(a -> System.out.printf("%s %.2f %s %d%n",a.name,a.salary,a.email,a.age));


    }
}

class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;


    public Employee(String name, double salary, String position, String department, int age, String email) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.email = email;
    }
}
