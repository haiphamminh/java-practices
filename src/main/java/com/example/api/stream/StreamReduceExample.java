package com.example.api.stream;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamReduceExample {
    public static void main(String[] args) {
        sumNumbers();
        concatCharacters();
        sumUserAge();
    }

    static void sumNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // use lambda expression
        int result = numbers.stream()
                            .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result);

        // use Integer::sum
        result = numbers.stream()
                        .reduce(0, Integer::sum);
        System.out.println(result);
    }

    static void concatCharacters() {
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println(result);

        result = letters
                .stream()
                .reduce("", String::concat);
        System.out.println(result);
    }

    static void sumUserAge() {
        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
        int computedAges = users.stream()
                                .reduce(0,
                                        (partialAgeResult, user) -> partialAgeResult + user.getAge(),
                                        Integer::sum);
        System.out.println(computedAges);
    }

    @Data
    @AllArgsConstructor
    private static class User {
        private String name;
        private Integer age;
    }
}
