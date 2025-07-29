package com.ayan.challenge;

import java.time.LocalDate;
import java.util.*;

record Employee(String first, String last, String hireDate) {
}

public class Solution {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", "Doe", "2020-05-15"),
                new Employee("Jane", "Smith", "2018-08-10"),
                new Employee("Ayanabha", "Pramanik", "2022-03-01"),
                new Employee("Emily", "Clark", "2019-11-20"),
                new Employee("Michael", "Brown", "2021-07-05")
        );

        printOrderedList(employees, "name");

        System.out.println();

        printOrderedList(employees, "year");

    }

    public static void printOrderedList(List<Employee> eList, String sortField) {
        int currentYear = LocalDate.now().getYear();

        class MyEmployee {
            Employee containedEmployee;
            int yearsWorked;
            String fullName;

            public MyEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(containedEmployee.hireDate().split("-")[0]);
                fullName = String.join(" ", containedEmployee.first(), containedEmployee.last());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        List<MyEmployee> list = new ArrayList<>();
        for (Employee employee : eList) {
            list.add(new MyEmployee(employee));
        }

        var comparator = new Comparator<MyEmployee>() {

            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if (sortField.equals("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);

        for (MyEmployee myEmployee : list) {
            System.out.println(myEmployee);
        }
    }
}
