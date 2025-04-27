package section9_Arrays.reverseArrayChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            The challenge is to write a method called reverse, that takes an int array as a parameter.

            In the main method, call the reverse method, and print the array both before and after the reverse method is called.

            To reverse the array, you have to swap the elements, so that the first element is swapped with the last element, and so on.

            So for example, if the array contains the numbers 1, 2, 3, 4, 5, then the reversed array should be 5, 4, 3, 2, 1.
         */

        int[] arr = readArray();
        System.out.println(Arrays.toString(arr));
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr) {
        int n = arr.length, temp = 0;
        for (int i=0; i<n/2; i++) {
            temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }

    private static int[] readArray() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = input.length;
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input[i].trim());
        }
        return arr;
    }
}
