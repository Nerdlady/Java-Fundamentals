package com.company._04WorkForce;

import com.company._04WorkForce.interfaces.Employee;
import com.company._04WorkForce.interfaces.Job;
import com.company._04WorkForce.models.CustomList;
import com.company._04WorkForce.models.JobImpl;
import com.company._04WorkForce.models.employees.PartTimeEmployee;
import com.company._04WorkForce.models.employees.StandartEmployee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Employee> employees = new HashMap<>();
        CustomList<Job> jobs = new CustomList<>();

        while (true){
            String line = reader.readLine();
            if (line.equals("End")){
                break;
            }

            String[] params = line.split("\\s+");

            switch (params[0]){
                case "Job":
                    String jobName = params[1];
                    int hoursOfWorkRequired = Integer.parseInt(params[2]);
                    String employeeName = params[3];
                    Employee employee = employees.get(employeeName);
                    Job job = new JobImpl(jobName,hoursOfWorkRequired,employee);
                    job.addJobListener(jobs);
                    jobs.add(job);
                    break;
                case "StandartEmployee":
                    String standartEmployeeName = params[1];
                    Employee standartEmployee = new StandartEmployee(standartEmployeeName);
                    employees.put(standartEmployeeName,standartEmployee);
                    break;
                case "PartTimeEmployee":
                    String partTimeEmployeeName = params[1];
                    Employee partTimeEmployee = new PartTimeEmployee(partTimeEmployeeName);
                    employees.put(partTimeEmployeeName,partTimeEmployee);
                    break;
                case "Pass":
                    ArrayList<Job> newJobs = new ArrayList<>(jobs);
                    for (Job newJob : newJobs) {
                        newJob.update();
                    }
                    break;
                case "Status":
                    for (Job job1 : jobs) {
                        System.out.println(job1.toString());
                    }
            }

        }
    }
}
