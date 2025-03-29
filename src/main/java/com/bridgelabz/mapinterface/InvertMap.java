package com.bridgelabz.mapinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InvertMap {
    public static void main(String[] args) {
        // Scanner class to get user's input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        // Declaration of hashmap
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<size; i++){
            String key = scanner.nextLine();
            int value = scanner.nextInt();
            scanner.nextLine();
            map.put(key,value);
        }

        Map<Integer, ArrayList<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();

            // Add the key to the list for the corresponding value
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        System.out.println(inverted);
    }
}