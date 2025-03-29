package com.bridgelabz.mapinterface;
import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args){
        // Scanner class to get user's input
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        // Declaration of hashmap
        Map<String, Integer> map = new HashMap<>();
        String subString = "";

        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == ' '){

                // checking the substring is already present or not
                if(map.containsKey(subString)){
                    map.put(subString,map.get(subString)+1);
                }
                else{
                    map.put(subString,1);
                }

                subString = "";
            }
            else{
                subString += str.charAt(i);
            }
        }

        if(map.containsKey(subString)){
            map.put(subString,map.get(subString)+1);
        }
        else{
            map.put(subString,1);
        }

        System.out.println(map);
    }
}