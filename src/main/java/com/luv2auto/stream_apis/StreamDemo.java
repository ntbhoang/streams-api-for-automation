package com.luv2auto.stream_apis;

import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // check for even numbers
        // only get 3 numbers
        // calculate the square of each number
        // print the result

        // Stream laziness
        System.out.println("starting stream operation");
        list.stream()
            .filter(num -> {
                System.out.println("filtering " + num);
                return num % 2 == 0;
            })
                .limit(3)
            .map(num -> {
                System.out.println("mapping " + num);
                return num * num;
            })
            .forEach(System.out::println);

        System.out.println("ending stream operation");
        System.out.println("If you don't call terminal operation, nothing will happen.");


        /*
                 Output:
                 - Check for the odd numbers
                 - Ensure number > 4
                 - Calculate the square of each number, then plus 10
                    - Print the result
         */

        List<Integer> numbers = List.of(1, 4, 5, 6, 7, 8, 463, 46);
        numbers.stream()
                .filter(num -> {
                    System.out.println("Filtering " + num);
                    return num % 2 != 0;
                })
                .filter(num -> {
                    System.out.println("Filtering " + num);
                    return num > 4;
                })
                .map(num -> {
                    System.out.println("Mapping " + num);
                    return num * num + 10;
                })
                .forEach(System.out::println);
    }
}
