package com.lazyevaluation;

import com.lazyevaluation.QueueExecutions;

public class App {

    public static void main(String[] args) {
        QueueExecutions executions = new QueueExecutions();
        executions.enqueue(() -> System.out.println("Función 1 ejecutada"));
        executions.enqueue(() -> System.out.println("Función 2 ejecutada"));
        executions.enqueue(() -> System.out.println("Función 3 ejecutada"));

        // Desencolar y ejecutar las funciones
        executions.dequeueAll();
    }
}
