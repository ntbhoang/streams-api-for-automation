package com.luv2auto.functional_interface.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> dbConsumer = db -> System.out.println("Connecting to " + db);
        Consumer<String> loggingConsumer = log -> System.out.println("Logging " + log);

        // Instead of multiple consumers, we can use this instead
        Consumer<String> logAllTheDbSystems = dbConsumer
                .andThen(loggingConsumer)
                .andThen(fileLog -> System.out.println("Logging to file " + fileLog));

        logAllTheDbSystems.accept("MySQL");
    }
}
