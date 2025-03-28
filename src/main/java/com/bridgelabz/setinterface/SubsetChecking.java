package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubsetChecking {
    public static <T> boolean isSubset(Set<T> subset, Set<T> mainSet) {
        return mainSet.containsAll(subset);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read first set
        System.out.print("Enter number of elements in first set (subset): ");
        int size1 = scanner.nextInt();
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of first set:");
        for (int i = 0; i < size1; i++) {
            set1.add(scanner.nextInt());
        }

        // Read second set
        System.out.print("Enter number of elements in second set (main set): ");
        int size2 = scanner.nextInt();
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of second set:");
        for (int i = 0; i < size2; i++) {
            set2.add(scanner.nextInt());
        }

        // Check if set1 is a subset of set2
        System.out.println("Is the first set a subset of the second set? " + isSubset(set1, set2));

        scanner.close();
    }
}

