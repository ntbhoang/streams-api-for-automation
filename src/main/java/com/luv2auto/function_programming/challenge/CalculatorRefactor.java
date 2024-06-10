package com.luv2auto.function_programming.challenge;


@FunctionalInterface
interface MathOperationRefactor {
    int operate(int a, int b);
}


class Demo {

    public static void main(String[] args) {
        MathOperationRefactor add = Integer::sum;
        MathOperationRefactor subtract = (a, b) -> a - b;
        MathOperationRefactor multiply = (a, b) -> a * b;
        MathOperationRefactor divide = (a, b) -> (b == 0) ? -1 : a / b;

        int onScreenNumber = calculate(5, add, 2);
        onScreenNumber = calculate(onScreenNumber, subtract, 3);
        onScreenNumber = calculate(onScreenNumber, multiply, 7);
        onScreenNumber = calculate(onScreenNumber, add, 2);
        onScreenNumber = calculate(onScreenNumber, divide, 3);

        System.out.println(onScreenNumber);  // 10

    }

    private static int calculate(int onScreenNumber, MathOperationRefactor m, int enteredNumber) {
        return m.operate(onScreenNumber, enteredNumber);
    }
}
