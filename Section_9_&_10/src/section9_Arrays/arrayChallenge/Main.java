package section9_Arrays.arrayChallenge;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
        Create a program using arrays, that sorts a list of integers, in descending order.
        Descending order means from highest value to lowest.

        In other words, if the array has the values 50, 25, 80, 5, and 15, your program should return an array, with the
        values in the descending order: 80, 50, 25, 15, and 5.

        First, create an array of randomly generated integers.

        Print the array before you sort it.

        And print the array after you sort it.

        You can choose to create a new sorted array, or just sort the current array.
        */

        int n = 10;
        int[] arr = getRandomArray(n);
        System.out.println(Arrays.toString(arr));
        // Insertion sort
        for (int i=1; i<n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j]<=temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int[] getRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
