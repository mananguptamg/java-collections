package com.bridgelabz.mapinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HighestValueKey {
    public static void main(String[] args) {
        // Scanner class to get user's input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        // Declaration of hashmap
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String key = scanner.nextLine();
            int value = scanner.nextInt();
            scanner.nextLine();
            map.put(key, value);
        }

        int maxValue = Integer.MIN_VALUE;
        String str = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > maxValue){
                str = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        System.out.println("Key with highest value is "+str);
    }
}

