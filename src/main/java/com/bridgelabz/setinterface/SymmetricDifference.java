package com.bridgelabz.setinterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        unionSet.removeAll(intersectionSet);
        return unionSet;
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

        Set<Integer> symDiffSet = symmetricDifference(setA, setB);

        System.out.println("Symmetric Difference: " + symDiffSet);

        scanner.close();
    }
}