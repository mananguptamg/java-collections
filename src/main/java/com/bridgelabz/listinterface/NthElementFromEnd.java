package com.bridgelabz.listinterface;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class NthElementFromEnd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.print("Enter Nth position from back: ");
        int k = input.nextInt();

        // Display the result
        try{
            System.out.printf("The %dth element from back is: %c", k, findNthElement(list, k));
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }

    // method t find nth element
    public static int findNthElement(LinkedList<Integer> list, int k) {
        // Make two pointers of head
        Iterator<Integer> first = list.iterator();
        Iterator<Integer> second = list.iterator();

        // loop first till k
        for(int i=0;i<k;i++) {
            if(first.hasNext()) first.next();
            else throw new IllegalArgumentException(k + " is larger than list size");
        }

        // now loop both first and second until first reaches to end
        while(first.hasNext()){
            first.next();
            second.next();
        }

        return second.next();
    }
}