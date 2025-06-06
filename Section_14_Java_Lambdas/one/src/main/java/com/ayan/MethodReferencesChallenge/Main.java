package com.ayan.MethodReferencesChallenge;

import java.util.*;
import java.util.function.UnaryOperator;

public class Main {
    private static Random random = new Random();

    private record Person(String first) {
        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }

    public static void main(String[] args) {
        List<String> stringArray = new ArrayList<>();
        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};
        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + getRandomChar('D', 'M') + ".",
                //s -> s += " " + reverse(s, 0, s.indexOf(" ")),
                Main::reverse,
                String::new,
                s -> new String(s)
        ));

        applyChanges(names, list);
    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions) {
        List<String> backedByArray = Arrays.asList(names);
        for (var function : stringFunctions) {
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }

    private static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar+1);
    }

    private static String reverse(String s) {
        return reverse(s, 0, s.length());
    }
}
