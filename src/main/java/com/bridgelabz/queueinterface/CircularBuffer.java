package com.bridgelabz.queueinterface;

public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int front;
    private int rear;
    private int count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = 0;
        count = 0;
    }

    // Insert an element into the buffer
    public void insert(int value) {
        if (count == size) {
            // Buffer is full, overwrite the oldest element
            front = (front + 1) % size;  // Move front pointer to the next element
        } else {
            count++;
        }

        // Insert the new element at the rear and move the rear pointer
        buffer[rear] = value;
        rear = (rear + 1) % size;
    }

    // Display the buffer content
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(3);

        // Insert elements into the buffer
        circularBuffer.insert(1);
        circularBuffer.insert(2);
        circularBuffer.insert(3);

        // Display the buffer
        circularBuffer.display();

        // Insert another element, overwriting the oldest (1)
        circularBuffer.insert(4);

        // Display the buffer after overwrite
        circularBuffer.display();
    }
}
