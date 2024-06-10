package com.luv2auto.function_programming;


@FunctionalInterface
interface StringLen {
    int getLen(String str);
}


public class FunctionalProgramming {
    public static void main(String[] args) {
        // Function as first class: Ability to assign a function to a var
        StringLen getStringLen = String::length;
        System.out.println(getStringLen.getLen("Hello World"));

        // Higher order function: Function that takes another function as an argument
        greetAndCalLen(getStringLen);



    }

    private static void greetAndCalLen(StringLen stringLen) {
        System.out.println(stringLen.getLen("Hello World") + " characters.");
    }

    // Different between normal function and higher order function
    // With normal function, if you give me the data, I will process it
    private static void normalToUpperCase(String str) {
        System.out.println(str.toUpperCase());
    }
}
