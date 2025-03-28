package com.bridgelabz.listinterface;

import java.util.*;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new LinkedHashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer element : list) {
            if (seen.add(element)) {
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 10, 40, 50, 20, 60);
        List<Integer> result = removeDuplicates(list);
        System.out.println("List without duplicates: " + result);
    }
}

