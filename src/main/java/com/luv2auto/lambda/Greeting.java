package com.luv2auto.lambda;

// SAM: Single Abstract Method
@FunctionalInterface
interface GreetingService {
    void greet();
}


@FunctionalInterface
interface NameService {
    String toCapital(String name);
}


class Demo {
    public static void main(String[] args) {

        // Normally we would do this
        GreetingService g1 = new GreetingService() {
            @Override
            public void greet() {
                System.out.println("Hello World");
            }
        };

        g1.greet();

        // with lambda, we can do this
        GreetingService greetService = () -> System.out.println("Hello World Lambda");
        greetService.greet();


        NameService nameService = String::toUpperCase;
        System.out.println(nameService.toCapital("hello"));
    }
}