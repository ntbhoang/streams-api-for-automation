package com.luv2auto.function_programming.challenge;


@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}


class CalculatorDemo {
    public static void main(String[] args) {
        MathOperation add = Integer::sum;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> (b == 0) ? -1 : a / b;

        System.out.println(calculate(10, 5, add));  // 15
        System.out.println(calculate(10, 5, subtract));  // 5
        System.out.println(calculate(10, 5, multiply));  // 50
        System.out.println(calculate(10, 5, divide));  // 2
        System.out.println(calculate(10, 0, divide));  // -1
    }

    private static int calculate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operate(a, b);
    }
}