package com.Aditya;

import java.util.HashMap;

public class OccuranceCouter {
    public static void countOccurrences(String str) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (Character key : charCountMap.keySet()) {
            System.out.println(key + " : " + charCountMap.get(key));
        }
    }

    public static void main(String[] args) {
        String str = "aaabbccccd";
        System.out.println("Counting occurrences of characters in the string: " + str);
       countOccurrences(str);
    }
}
