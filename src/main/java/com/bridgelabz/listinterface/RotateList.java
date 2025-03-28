package com.bridgelabz.listinterface;

import java.util.*;

public class RotateList {
    public static List<Integer> rotateList(List<Integer> list, int rotationCount) {
        int effectiveRotationCount = rotationCount % list.size();
        List<Integer> rotatedList = new ArrayList<>(list);

        // Rotate the list
        Collections.rotate(rotatedList, -effectiveRotationCount);

        return rotatedList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("Enter the number of rotations");
        int rotationCount = sc.nextInt();

        List<Integer> rotatedList = rotateList(list, rotationCount);
        System.out.println("Rotated List: " + rotatedList);
    }
}


