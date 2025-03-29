package com.bridgelabz.mapinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroupingElements {
    public static void main(String[] args) {
        // Scanner class to get user's input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        // Declaration of hashmap
        String[][] arr = new String[size][2];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<size; i++){
            String name = scanner.nextLine();
            String position = scanner.nextLine();
            arr[i][0] = name;
            arr[i][1] = position;
        }


        Map<String, ArrayList<String>> inverted = new HashMap<>();

        for (int i=0; i<size; i++) {
            String value = arr[i][0];
            String key = arr[i][1];

            // Add the key to the list for the corresponding value
            inverted.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        System.out.println(inverted);
    }
}
