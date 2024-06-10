package com.luv2auto.functional_interface.function;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Demo {

    public static void main(String[] args) {
        // Give me a string, I will give you the length of the string (in Integer)
        ToIntFunction<String> strLen = String::length;
        System.out.println(strLen.applyAsInt("Hello"));

        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5));

    }

}

