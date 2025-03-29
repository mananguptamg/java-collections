package com.bridgelabz.mapinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MergeSet {
    public static void main(String[] args) {
        // Scanner class to get user's input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        // Declaration of hashmap
        Map<String, Integer> firstmap = new HashMap<>();
        Map<String, Integer> secondmap = new HashMap<>();

        System.out.println("Enter elements in first map:");
        for (int i = 0; i < size; i++) {
            String key = scanner.nextLine();
            int value = scanner.nextInt();
            scanner.nextLine();
            firstmap.put(key, value);
        }

        System.out.println("Enter elements in second map:");
        for (int i = 0; i < size; i++) {
            String key = scanner.nextLine();
            int value = scanner.nextInt();
            scanner.nextLine();
            secondmap.put(key, value);
        }

        // merging of first set and second set
        for(Map.Entry<String,Integer> entry : secondmap.entrySet()){
            // checking the key is present or not
            if(firstmap.containsKey(entry.getKey())){
                firstmap.put(entry.getKey(), firstmap.get(entry.getKey()) + entry.getValue());
            }
            else {
                firstmap.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println("Merged set:");
        System.out.println(firstmap);
    }
}