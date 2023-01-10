package src.Ex2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;



/*
        Callable a = Executors.callable(runnable, result);

        this.type = a.call();
        // t=Task.createTask(Executors.callable(runnable, result),TaskType.IO);
        // System.out.println(t.toString());
        // System.out.println(t.getType().getPriorityValue());
        */
public class FutureTaskAdapter<V> extends FutureTask<V> {
    private Task task;

    public FutureTaskAdapter(Callable<V> callable) {
        super(callable);
        this.task= (Task)callable;

    }

    public Task getTask() {
        return task;
    }


}