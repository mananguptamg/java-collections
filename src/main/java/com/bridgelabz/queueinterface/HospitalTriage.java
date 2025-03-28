package com.bridgelabz.queueinterface;

import java.util.PriorityQueue;
import java.util.Scanner;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        // Taking user input
        System.out.print("Enter number of patients: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();
            System.out.print("Enter severity ");
            int severity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            queue.add(new Patient(name, severity)); // Add patient to the queue
        }

        System.out.println("\nPatients treatment order");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        scanner.close();
    }
}

