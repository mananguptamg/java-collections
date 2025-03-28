package com.bridgelabz.queueinterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryNumberInQueue {
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String binary = queue.remove(); // Dequeue current binary number
            System.out.print(binary + " "); // Print the binary number

            queue.add(binary + "0"); // Enqueue next binary numbers
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        System.out.println("First " + N + " binary numbers:");
        generateBinaryNumbers(N);

        scanner.close();
    }
}

