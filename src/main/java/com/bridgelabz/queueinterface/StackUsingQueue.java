package com.bridgelabz.queueinterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        queue1.add(x);
    }

    // Pop operation
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        // Move elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int topElement = queue1.remove(); // Remove the last element (Stack pop)

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Top operation (peek)
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int topElement = queue1.peek(); // Peek at last element (Stack top)

        queue2.add(queue1.remove()); // Move the top element to queue2

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();

        // Take user input for stack operations
        System.out.print("Enter number of elements to push: ");
        int n = scanner.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        // Perform pop operation
        System.out.println("Popped element: " + stack.pop());

        scanner.close();
    }
}
