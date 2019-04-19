package com.example;

import static java.util.stream.Collectors.toMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstOccurrenceFinder {
    public static void main(String[] args) {
        String str = "MESSAGEMEDIAG";

        long start, end;

        start = System.currentTimeMillis();
        findFirstOneOccurrenceUsingMapMerge(str);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        findFirstOneOccurrence(str);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        findFirstOneOccurrenceUsingCollectorstoMap(str);
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    private static void findFirstOneOccurrence(String str) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, ++count);
        }

        printChar(map);
    }

    private static void findFirstOneOccurrenceUsingCollectorstoMap(String str) {
        Map<Character, Integer> map = str.chars()
                                         .boxed()
                                         .collect(toMap(k -> Character.valueOf((char) k.intValue()),
                                                        v -> 1,
                                                        Integer::sum,
                                                        LinkedHashMap::new
                                         ));

        printChar(map);
    }

    private static void findFirstOneOccurrenceUsingMapMerge(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        printChar(map);
    }

    private static void printChar(Map<Character, Integer> map) {
        final String callerMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        map.entrySet()
           .stream()
           .filter(entry -> entry.getValue() == 1)
           .findFirst()
           .ifPresent(entry -> System.out.println(callerMethodName + ": " + entry.getKey()));
    }
}
