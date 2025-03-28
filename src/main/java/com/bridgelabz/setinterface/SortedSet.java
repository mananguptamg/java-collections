package com.bridgelabz.setinterface;

import java.util.*;

public class SortedSet {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input set
        System.out.print("Enter number of elements in the set: ");
        int size = scanner.nextInt();
        Set<Integer> numSet = new HashSet<>();
        System.out.println("Enter elements of the set:");
        for (int i = 0; i < size; i++) {
            numSet.add(scanner.nextInt());
        }

        List<Integer> sortedList = convertToSortedList(numSet);

        System.out.println("Sorted List: " + sortedList);

        scanner.close();
    }
}