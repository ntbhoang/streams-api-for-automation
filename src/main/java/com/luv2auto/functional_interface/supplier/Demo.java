package com.luv2auto.functional_interface.supplier;

import java.util.function.DoubleSupplier;



public class Demo {
    public static void main(String[] args) {
        DoubleSupplier randomValue = Math::random;
        System.out.println(randomValue.getAsDouble());
    }
}
