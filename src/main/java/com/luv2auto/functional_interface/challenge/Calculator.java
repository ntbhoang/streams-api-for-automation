package com.luv2auto.functional_interface.challenge;

import java.util.HashMap;
import java.util.Map;


@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}


class Calculator {
    private static final Map<String, MathOperation> operations = new HashMap<>();

    static {
        operations.put("+", Integer::sum);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);
    }

    Calculator() {}

    public static void addOperation(String op, MathOperation m) {
        operations.put(op, m);
    }

    public static int calculate(String expression) {
        String[] elements = expression.split(" ");
        int onScreenNumber = Integer.parseInt(elements[0]);
        for (int i = 1; i < elements.length; i = i + 2) {
            String op = elements[i];
            int enteredNumber = Integer.parseInt(elements[i + 1]);
            onScreenNumber = cal(onScreenNumber, operations.get(op), enteredNumber);
        }
        return onScreenNumber;
    }

    private static int cal(int onScreenNumber, MathOperation m, int enteredNumber) {
        return m.operate(onScreenNumber, enteredNumber);
    }
}

class Demo {
    public static void main(String[] args) {
        Calculator.addOperation("%", (a, b) -> a % b);

        System.out.println(Calculator.calculate("7 - 3 * 2 % 5"));
    }
}
