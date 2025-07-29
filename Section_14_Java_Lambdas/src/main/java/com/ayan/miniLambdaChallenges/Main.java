package com.ayan.miniLambdaChallenges;

import java.util.Arrays;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        printTheParts.accept("Let's split this up into an array");
        printWordsLambda.accept("Let's split this up into an array");

        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        printWordsForEach.accept("Let's split this up into an array");

        Consumer<String> printWordsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };
        printWordsConcise.accept("Let's split this up into an array");

        Function<String, String> everySecondChar = source -> {
            StringBuilder  returnVal = new StringBuilder();
            for (int i=0; i<source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        UnaryOperator<String> everySecondCharUnary = source -> {
            StringBuilder  returnVal = new StringBuilder();
            for (int i=0; i<source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };


        System.out.println(everySecondCharUnary.apply("1234567890"));

        System.out.println(everySecondCharacter(everySecondCharUnary, "1234567890"));

        String result = everySecondCharacter(everySecondChar, "1234567890");
        System.out.println(result);

        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava2 = () -> { return "I love Java!"; };

        System.out.println(iLoveJava.get());
    }

    public static String everySecondChar(String source) {
        StringBuilder  returnVal = new StringBuilder();
        for (int i=0; i<source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
