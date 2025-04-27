package section9_Arrays.minimumElementChallenge;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            Write a method called readIntegers, that reads a comma delimited list of numbers, entered by the user from
            the console, and then returns an array, containing those numbers that were entered.

            Nest, write a method called findMin, that takes the array as an argument, and returns the minimum value
            found in that array.

         */
        int[] arr = readIntegers();
        System.out.println(findMin(arr));
    }

    private static int findMin(int[] arr) {
        int n = arr.length;
        int result = arr[0];
        for (int i=1; i<n; i++) {
            if (result>arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }

    private static int[] readIntegers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(",");
        int n = input.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input[i].trim());
        }
        return arr;
    }
}
