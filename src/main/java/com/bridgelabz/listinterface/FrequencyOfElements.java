package com.bridgelabz.listinterface;

import java.util.*;
public class FrequencyOfElements {
    public static Map<String, Integer> countFrequencies(List<String> strings) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequencyMap = countFrequencies(strings);
        System.out.println(frequencyMap);
    }
}