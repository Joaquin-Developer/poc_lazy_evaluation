package com.lazyevaluation;

import java.util.LinkedList;
import java.util.Queue;
import com.lazyevaluation.Function;

public class QueueExecutions {
    private Queue<Function> queue;

    public QueueExecutions() {
        queue = new LinkedList<>();
    }

    public void enqueue(Function function) {
        queue.add(function);
    }

    public void dequeueAll() {
        while (!queue.isEmpty()) {
            Function function = queue.poll();
            function.execute();
        }
    }
}