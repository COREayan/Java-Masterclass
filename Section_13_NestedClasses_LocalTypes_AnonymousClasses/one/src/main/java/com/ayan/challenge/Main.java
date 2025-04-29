package com.ayan.challenge;

import java.time.LocalDate;
import java.util.*;

// Step 1 : Created a record named Employee,
record Engineer(String firstName, String lastName, LocalDate hireDate) {}

public class Main {
    public static void main(String[] args) {
        // Step 2 : Setup a list of Employees with various names and hire dates in the main methods.
        List<Engineer> employeeList = Arrays.asList(
                new Engineer("John", "Doe", LocalDate.of(2020, 5, 15)),
                new Engineer("Jane", "Smith", LocalDate.of(2018, 8, 10)),
                new Engineer("Ayanabha", "Pramanik", LocalDate.of(2022, 3, 1)),
                new Engineer("Emily", "Clark", LocalDate.of(2019, 11, 20)),
                new Engineer("Michael", "Brown", LocalDate.of(2021, 7, 5))
        );

        // Step 3 : Setup a new method that takes this list of Employees as a parameter.
        processEmployees(employeeList);
    }

    public static void processEmployees(List<Engineer> employees) {
        // Step 4 : Create a local class to wrap this class, (pass Employee to the constructor and include a field for this) and add some calculated fields, such as fullname, and years worked.
        class EmployeeInfo {
            private Engineer originalEmployee;
            private String fullName;
            private int yearsWorked;

            public EmployeeInfo(Engineer employee) {
                this.originalEmployee = employee;
                this.fullName = employee.firstName() + " " + employee.lastName();
                this.yearsWorked = LocalDate.now().getYear() - employee.hireDate().getYear();
            }

            public String getFullName() {
                return this.fullName;
            }

            public int getYearsWorked() {
                return this.yearsWorked;
            }

            @Override
            public String toString() {
                return fullName + " - " + yearsWorked + " years";
            }
        }
        // Step 5: Create a list of employees using your local class.
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        for (Engineer employee : employees) {
            employeeInfos.add(new EmployeeInfo(employee));
        }

        // Step 6: Create an anonymous class to sort your local class employees, by full name, or years worked.
        employeeInfos.sort(new Comparator<EmployeeInfo>() {
            @Override
            public int compare(EmployeeInfo o1, EmployeeInfo o2) {
                return o1.fullName.compareTo(o2.fullName);
            }
        });
        System.out.println("Sorted by full name:");
        System.out.println(employeeInfos);

        // Step 7: sort by years worked
        employeeInfos.sort(new Comparator<EmployeeInfo>() {
            @Override
            public int compare(EmployeeInfo o1, EmployeeInfo o2) {
                return o2.yearsWorked - o1.yearsWorked;
            }
        });

        System.out.println("Sorted by years worked:");
        System.out.println(employeeInfos);
    }
}
