package com.lazyevaluation;

import com.lazyevaluation.QueueExecutions;
import com.lazyevaluation.Function;

public class LazyEvaluationExecutionsOrchestrator {
    private QueueExecutions queueExecutions;

    private static LazyEvaluationExecutionsOrchestrator instance = null;

    public LazyEvaluationExecutionsOrchestrator() {
        this.queueExecutions = new QueueExecutions();
    }

    public static LazyEvaluationExecutionsOrchestrator getInstance() {
        if (instance == null) {
            instance = new LazyEvaluationExecutionsOrchestrator();
        }
        return instance;
    }

    public void action(Function function) {
        queueExecutions.dequeueAll();
        function.execute();
    }

    public void transformation(Function function) {
        queueExecutions.enqueue(function);
    }
}
