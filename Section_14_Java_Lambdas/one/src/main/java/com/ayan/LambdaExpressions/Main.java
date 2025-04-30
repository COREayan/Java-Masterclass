package com.ayan.LambdaExpressions;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                List.of("alpha", "bravo", "charlie", "delta")
        );

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-------");
        list.forEach(myString -> System.out.println(myString));
        list.forEach((var myString) -> System.out.println(myString));
        list.forEach((String myString) -> System.out.println(myString));

        System.out.println("------");
        String prefix = "nato";
//        String myString = "enclosing Method's myString";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });
//        prefix = "NATO";
//        System.out.println(myString);

//        int result = calculator((a, b) -> a+b, 5, 2);
        var result2 = calculator((var a, var b) -> a + b, 10, 5);
        var result3 = calculator((a, b) -> a/b, 10.0, 2.5);
        var result4 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kramden");
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
