package com.luv2auto.functional_interface.predicate;

import java.util.function.IntPredicate;

public class PredicateDemo {
    public static void main(String[] args) {
        IntPredicate isEven = n -> n % 2 == 0;
        IntPredicate isLessThan100 = n -> n < 100;
        System.out.println(isEven.and(isLessThan100).test(50));
        System.out.println(isEven.and(isLessThan100).test(101));
    }
}
