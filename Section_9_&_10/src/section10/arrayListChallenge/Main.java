package section10.arrayListChallenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /*
            The ArrayList Challenge
                The challenge is to create an interactive console program.
                And give the user a menu of options as shown here :

                    Available actions :
                        0 - to exit
                        1 - to add item(s) to list (comma delimited list)
                        2 - to remove any items (comma delimited list)
                        Enter a number for which action you want to do :

                    Using the Scanner class, solicit a menu item, 0, 1, or 2, and process the item accordingly.

                    Your groceryList should be an ArrayList.

                    You should use methods on the ArrayList, to add items, remove items, check if an item is already
                    in the list, and print a sorted list.

                    You shouldn't allow duplicate items in the list.
        */
        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while (flag) {
            printActions();
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }

    private static void removeItems(ArrayList<String> groceries) {
        System.out.println("Remove items(s) [separate items by comma]:");
        String[] items = sc.nextLine().split(",");

        for (String i: items) {
            String trimmed = i.trim();
            groceries.remove(trimmed);
        }
    }

    private static void addItems(ArrayList<String> groceries) {
        System.out.println("Add item(s) [separate items by comma]:");
        String[] items = sc.nextLine().split(",");
//        groceries.addAll(List.of(items));
        for (String i: items) {
            String trimmed = i.trim();
            if (!groceries.contains(trimmed)) {
                groceries.add(trimmed);
            }
        }
    }

    private static void printActions() {
        System.out.println("Available actions:\n" +
                "0 - to shutdown\n" +
                "1 - to add item(s) to list (comma delimited list)\n" +
                "2 - to remove any items (comma delimited list)\n" +
                "Enter a number for which action you want to do : ");
    }
}
