package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionAndIntersection {
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read first set
        System.out.print("Enter number of elements in first set: ");
        int size1 = scanner.nextInt();
        Set<Integer> setA = new HashSet<>();
        System.out.println("Enter elements of first set:");
        for (int i = 0; i < size1; i++) {
            setA.add(scanner.nextInt());
        }

        // Read second set
        System.out.print("Enter number of elements in second set: ");
        int size2 = scanner.nextInt();
        Set<Integer> setB = new HashSet<>();
        System.out.println("Enter elements of second set:");
        for (int i = 0; i < size2; i++) {
            setB.add(scanner.nextInt());
        }

        Set<Integer> unionSet = union(setA, setB);
        Set<Integer> intersectionSet = intersection(setA, setB);

        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);

        scanner.close();
    }
}
